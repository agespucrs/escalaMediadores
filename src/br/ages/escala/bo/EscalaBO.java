package br.ages.escala.bo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.escala.dao.EscalaDAO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.AreaConhecimento;
import br.ages.model.EscalaMediador;
import br.ages.model.Ferias;
import br.ages.model.Mediador;

public class EscalaBO {

	LocalDate data;
	EscalaMediador[] escalaMediadores;
	AreaConhecimento[] area;
	MediadorDAO mediadorDao;
	EscalaDAO escalaDAO;
	AreaConhecimentoDAO areaDao;
	
	public EscalaBO() {
		
		mediadorDao  = new MediadorDAO();
		escalaDAO = new EscalaDAO();
		areaDao = new AreaConhecimentoDAO();
	}
	
	public int criarFeriasEscala(Ferias ferias) throws NegocioException, SQLException, ClassNotFoundException{
		int id = 0;
		try{
			id = escalaDAO.criarFeriasEscala(ferias);
		} catch(ClassNotFoundException | PersistenciaException e){
			e.printStackTrace();
		}
		return id;
	}
	
	public void deletarFeriasPorId(int id){
		try{
			escalaDAO.deletarFeriasPorId(id);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Ferias> listarEscalaMensalPorMediador(int idMediador){
		ArrayList<Ferias> ferias = null;
		
		try {
			ferias = escalaDAO.listarEscalaMensalPorMediador(idMediador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ferias;
	}
	

	
	public EscalaMediador[] gerarEscala(LocalDate data) throws PersistenciaException, SQLException{
		this.data = data;
		gerarEscalaMediador();
		gerarAreaManha();
		gerarAreaAlmoco();
		gerarAreaTarde();
		return escalaMediadores;
	}
	
	public void gerarEscalaMediador() throws PersistenciaException, SQLException{
		
		List<Mediador> mediadoresAtivos = mediadorDao.listaMediadoresAtivos(data); 
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
