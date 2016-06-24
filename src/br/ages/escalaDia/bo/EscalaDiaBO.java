package br.ages.escalaDia.bo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.escalaDia.dao.EscalaDiaDAO;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.AreaConhecimento;
import br.ages.model.EscalaDia;
import br.ages.model.Mediador;
import br.ages.model.Tipo;
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
	List<AreaConhecimento> areasDisponiveis;
	int[] indexAreas;
	
	public EscalaDia[] gerarEscala(LocalDate data) throws PersistenciaException, SQLException, ClassNotFoundException{
		this.data = data;
		gerarEscalaMediador();
		gerarAreasDisponives();
		gerarAreaManha(mediadoresAtivos.size());
		return escalaMediadores;
	}
	
	private void gerarAreasDisponives() throws ClassNotFoundException, PersistenciaException, SQLException {
		areasDisponiveis = areaDao.listarAreasDisponiveis();
		indexAreas = new int[areasDisponiveis.size()*3];
		int tam = areasDisponiveis.size();
		for (int i = 0; i < tam; i++) {
			indexAreas[i] = areasDisponiveis.get(i).getNumeroMediadores();
			indexAreas[i+tam] = areasDisponiveis.get(i).getNumeroMediadores();
			indexAreas[i+tam+tam] = areasDisponiveis.get(i).getNumeroMediadores();
		}
	}
	
	private void gerarEscalaMediador() throws PersistenciaException, SQLException, ClassNotFoundException{
		ultimaEscala = escalaDiaDao.ultimaEscala();
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
			escalaMediadores[i].setData(data);
			escalaMediadores[i+tam].setData(data);
			escalaMediadores[i+tam+tam].setData(data);
			
		}
	}
	
	private void gerarAreaManha(int tam) throws ClassNotFoundException, PersistenciaException, SQLException{
		AreaConhecimento ultimaArea = areasDisponiveis.get(0);
		for (int i = 0; i < tam; i++) {
			
			for(int a = 0; a < ultimaEscala.size(); a++){
				if( (escalaMediadores[i].getMediador() == ultimaEscala.get(a).getMediador())){
					ultimaArea = ultimaEscala.get(a).getArea();
				}
			}
			
			boolean procurando = true;
			int count = 1;
			int qtdMediadores;
			while(procurando){
				int proximoIndex = areasDisponiveis.indexOf(ultimaArea)+count;
				
				while(proximoIndex >= areasDisponiveis.size()){proximoIndex = proximoIndex - areasDisponiveis.size();}
				
				qtdMediadores = proximoIndex;
				
				AreaConhecimento novaArea = areasDisponiveis.get(proximoIndex);
				if (indexAreas[qtdMediadores] > 0 &&
						escalaMediadores[i].getMediador().getTipoMediador() == novaArea.getTipoArea() &&
						novaArea != ultimaArea) {
					escalaMediadores[i].setArea(novaArea);
					indexAreas[qtdMediadores]--;
					ultimaArea = novaArea;
					gerarAreaAlmoco((i+tam),ultimaArea , tam);
					procurando = false;
					
				}else if(indexAreas[qtdMediadores] > 0 &&
						escalaMediadores[i].getMediador().getTipoMediador() == Tipo.DOIS && 
						count > areasDisponiveis.size() ){
					escalaMediadores[i].setArea(novaArea);
					indexAreas[qtdMediadores]--;
					ultimaArea = novaArea;
					gerarAreaAlmoco((i+tam),ultimaArea , tam);
					procurando = false;
				}else{
					qtdMediadores++;
					if (count > areasDisponiveis.size()*2) {
						procurando = false;
					}
					count++;
				}
			}
		}
	}
	
	
	
	
	private void gerarAreaAlmoco(int index, AreaConhecimento ultimaArea, int tam) throws ClassNotFoundException, PersistenciaException, SQLException{
		
		boolean procurando = true;
		int count = 1;
		int qtdMediadores;
		while(procurando){
			int proximoIndex = areasDisponiveis.indexOf(ultimaArea)+count;
			
			while(proximoIndex >= areasDisponiveis.size()){proximoIndex = proximoIndex - areasDisponiveis.size();}
			
			qtdMediadores = proximoIndex + areasDisponiveis.size();
			AreaConhecimento novaArea = areasDisponiveis.get(proximoIndex);
			if (indexAreas[qtdMediadores] > 0 &&
					escalaMediadores[index].getMediador().getTipoMediador() == novaArea.getTipoArea()&&
					novaArea != ultimaArea)  {
				indexAreas[qtdMediadores]--;
				escalaMediadores[index].setArea(novaArea);
				ultimaArea = novaArea;
				gerarAreaTarde((index+tam),ultimaArea);
				procurando = false;
			}else if(indexAreas[qtdMediadores] > 0 &&
					escalaMediadores[index].getMediador().getTipoMediador() == Tipo.DOIS && 
					count > areasDisponiveis.size()){
				escalaMediadores[index].setArea(novaArea);
				indexAreas[qtdMediadores]--;
				ultimaArea = novaArea;
				gerarAreaTarde((index+tam),ultimaArea);
				procurando = false;
			}else{
				qtdMediadores++;
				if (count > areasDisponiveis.size()*2) {
					procurando = false;
				}
				count++;
			}
		}
	}
	
	private void gerarAreaTarde(int index, AreaConhecimento ultimaArea) throws ClassNotFoundException, PersistenciaException, SQLException{
		
		boolean procurando = true;
		int count = 1;
		int qtdMediadores;
		while(procurando){
			int proximoIndex = areasDisponiveis.indexOf(ultimaArea)+count;
			
				while(proximoIndex >= areasDisponiveis.size()){proximoIndex = proximoIndex - areasDisponiveis.size();}
			
			qtdMediadores = proximoIndex + areasDisponiveis.size()*2;
			AreaConhecimento novaArea = areasDisponiveis.get(proximoIndex);
			if ((indexAreas[qtdMediadores] > 0 &&
					escalaMediadores[index].getMediador().getTipoMediador() == novaArea.getTipoArea()) &&
					novaArea != ultimaArea) {
				indexAreas[qtdMediadores]--;
				escalaMediadores[index].setArea(novaArea);
				procurando = false;
			}else if(indexAreas[qtdMediadores] > 0 &&
					escalaMediadores[index].getMediador().getTipoMediador() == Tipo.DOIS && 
					count > areasDisponiveis.size()){
				escalaMediadores[index].setArea(novaArea);
				indexAreas[qtdMediadores]--;
				ultimaArea = novaArea;
				procurando = false;
			}else{
				qtdMediadores++;
				if (count >areasDisponiveis.size()*2) {
					procurando = false;
				}
				count++;
			}
		}
	}
}
