package br.ages.area.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.exception.PersistenciaException;
import br.ages.model.AreaConhecimento;
import br.ages.model.Pavimento;
import br.ages.model.Tipo;
import br.ages.model.Turno;
import br.ages.util.ConexaoUtil;

public class AreaConhecimentoDAO {

	List<AreaConhecimento> areas;

	public List<AreaConhecimento> listarAreas() throws ClassNotFoundException, PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_area_conhecimento");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AreaConhecimento area = new AreaConhecimento();
				java.util.Date dataCadastro = new java.util.Date();
				dataCadastro = resultSet.getDate("data_cadastro");
				area.setDataCadastro(dataCadastro);
				area.setIdAreaConhecimento(resultSet.getInt("id_area_conhecimento"));
				area.setNome(resultSet.getString("nome"));
				area.setPavimento(Pavimento.valueOf(resultSet.getString("pavimento")));
				area.setObservacao(resultSet.getString("observacao"));
				area.setStatusArea(resultSet.getString("status_area"));
				area.setNumeroMediadores(resultSet.getInt("numero_mediadores"));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
				// area.setTurno(Turno.valueOf(resultSet.getString("turno")));

				areas.add(area);
			}

		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}

		return areas;
	}

	public AreaConhecimento buscarPorNome(String nome) throws PersistenciaException, SQLException {
		AreaConhecimento area = new AreaConhecimento();

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_area_conhecimento where upper(nome) like upper('?') ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, nome);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				java.util.Date data = new java.util.Date();
				data = resultSet.getDate("data_cadastro");
				area.setDataCadastro(data);
				area.setIdAreaConhecimento(resultSet.getInt("id_area_conhecimento"));
				area.setNome(resultSet.getString("nome"));
				area.setNumeroMediadores(resultSet.getInt("numero_mediadores"));
				area.setObservacao(resultSet.getString("observacao"));
				area.setPavimento(Pavimento.valueOf(resultSet.getString("pavimento")));
				area.setStatusArea(resultSet.getString("status_area"));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
				area.setTurno(Turno.valueOf(resultSet.getString("turno")));
				area.setNumero(resultSet.getInt("numero"));
			}
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}

		return area;
	}

	public AreaConhecimento buscarAreaPorNumero(int numero) throws PersistenciaException, SQLException {
		AreaConhecimento area = new AreaConhecimento();

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_area_conhecimento where numero == ? ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, numero);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				java.util.Date data = new java.util.Date();
				data = resultSet.getDate("data_cadastro");
				area.setDataCadastro(data);
				area.setIdAreaConhecimento(resultSet.getInt("id_area_conhecimento"));
				area.setNome(resultSet.getString("nome"));
				area.setNumeroMediadores(resultSet.getInt("numero_mediadores"));
				area.setObservacao(resultSet.getString("observacao"));
				area.setPavimento(Pavimento.valueOf(resultSet.getString("pavimento")));
				area.setStatusArea(resultSet.getString("status_area"));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
				area.setTurno(Turno.valueOf(resultSet.getString("turno")));
				area.setNumero(resultSet.getInt("numero"));
			}
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}

		return area;
	}
}
