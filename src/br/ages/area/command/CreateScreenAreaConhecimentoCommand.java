package br.ages.area.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.area.bo.AreaConhecimentoBO;
import br.ages.exception.NegocioException;
import br.ages.model.AreaConhecimento;
import br.ages.model.PerfilAcesso;
import br.ages.model.Usuario;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class CreateScreenAreaConhecimentoCommand implements Command {

	String proxima;
	
	private AreaConhecimentoBO areaConhecimentoBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		proxima = "main?acao=listaArea";
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");
		
		try {
			if( !currentUser.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_DENY);
			
			String isEdit = request.getParameter("isEdit");
			
			if(isEdit != null && !"".equals(isEdit)){
				areaConhecimentoBO = new AreaConhecimentoBO();
				
				int id = Integer.parseInt(request.getParameter("id_area"));
				//AreaConhecimento area = areaConhecimentoBO.pesquisarAreaPorId(id);
				
				//request.setAttribute("area", area);
				proxima = "area/editArea.jsp";
			} else {
				areaConhecimentoBO = new AreaConhecimentoBO();
				proxima = "area/addArea.jsp";
			}
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proxima;
	}
}
