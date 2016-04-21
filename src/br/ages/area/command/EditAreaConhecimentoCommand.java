package br.ages.area.command;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.area.bo.AreaConhecimentoBO;
import br.ages.exception.NegocioException;
import br.ages.model.AreaConhecimento;
import br.ages.model.Pavimento;
import br.ages.model.Status;
import br.ages.model.Tipo;
import br.ages.usuario.command.Command;
import br.ages.util.MensagemContantes;

public class EditAreaConhecimentoCommand implements Command{

	private String proxima;
	private AreaConhecimentoBO areaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		areaBO = new AreaConhecimentoBO();
		AreaConhecimento area;
		proxima = "area/editArea.jsp";
		
		String idAreaString = request.getParameter("idArea");
		String numeroString = request.getParameter("numero");
		String nomeString = request.getParameter("nome");
		String pavimentoString = request.getParameter("pavimento");
		String tipoString = request.getParameter("tipoArea");
		String statusString = request.getParameter("statusArea");
		String numeroMediadoresString = request.getParameter("numeroMediadores");
		String observacaoString = request.getParameter("observacao");
		String dataString = request.getParameter("dataCadastro");
		
		try {
			area = new AreaConhecimento();
			area.setIdAreaConhecimento(Integer.valueOf(idAreaString));
			area.setNumero(Integer.valueOf(numeroString));
			area.setNome(nomeString);
			area.setPavimento(Pavimento.valueOf(pavimentoString));
			area.setTipoArea(Tipo.valueOf(tipoString));
			area.setStatusArea(Status.valueOf(statusString));
			area.setNumeroMediadores(Integer.parseInt(numeroMediadoresString));
			area.setObservacao(observacaoString);
			
			java.sql.Date dataSQLFormat = new java.sql.Date(Date.valueOf(dataString).getTime());
			
			area.setDataCadastro(dataSQLFormat);
			
			request.setAttribute("area", area);
			
			boolean isValido = areaBO.validaArea(area);
			
			if(isValido){
				areaBO.editarAreaConhecimento(area);
				proxima = "main?acao=listaArea";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_EDICAO_AREA.replace("?", nomeString));
			} else {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_AREA_DADOS_INVALIDOS);
			}
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
	
	
}
