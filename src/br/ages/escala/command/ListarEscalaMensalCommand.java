package br.ages.escala.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.escala.bo.EscalaBO;
import br.ages.exception.NegocioException;
import br.ages.model.Ferias;
import br.ages.usuario.command.Command;

public class ListarEscalaMensalCommand implements Command {

	private String proxima;
	private EscalaBO escalaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		escalaBO = new EscalaBO();
		proxima = "escala/listarEscalaMes.jsp";
		
		try {
			List<Ferias> lista = escalaBO.listarEscalaMensal();
			request.setAttribute("listEscalaMes", lista);
			
		} catch(Exception se){
			se.printStackTrace();
			request.setAttribute("msgErro", se.getMessage());
		}
		
		return proxima;
	}
	
	
}