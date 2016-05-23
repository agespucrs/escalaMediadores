package br.ages.escalaDia.bo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.AreaConhecimento;
import br.ages.model.EscalaDia;
import br.ages.model.Mediador;

public class EscalaDiaBO {

	LocalDate data;
	EscalaDia[] escalaMediadores;
	AreaConhecimento[] area;
	MediadorDAO mediadorDao;
	
	
	public EscalaDia[] gerarEscala(LocalDate data) throws PersistenciaException, SQLException{
		this.data = data;
		gerarEscalaMediador();
		gerarAreaManha();
		gerarAreaAlmoco();
		gerarAreaTarde();
		return escalaMediadores;
	}
	
	public void gerarEscalaMediador() throws PersistenciaException, SQLException{
		
		List<Mediador> mediadoresAtivos = mediadorDao.listaMediadoresAtivos(data); 
		escalaMediadores = new EscalaDia[mediadoresAtivos.size()];
		for (int i = 0; i < escalaMediadores.length; i++) {
			escalaMediadores[i].mediador = mediadoresAtivos.get(i);
		}
	}
	
	public void gerarAreaManha(){
		
	}
	public void gerarAreaAlmoco(){
		
	}
	public void gerarAreaTarde(){
		
	}
}