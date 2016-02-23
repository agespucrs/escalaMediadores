package br.ages.usuario.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.model.Usuario;
import br.ages.usuario.bo.UsuarioBO;

public class ListUserCommand implements Command {

	private String proxima;
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.usuarioBO = new UsuarioBO();
		proxima = "user/listUser.jsp";

		try {
			List<Usuario> listaUsuarios = usuarioBO.listarUsuario();
			request.setAttribute("listaUsuarios", listaUsuarios);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
