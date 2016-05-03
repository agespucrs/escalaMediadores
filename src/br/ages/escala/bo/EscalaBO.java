package br.ages.escala.bo;

import java.sql.SQLException;

import br.ages.escala.dao.EscalaDAO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;

public class EscalaBO {

	EscalaDAO escalaDAO;
	
	public EscalaBO() {
		escalaDAO = new EscalaDAO();
	}
	
	public int criarFeriasEscala(int day, int month, int year, int id_mediador, String tipoFolga) throws NegocioException, SQLException, ClassNotFoundException{
		int id = 0;
		try{
			id = escalaDAO.criarFeriasEscala(day, month, year, id_mediador, tipoFolga);
		} catch(ClassNotFoundException | PersistenciaException e){
			e.printStackTrace();
		}
		return id;
	}

}
