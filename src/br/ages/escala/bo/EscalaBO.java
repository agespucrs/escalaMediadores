package br.ages.escala.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ages.escala.dao.EscalaDAO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.model.Ferias;

public class EscalaBO {

	EscalaDAO escalaDAO;
	
	public EscalaBO() {
		escalaDAO = new EscalaDAO();
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
}
