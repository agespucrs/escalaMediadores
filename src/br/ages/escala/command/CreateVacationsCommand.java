package br.ages.escala.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.escala.bo.EscalaBO;
import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.usuario.command.Command;

public class CreateVacationsCommand implements Command {

	private String proxima;
	private EscalaBO escalaBO;
	private MediadorBO mediadorBO;
	

	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		escalaBO = new EscalaBO();
		mediadorBO = new MediadorBO();
		proxima = "escala/escalaMes.jsp";
		
		int id_mediador = mediadorBO.pesquisarMediadorPorNome(request.getParameter("nome")).getIdMediador();
		String[] datas = request.getParameterValues("datas");
		System.out.println("\f");
		System.out.println(datas.length);
		
		return proxima;
	}
}
