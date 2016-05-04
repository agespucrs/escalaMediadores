package br.ages.escala.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.escala.bo.EscalaBO;
import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Mediador;
import br.ages.usuario.command.Command;

public class CreateVacationsCommand implements Command {

	private String proxima;
	private EscalaBO escalaBO;
	private MediadorBO mediadorBO;
	

	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		escalaBO = new EscalaBO();
		mediadorBO = new MediadorBO();
		proxima = "main?acao=escalaMensal";
		System.out.println("\f");
		String teste = request.getParameter("nome");
		System.out.println(teste);
		try{
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return proxima;
	}
}
