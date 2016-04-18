package br.ages.area.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.area.bo.AreaConhecimentoBO;
import br.ages.exception.NegocioException;
import br.ages.model.AreaConhecimento;
import br.ages.model.Pavimento;
import br.ages.model.Status;
import br.ages.model.Tipo;
import br.ages.model.Turno;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class AddAreaConhecimentoCommand implements Command{

	private String proxima;
	private AreaConhecimentoBO areaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		areaBO = new AreaConhecimentoBO();
		proxima = "area/addArea.jsp";
		
		String numero = request.getParameter("numero");
		String nome = request.getParameter("nome");
		String pavimento = request.getParameter("pavimento");
		String turno = request.getParameter("turno");
		String tipoArea = request.getParameter("tipo_area");
		String statusArea = request.getParameter("status_area");
		String numeroMediadores = request.getParameter("numero_mediadores");
		String observacao = request.getParameter("observacao");
		
		try {
			AreaConhecimento area = new AreaConhecimento();
			area.setNumero(Integer.parseInt(numero));
			area.setNome(nome);
			area.setPavimento(Pavimento.valueOf(pavimento));
			area.setTurno(Turno.valueOf(turno));
			area.setTipoArea(Tipo.valueOf(tipoArea));
			area.setStatusArea(Status.valueOf(statusArea));
			area.setNumeroMediadores(Integer.parseInt(numeroMediadores));
			area.setObservacao(observacao);
			
			boolean isValido = areaBO.validaArea(area);
			
			if(isValido == false){
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_AREA_DADOS_INVALIDOS);
			} else {
				areaBO.cadastraAreaConhecimento(area);
				proxima = "main?acao=listaArea";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_AREA.replace("?", area.getNome()));
			}			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proxima;
	}
}
