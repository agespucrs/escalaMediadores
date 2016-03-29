package br.ages.mediador.bo;

import java.sql.SQLException;
import java.util.List;

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
	
	public List<Mediador> listarMediadores() throws NegocioException{
		List<Mediador> listaMed = null;
		
		try{
			listaMed = mediadorDAO.listaMediadores();
		} catch(PersistenciaException | SQLException se){
			se.printStackTrace();
			throw new NegocioException(se);
		}
		return listaMed;
	}
	
}
