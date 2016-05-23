package br.ages.escalaMensal.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.ages.escalaMensal.bo.EscalaMensalBO;
import br.ages.exception.NegocioException;
import br.ages.usuario.command.Command;

public class ListarEscalaMensalCommand implements Command {

	private String proxima;
	private EscalaMensalBO escalaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		escalaBO = new EscalaMensalBO();
		proxima = "escala/listarEscalaMes.jsp";
		
		try {
			String mes = request.getParameter("mesSelecionado");
			String ano = request.getParameter("anoSelecionado");
			
			ArrayList<Object> lista = escalaBO.listarEscalaMensal(mes, ano);
			request.setAttribute("listEscalaMes", lista);
			
		} catch(Exception se){
			se.printStackTrace();
			request.setAttribute("msgErro", se.getMessage());
		}
		
		return proxima;
	}
	
	
}