package br.ages.mediador.command;

import java.sql.Date;
import java.sql.SQLException;import javax.print.attribute.standard.DateTimeAtProcessing;
import javax.servlet.http.HttpServletRequest;

import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Mediador;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class EditMediadorCommand implements Command {
	private String proxima;
	
	private MediadorBO mediadorBO;

	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		mediadorBO = new MediadorBO();
		Mediador mediador;
		proxima = "mediador/editMediador.jsp";
		
		String idMediador = request.getParameter("idMediador");
		String cpf = request.getParameter("cpf");
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String tipoMediador = request.getParameter("tipoMediador");
		String statusMediador = request.getParameter("statusMediador");
		String dataCadastro = request.getParameter("dataCadastro");
		
		try {
			mediador = new Mediador();
			mediador.setIdMediador(Integer.valueOf(idMediador));
			mediador.setCpf(cpf);
			mediador.setMatricula(matricula);
			mediador.setNome(nome);
			mediador.setEmail(email);
			mediador.setTipoMediador(tipoMediador);
			mediador.setStatusMediador(statusMediador);
			mediador.setDataCadastro(Date.valueOf(dataCadastro));
			
			request.setAttribute("mediador", mediador);
			
			boolean isValido = mediadorBO.validaMediador(mediador);
			
			if (isValido) {
				mediadorBO.editaMediador(mediador);
				proxima = "main?acao=listaMediador";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_EDICAO_MEDIADOR.replace("?", nome));
			}else{
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_MEDIADOR_DADOS_INVALIDOS);
			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
	}
	
	
}
