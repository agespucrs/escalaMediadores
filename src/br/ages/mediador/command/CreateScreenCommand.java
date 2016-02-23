package br.ages.mediador.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.usuario.command.Command;

public class CreateScreenCommand implements Command {

	private String proxima;

	@Override
	public String execute(HttpServletRequest request) {

		this.proxima = "";

		String tela = request.getParameter("tela");

		try {

			switch (tela) {
			case "criaMediador":
				this.proxima = "mediador/addMediador.jsp";
				break;
			case "criaArea":
				this.proxima = "area/addArea.jsp";
				break;
			case "listaArea":
				this.proxima = "area/listaArea.jsp";
				break;
			case "escalaDia":
				this.proxima = "escala/escalaDia.jsp";
				break;
			
			default:
				this.proxima = "mediador/listaMediador.jsp";
				break;
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
