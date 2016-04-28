package br.ages.mediador.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ages.exception.NegocioException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.model.Mediador;
import br.ages.usuario.command.Command;

public class ListMediadorJSONCommand implements Command {

	private String proxima;
	private MediadorBO mediadorBO;

	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException {
		mediadorBO = new MediadorBO();
		proxima = "/escala/escalaMes.jsp";

		try {
			JSONArray lista = convertToJson(mediadorBO.listarMediadores());
			System.out.print(lista.toString());
			request.setAttribute("listaMediador", lista);
		} catch (NegocioException se) {
			se.printStackTrace();
		}

		return proxima;
	}

	private JSONArray convertToJson(List<Mediador> listaMediador) {
		JSONArray result = new JSONArray();

		if (!listaMediador.isEmpty()) {

			for (int i = 0; i < listaMediador.size(); i++) {
				Mediador med = listaMediador.get(i);
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("idMediador", med.getIdMediador());
				jsonObj.put("cpf", med.getCpf());
				jsonObj.put("matricula", med.getMatricula());
				jsonObj.put("nome", med.getNome());
				jsonObj.put("statusMediador", med.getStatusMediador());
				jsonObj.put("email", med.getEmail());
				jsonObj.put("tipoMediador", med.getTipoMediador());
				jsonObj.put("dataCadastro", med.getDataCadastro());
				result.put(jsonObj);
			}
		}

		return result;
	}

}
