package br.ages.escalaDia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.ages.exception.PersistenciaException;
import br.ages.model.EscalaDia;
import br.ages.model.Ferias;
import br.ages.util.ConexaoUtil;

public class EscalaDiaDAO {

	public int criarEscalaDia(EscalaDia escala) throws ClassNotFoundException, PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			Integer idFerias = null;
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			Date data = Date.valueOf(escala.getData());
			
			sql.append("insert into tb_escala_dia(id_mediador, id_area_conhecimento, data_escala_dia, turno)");
			sql.append("values(?, ?, ?, ?)");
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, escala.getMediador().getIdMediador());
			statement.setInt(2, escala.getArea().getIdAreaConhecimento());
			statement.setDate(3, data);
//			statement.setString(4, escala.getTurno()); TODO

			statement.executeUpdate();
			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idFerias = resultset.getInt(1);
			}
			return idFerias;
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		} finally {
			conexao.close();
		}
		return 0;
	}
}
