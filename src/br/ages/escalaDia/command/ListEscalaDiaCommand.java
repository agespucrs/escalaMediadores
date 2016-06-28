package br.ages.escalaDia.command;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			String data = request.getParameter("date");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
			// falta formatar a data direitinho
			
			LocalDate dataFormat = LocalDate.parse(data,dtf);
			EscalaDia[] lista = escalaDiaBO.gerarEscala(dataFormat);
			request.setAttribute("listEscala", lista);
		} catch(ClassNotFoundException | PersistenciaException se){
			se.printStackTrace();
			request.setAttribute("msgErro", se.getMessage());
		}
		
		return proxima;
	}

}
