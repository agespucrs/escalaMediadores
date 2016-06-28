package br.ages.escalaDia.command;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.area.bo.AreaConhecimentoBO;
import br.ages.escalaDia.bo.EscalaDiaBO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.model.AreaConhecimento;
import br.ages.model.EscalaDia;
import br.ages.usuario.command.Command;

public class ListEscalaDiaCommand implements Command {

	private String proxima;
	private EscalaDiaBO escalaDiaBO;

	@Override
	public String execute(HttpServletRequest request) throws NegocioException, SQLException {
		escalaDiaBO = new EscalaDiaBO();
		proxima = "escala/escalaDia.jsp";
		
		try{
			String requestDate = request.getParameter("date");

			java.util.Date date = new java.util.Date(Long.parseLong(requestDate));
			LocalDate n = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			EscalaDia[] lista = escalaDiaBO.gerarEscala(n);
			request.setAttribute("listEscala", lista);
		} catch(ClassNotFoundException | PersistenciaException se){
			se.printStackTrace();
			request.setAttribute("msgErro", se.getMessage());
		}
		
		return proxima;
	}

}
