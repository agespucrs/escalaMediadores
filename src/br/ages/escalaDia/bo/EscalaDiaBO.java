package br.ages.escalaDia.bo;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.escalaDia.dao.EscalaDiaDAO;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.AreaConhecimento;
import br.ages.model.EscalaDia;
import br.ages.model.Mediador;
import br.ages.model.Turno;

public class EscalaDiaBO {

	LocalDate data;
	EscalaDia[] escalaMediadores;
	List<EscalaDia> ultimaEscala;
	AreaConhecimento[] area;
	AreaConhecimentoDAO areaDao = new AreaConhecimentoDAO();
	MediadorDAO mediadorDao = new MediadorDAO();
	EscalaDiaDAO escalaDiaDao = new EscalaDiaDAO();
	List<Mediador> mediadoresAtivos;

	
	public EscalaDia[] gerarEscala(LocalDate data) throws PersistenciaException, SQLException, ClassNotFoundException{
		this.data = data;
		gerarEscalaMediador();
		gerarAreaManha(mediadoresAtivos.size());
		return escalaMediadores;
	}
	
	public void gerarEscalaMediador() throws PersistenciaException, SQLException, ClassNotFoundException{
		ultimaEscala = escalaDiaDao.ultimaEscala(data);
		mediadoresAtivos = mediadorDao.listaMediadoresAtivos(data);
		escalaMediadores = new EscalaDia[mediadoresAtivos.size()*3];
		int tam = mediadoresAtivos.size();
		for (int i = 0; i <mediadoresAtivos.size(); i++) {
			//declarando as escalas
			escalaMediadores[i] = new EscalaDia();
			escalaMediadores[i+tam] = new EscalaDia();
			escalaMediadores[i+tam+tam] = new EscalaDia();
			//adicionando mediador
			escalaMediadores[i].setMediador(mediadoresAtivos.get(i));
			escalaMediadores[i+tam].setMediador(mediadoresAtivos.get(i));
			escalaMediadores[i+tam+tam].setMediador(mediadoresAtivos.get(i));
			//adicionando turno
			escalaMediadores[i].setTurno(Turno.MANHÃ);
			escalaMediadores[i+tam].setTurno(Turno.TARDE);
			escalaMediadores[i+tam+tam].setTurno(Turno.NOITE);
			//adicionando data
			escalaMediadores[i].setData(LocalDate.now());
			escalaMediadores[i+tam].setData(LocalDate.now());
			escalaMediadores[i+tam+tam].setData(LocalDate.now());
			
		}
	}
	
	public void gerarAreaManha(int tam) throws ClassNotFoundException, PersistenciaException, SQLException{
		List<AreaConhecimento> areasDisponiveis = areaDao.listarAreasDisponiveis();
		for (int i = 0; i < tam; i++) {
			AreaConhecimento ultimaArea = areasDisponiveis.get(0);
			for(int a = 0; a < ultimaEscala.size(); a++){
				if( (escalaMediadores[i].getMediador() == ultimaEscala.get(a).getMediador())){
					ultimaArea = ultimaEscala.get(a).getArea();
				}
			}
			
			boolean procurando = true;
			int count = 1;
			while(procurando){
				AreaConhecimento novaArea = areasDisponiveis.get((areasDisponiveis.indexOf(ultimaArea)+count)%areasDisponiveis.size());
				if (novaArea.getNumeroMediadores() > 0) {
					escalaMediadores[i].setArea(novaArea);
					novaArea.setNumeroMediadores(novaArea.getNumeroMediadores()-1);
					ultimaArea = novaArea;
					gerarAreaAlmoco((i+tam),ultimaArea , tam);
					procurando = false;
				}else{
					count++;
				}
				
			}
			
		}
	}
	
	
	
	
	public void gerarAreaAlmoco(int index, AreaConhecimento ultimaArea, int tam) throws ClassNotFoundException, PersistenciaException, SQLException{
		List<AreaConhecimento> areasDisponiveis = areaDao.listarAreasDisponiveis();
		boolean procurando = true;
		int count = 1;
		while(procurando){
			AreaConhecimento novaArea = areasDisponiveis.get((areasDisponiveis.indexOf(ultimaArea)+count)%areasDisponiveis.size());
			if (novaArea.getNumeroMediadores() > 0) {
				escalaMediadores[index].setArea(novaArea);
				novaArea.setNumeroMediadores(novaArea.getNumeroMediadores()-1);
				ultimaArea = novaArea;
				gerarAreaTarde((index+tam),ultimaArea);
				procurando = false;
			}else{
				count++;
			}
			
		}
	}
	
	public void gerarAreaTarde(int index, AreaConhecimento ultimaArea) throws ClassNotFoundException, PersistenciaException, SQLException{
		List<AreaConhecimento> areasDisponiveis = areaDao.listarAreasDisponiveis();
		boolean procurando = true;
		int count = 1;
		while(procurando){
			AreaConhecimento novaArea = areasDisponiveis.get((areasDisponiveis.indexOf(ultimaArea)+count)%areasDisponiveis.size());
			if (novaArea.getNumeroMediadores() > 0) {
				escalaMediadores[index].setArea(novaArea);
				novaArea.setNumeroMediadores(novaArea.getNumeroMediadores()-1);
				procurando = false;
			}else{
				count++;
			}
			
		}
	}
}
