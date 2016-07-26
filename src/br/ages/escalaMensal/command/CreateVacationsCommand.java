package br.ages.escalaMensal.command;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.ages.escalaMensal.bo.EscalaMensalBO;
import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Ferias;
import br.ages.model.Mediador;
import br.ages.usuario.command.Command;

public class CreateVacationsCommand implements Command {

	private String proxima;
	private EscalaMensalBO escalaBO;
	private MediadorBO mediadorBO;

	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		escalaBO = new EscalaMensalBO();
		mediadorBO = new MediadorBO();
		proxima = "main?acao=listEscalaMensal";
		Mediador mediador = mediadorBO.pesquisarMediadorPorMatricula(request.getParameter("matricula"));
		String datas = request.getParameter("datas");
		String[] todasDatas = datas.split(",");

		try {			
			java.util.Date getMes = new java.util.Date(Long.parseLong(todasDatas[0]));
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(getMes);
			String mes = Integer.toString(calendario.get(Calendar.MONTH));
			if (!escalaBO.listarEscalaMensalPorMediador(mediador.getIdMediador(), mes).isEmpty()) {
				escalaBO.deletarFeriasPorId(mediador.getIdMediador(), mes);
			}
			for (int i = 0; i < todasDatas.length; i++) {
				Ferias f = new Ferias();
				java.util.Date data = new java.util.Date(Long.parseLong(todasDatas[i]));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(data);
				f.setDia(Integer.toString(calendar.get(Calendar.DATE)));
				f.setMes(Integer.toString(calendar.get(Calendar.MONTH)));
				f.setAno(Integer.toString(calendar.get(Calendar.YEAR)));
				f.setIdMediador(mediador.getIdMediador());
				escalaBO.criarFeriasEscala(f);
			}
			String s = "Ferias salvas com sucesso para o mediador " + mediador.getNome();
			request.setAttribute("msgSucesso", s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return proxima;
	}
}
