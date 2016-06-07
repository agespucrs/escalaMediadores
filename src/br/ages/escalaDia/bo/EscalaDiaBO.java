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
	

	
	public EscalaDia[] gerarEscala(LocalDate data) throws PersistenciaException, SQLException, ClassNotFoundException{
		this.data = data;
		gerarEscalaMediador();
		gerarAreaManha();
		return escalaMediadores;
	}
	
	public void gerarEscalaMediador() throws PersistenciaException, SQLException, ClassNotFoundException{
		ultimaEscala = escalaDiaDao.ultimaEscala(data);
		List<Mediador> mediadoresAtivos = mediadorDao.listaMediadoresAtivos(data); 
		escalaMediadores = new EscalaDia[mediadoresAtivos.size()];
		for (int i = 0; i < escalaMediadores.length; i++) {
			escalaMediadores[i] = new EscalaDia();
			escalaMediadores[i].setMediador(mediadoresAtivos.get(i));
		}
	}
	
	public void gerarAreaManha() throws ClassNotFoundException, PersistenciaException, SQLException{
		List<AreaConhecimento> areasDisponiveis = areaDao.listarAreasDisponiveis();
		for (int i = 0; i < escalaMediadores.length; i++) {
			AreaConhecimento ultimaArea = null;
			for(int a = 0; a < ultimaEscala.size(); a ++){
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
					escalaMediadores[i].setTurno(Turno.MANHÃ);
					novaArea.setNumeroMediadores(novaArea.getNumeroMediadores()-1);
					ultimaArea = novaArea;
					gerarAreaAlmoco(i,ultimaArea);
					procurando = false;
				}else{
					count++;
				}
				
			}
			
		}
	}
	
	
	
	
	public void gerarAreaAlmoco(int index, AreaConhecimento ultimaArea) throws ClassNotFoundException, PersistenciaException, SQLException{
		List<AreaConhecimento> areasDisponiveis = areaDao.listarAreasDisponiveis();
		boolean procurando = true;
		int count = 1;
		while(procurando){
			AreaConhecimento novaArea = areasDisponiveis.get((areasDisponiveis.indexOf(ultimaArea)+count)%areasDisponiveis.size());
			if (novaArea.getNumeroMediadores() > 0) {
				escalaMediadores[index].setArea(novaArea);
				escalaMediadores[index].setTurno(Turno.TARDE);
				novaArea.setNumeroMediadores(novaArea.getNumeroMediadores()-1);
				ultimaArea = novaArea;
				gerarAreaTarde(index,ultimaArea);
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
				escalaMediadores[index].setTurno(Turno.TARDE);
				novaArea.setNumeroMediadores(novaArea.getNumeroMediadores()-1);
				ultimaArea = novaArea;
				procurando = false;
			}else{
				count++;
			}
			
		}
	}
}
