package br.ages.area.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.area.bo.AreaConhecimentoBO;
import br.ages.exception.NegocioException;
import br.ages.model.PerfilAcesso;
import br.ages.model.Usuario;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class RemoveAreaConhecimentoCommand implements Command{

	private String proxima;
	private AreaConhecimentoBO areaBO;
	
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		
		areaBO = new AreaConhecimentoBO();
		proxima = "main?acao=listaArea";
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioSessao");
		try {
			if( !usuario.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERMISSAO);
			
			Integer idArea = Integer.parseInt(request.getParameter("id_area"));
			String nomeArea = request.getParameter("nome");
		
			areaBO.removeArea(idArea);			
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_AREA.replace("?", nomeArea).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
	
	
}
}
