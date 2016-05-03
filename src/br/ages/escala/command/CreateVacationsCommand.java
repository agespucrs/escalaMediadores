package br.ages.escala.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.usuario.command.Command;

public class CreateVacationsCommand implements Command {

	private String proxima;
	

	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		// TODO Auto-generated method stub
		return null;
	}

}
