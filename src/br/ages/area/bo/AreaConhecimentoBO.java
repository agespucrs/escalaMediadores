package br.ages.area.bo;

import java.sql.SQLException;
import java.util.List;

import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.model.AreaConhecimento;
import br.ages.model.Pavimento;

public class AreaConhecimentoBO {
	AreaConhecimentoDAO areaDAO = null;

	public AreaConhecimentoBO() {
		areaDAO = new AreaConhecimentoDAO();
	}

	public List<AreaConhecimento> listarAreaConhecimento() throws NegocioException, ClassNotFoundException {
		List<AreaConhecimento> listArea = null;

		try {
			listArea = areaDAO.listarAreas();
		} catch (PersistenciaException | SQLException se) {
			se.printStackTrace();
		}

		return listArea;
	}

	public AreaConhecimento pesquisarAreaPorNome(String nome) throws NegocioException, ClassNotFoundException {
		AreaConhecimento area = new AreaConhecimento();

		try {
			area = areaDAO.buscarPorNome(nome);
		} catch (PersistenciaException | SQLException se) {
			se.printStackTrace();
		}

		return area;
	}

	public AreaConhecimento pesquisarAreaPorPavimento(Pavimento pav) throws NegocioException, ClassNotFoundException {
		AreaConhecimento area = new AreaConhecimento();

		try {
			area = areaDAO.buscarPorPavimento(pav);
		} catch (SQLException | PersistenciaException se) {
			se.printStackTrace();
		}

		return area;
	}

	public AreaConhecimento pesquisarAreaPorNumero(int numero) throws NegocioException, ClassNotFoundException {
		AreaConhecimento area = new AreaConhecimento();
		
		try{
			area = areaDAO.buscarAreaPorNumero(numero);
		} catch(SQLException | PersistenciaException se){
			se.printStackTrace();
		}
		
		return area;
	}
	
	public void removeArea(int idArea) throws NegocioException{
		try {
			areaDAO.removeArea(idArea);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	
	
}
