package br.ages.escala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.ages.exception.PersistenciaException;
import br.ages.util.ConexaoUtil;

public class EscalaDAO {

	public EscalaDAO() {
		// TODO Auto-generated constructor stub
	}

	public int criarFeriasEscala(int day, int month, int year, int id_mediador, String tipoFolga) throws ClassNotFoundException, PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			Integer idFerias = null;
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into tb_escala_mes(id_mediador, dia, mes, ano, tipo_folga)");
			sql.append("values(?, ?, ?, ?, ?)");
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, id_mediador);
			statement.setInt(2, day);
			statement.setInt(3, month);
			statement.setInt(4, year);
			statement.setString(5, tipoFolga);

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
