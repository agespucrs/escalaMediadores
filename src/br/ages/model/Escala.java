package br.ages.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;

public class Escala {

	public class MediadorE{
		
		public Mediador mediador;
		public AreaConhecimento areaManha;
		public AreaConhecimento areaAlmoco;
		public AreaConhecimento areaTarde;
	
	}
	
	Date data;
	private MediadorE[] escalaMediadores;
	private MediadorDAO dao = new MediadorDAO();
	
	public MediadorE[] gerarEscala(Date data) throws PersistenciaException, SQLException{
		this.data = data;
		gerarMediadorE();
		gerarAreaManha();
		gerarAreaAlmoco();
		gerarAreaTarde();
		return escalaMediadores;
	}
	
	public void gerarMediadorE() throws PersistenciaException, SQLException{
		
		List<Mediador> mediadoresAtivos = dao.listaMediadoresAtivos(); 
		escalaMediadores = new MediadorE[mediadoresAtivos.size()];
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
