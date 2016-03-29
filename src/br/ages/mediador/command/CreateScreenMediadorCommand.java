package br.ages.mediador.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Mediador;
import br.ages.model.PerfilAcesso;
import br.ages.model.Usuario;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class CreateScreenMediadorCommand implements Command{
	String proxima;
	
	private MediadorBO mediadorBO;

	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		proxima = "main?acao=listMediador";
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");
				
		
		try {			
			if( !currentUser.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_DENY);
			
			String isEdit = request.getParameter("isEdit");
			
			if(isEdit != null && !"".equals(isEdit)){
				mediadorBO = new MediadorBO();
				
				int id = Integer.parseInt(request.getParameter("id_mediador"));
				Mediador mediador = mediadorBO.pesquisarMediadorPorId(id);
				
				request.setAttribute("mediador", mediador);
				proxima = "mediador/editMediador.jsp";
			} else {
				mediadorBO = new MediadorBO();
				
				proxima = "mediador/addMediador.jsp";
			}
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proxima;
	}
	
}
