package br.ages.area.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.area.bo.AreaConhecimentoBO;
import br.ages.exception.NegocioException;
import br.ages.model.AreaConhecimento;
import br.ages.usuario.command.Command;

public class ListAreaConhecimentoCommand implements Command {

	private String proxima;
	private AreaConhecimentoBO areaBO;

	@Override
	public String execute(HttpServletRequest request) throws NegocioException, SQLException {
		areaBO = new AreaConhecimentoBO();
		proxima = "area/listaArea.jsp";
		
		try{
			List<AreaConhecimento> lista = areaBO.listarAreaConhecimento();
			request.setAttribute("listAreas", lista);
		} catch(ClassNotFoundException | NegocioException se){
			se.printStackTrace();
			request.setAttribute("msgErro", se.getMessage());
		}
		
		return proxima;
	}

}
