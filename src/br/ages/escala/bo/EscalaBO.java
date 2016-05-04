package br.ages.escala.bo;

import java.sql.SQLException;

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

}
