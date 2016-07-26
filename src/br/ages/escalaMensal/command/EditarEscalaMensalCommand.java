package br.ages.escalaMensal.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Mediador;
import br.ages.usuario.command.Command;

public class EditarEscalaMensalCommand implements Command{

	private String proxima;
	private MediadorBO mediadorBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		mediadorBO = new MediadorBO();
		proxima = "escala/editarEscalaMes.jsp";
		
		try{
			Mediador med = mediadorBO.pesquisarMediadorPorId(Integer.parseInt(request.getParameter("id_mediador")));
			request.setAttribute("mediador", med);
			request.setAttribute("mes", request.getParameter("mes"));
			request.setAttribute("ano", request.getParameter("ano"));
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return proxima;
	}
	
}