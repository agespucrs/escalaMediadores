package br.ages.mediador.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Mediador;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class AddMediadorCommand implements Command{

	private String proxima;
	
	private MediadorBO mediadorBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		mediadorBO = new MediadorBO();
		proxima = "mediador/addMediador.jsp";
		
		String cpf = request.getParameter("cpf");
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String tipoMediador = request.getParameter("tipoMediador");
		String statusMediador = request.getParameter("statusMediador");
		
		try {
			Mediador mediador = new Mediador();
			mediador.setCpf(cpf);
			mediador.setMatricula(matricula);
			mediador.setNome(nome);
			mediador.setEmail(email);
			mediador.setTipoMediador(tipoMediador);
			mediador.setStatusMediador(statusMediador);
			
			boolean isValido = mediadorBO.validaMediador(mediador);
			
			if (isValido == false) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_MEDIADOR_DADOS_INVALIDOS);
			} else {
				mediadorBO.cadastraMediador(mediador);
				proxima = "main?acao=listaMediador";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_MEDIADOR.replace("?", mediador.getNome()));
			}
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
	}
}
