package br.ages.area.bo;

import java.sql.SQLException;
import java.util.List;

import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.model.AreaConhecimento;
import br.ages.model.Pavimento;
import br.ages.util.MensagemContantes;

public class AreaConhecimentoBO {
	AreaConhecimentoDAO areaDAO = null;
	
	public AreaConhecimentoBO() {
		areaDAO = new AreaConhecimentoDAO();
	}
	
	public boolean validaArea(AreaConhecimento area) throws NegocioException{
		boolean isValido = true;
		StringBuilder msg = new StringBuilder();
		msg.append(MensagemContantes.MSG_ERR_AREA_DADOS_INVALIDOS.concat("<br>"));
		
		try {
			if(area.getNumero() <= 0){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_NUMERO_INVALIDO.concat("<br/>"));
			}
			
			if(area.getNome() == null || "".equals(area.getNome())){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Área").concat("<br/>"));
			}
			
			if(area.getNumeroMediadores() <= 0){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_NUMERO_MEDIADORES_INVALIDO.concat("<br/>"));
			}
			
			if(!isValido){
				throw new NegocioException(msg.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return isValido;
	}
	
	public int cadastraAreaConhecimento(AreaConhecimento area) throws NegocioException, SQLException{
		int id;
		try {
			id = areaDAO.criarArea(area);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return id;
	}
	
	public void editarAreaConhecimento(AreaConhecimento area) throws NegocioException{
		try {
			areaDAO.editaArea(area);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
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
	
	public AreaConhecimento pesquisarAreaPorId(int id) throws NegocioException, ClassNotFoundException{
		AreaConhecimento area = new AreaConhecimento();
		
		try{
			area = areaDAO.pesquisarAreaPorId(id);
		} catch(PersistenciaException | SQLException se){
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
