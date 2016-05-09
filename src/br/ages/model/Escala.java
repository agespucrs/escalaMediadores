package br.ages.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.ages.escala.dao.EscalaDAO;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;

public class Escala {

	Date data;
	private EscalaMediador[] escalaMediadores;
	private MediadorDAO mediadorDao = new MediadorDAO();
	private EscalaDAO escalaDao = new EscalaDAO();
	
	public EscalaMediador[] gerarEscala(Date data) throws PersistenciaException, SQLException{
		this.data = data;
		gerarMediadorE();
		gerarAreaManha();
		gerarAreaAlmoco();
		gerarAreaTarde();
		return escalaMediadores;
	}
	
	public void gerarMediadorE() throws PersistenciaException, SQLException{
		
		List<Mediador> mediadoresAtivos = mediadorDao.listaMediadoresAtivos(); 
		escalaMediadores = new EscalaMediador[mediadoresAtivos.size()];
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
