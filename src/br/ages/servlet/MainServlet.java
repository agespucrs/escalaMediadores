package br.ages.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.ages.area.command.ListAreaConhecimentoCommand;
import br.ages.mediador.command.AddMediadorCommand;
import br.ages.mediador.command.CreateScreenCommand;
import br.ages.mediador.command.CreateScreenMediadorCommand;
import br.ages.mediador.command.EditMediadorCommand;
import br.ages.mediador.command.ListMediadorCommand;
import br.ages.mediador.command.RemoveMediadorCommand;
import br.ages.model.Usuario;
import br.ages.usuario.command.AddUserCommand;
import br.ages.usuario.command.Command;
import br.ages.usuario.command.CreateScreenUserCommand;
import br.ages.usuario.command.EditUserCommand;
import br.ages.usuario.command.ListUserCommand;
import br.ages.usuario.command.LoginCommand;
import br.ages.usuario.command.LogoutCommand;
import br.ages.usuario.command.RemoveUserCommand;
import br.ages.usuario.command.SenhaCommand;
import br.ages.util.LogParametrosSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	Logger logger = Logger.getLogger("servlet.MainServlet");
	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<String, Command>();

	@Override
	public void init() throws ServletException {
		
		comandos.put("login", new LoginCommand());
		comandos.put("logout", new LogoutCommand());
		comandos.put("recuperarSenha", new SenhaCommand());
		
		//COMANDOS DE USUARIO
		
		comandos.put("telaUser", new CreateScreenUserCommand());
		comandos.put("listUser", new ListUserCommand());
		comandos.put("addUser", new AddUserCommand());
		comandos.put("editUser", new EditUserCommand());
		comandos.put("removerUsuario", new RemoveUserCommand());
		
		//Paginas Novas
		comandos.put("tela", new CreateScreenCommand());
		
		//COMANDOS DE MEDIADOR
		comandos.put("telaMediador", new CreateScreenMediadorCommand());
		comandos.put("addMediador", new AddMediadorCommand());
		comandos.put("listaMediador", new ListMediadorCommand());	
		comandos.put("editMediador", new EditMediadorCommand());
		comandos.put("removeMediador", new RemoveMediadorCommand());
		
		// COMANDOS DE AREACONHECIMENTO
		comandos.put("listaArea", new ListAreaConhecimentoCommand());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String proxima = null;

		try {
			Command comando = verificarComando(acao);
			proxima = comando.execute(request);
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSessao");
			logger.debug("User: " +usuario.getUsuario() + " - comando " + comando.toString() + " acao: " +acao );
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
	
		LogParametrosSession.logParametros(request);
		
		request.getRequestDispatcher(proxima).forward(request, reponse);
		
	}

	private Command verificarComando(String acao) {
		Command comando = null;
		for (String key : comandos.keySet()) {
			if (key.equalsIgnoreCase(acao)) {
				comando = comandos.get(key);
			}
		}
		return comando;
	}
}

