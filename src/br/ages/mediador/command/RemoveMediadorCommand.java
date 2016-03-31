package br.ages.mediador.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Status;
import br.ages.model.Mediador;
import br.ages.model.PerfilAcesso;
import br.ages.model.Usuario;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class RemoveMediadorCommand implements Command{
	private String proxima;
	private MediadorBO mediadorBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		
		mediadorBO = new MediadorBO();
		proxima = "main?acao=listaMediador";
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioSessao");
		try {
			if( !usuario.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERMISSAO);
			
			Integer idMediador = Integer.parseInt(request.getParameter("id_mediador"));
		
			mediadorBO.removeMediador(idMediador);
			//request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_USUARIO.replace("?", idUsuario.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
			
	}
}
