package br.ages.escalaMensal.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.escalaMensal.dao.EscalaMensalDAO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.Ferias;

public class EscalaMensalBO {

	
	MediadorDAO mediadorDao;
	EscalaMensalDAO escalaDAO;
	AreaConhecimentoDAO areaDao;
	
	public EscalaMensalBO() {
		
		mediadorDao  = new MediadorDAO();
		escalaDAO = new EscalaMensalDAO();
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

	public ArrayList<Object> listarEscalaMensal(String mes, String ano){
		ArrayList<Object> ferias = null;
		
		try {
			ferias = escalaDAO.listarEscalaMensal(mes, ano);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ferias;
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
	

	
	
}
