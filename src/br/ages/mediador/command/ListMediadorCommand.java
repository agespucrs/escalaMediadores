package br.ages.mediador.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Mediador;
import br.ages.usuario.command.Command;

public class ListMediadorCommand implements Command{
	private String proxima;
	private MediadorBO mediadorBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		mediadorBO = new MediadorBO();
		proxima = "mediador/listaMediador.jsp";
		
		try{
			List<Mediador> lista = mediadorBO.listarMediadores();
			request.setAttribute("listMediador", lista);
		} catch(NegocioException e){
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proxima;
	}
}
