package br.ages.mediador.bo;

import java.sql.SQLException;

import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.Mediador;

public class MediadorBO {
	
	MediadorDAO mediadorDAO = null;
	
	public MediadorBO(){
		mediadorDAO = new MediadorDAO();
	}

	public void cadastraMediador(Mediador mediador) throws ClassNotFoundException, SQLException, NegocioException{
		try {
			mediadorDAO.cadastrarMediador(mediador);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	public void editaMediador(Mediador mediador) throws NegocioException{
		try {
			mediadorDAO.editaMediador(mediador);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
}
