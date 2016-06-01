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

public class EscalaDiaBO {

	LocalDate data;
	EscalaDia[] escalaMediadores;
	EscalaDia[] ultimaEscala;
	AreaConhecimento[] area;
	AreaConhecimentoDAO areaDao;
	MediadorDAO mediadorDao;
	EscalaDiaDAO escalaDiaDao;
	

	
	public EscalaDia[] gerarEscala(LocalDate data) throws PersistenciaException, SQLException, ClassNotFoundException{
		this.data = data;
		gerarEscalaMediador();
		gerarAreaManha();
//		gerarAreaAlmoco();
//		gerarAreaTarde();
		return escalaMediadores;
	}
	
	public void gerarEscalaMediador() throws PersistenciaException, SQLException{
		
		List<Mediador> mediadoresAtivos = mediadorDao.listaMediadoresAtivos(data); 
		escalaMediadores = new EscalaDia[mediadoresAtivos.size()];
		for (int i = 0; i < escalaMediadores.length; i++) {
			escalaMediadores[i].setMediador(mediadoresAtivos.get(i));
		}
	}
	
	public void gerarAreaManha() throws ClassNotFoundException, PersistenciaException, SQLException{
		List<AreaConhecimento> areasDisponiveis = areaDao.listarAreasDisponiveis();
		for (int i = 0; i < escalaMediadores.length; i++) {
			//escalaMediadores[i].setArea(){}
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void gerarAreaAlmoco(){
		
	}
	
	public void gerarAreaTarde(){
		
	}
}
