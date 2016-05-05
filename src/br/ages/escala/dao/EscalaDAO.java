package br.ages.escala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import br.ages.exception.PersistenciaException;
import br.ages.model.Ferias;
import br.ages.util.ConexaoUtil;

public class EscalaDAO {

	ArrayList<Ferias> ferias;
	
	public EscalaDAO() {
		ferias = new ArrayList<Ferias>();
	}

	public int criarFeriasEscala(Ferias folga) throws ClassNotFoundException, PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			Integer idFerias = null;
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into tb_escala_mes(id_mediador, dia, mes, ano, tipo_folga)");
			sql.append("values(?, ?, ?, ?, ?)");
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, folga.getIdMediador());
			statement.setString(2, folga.getDia());
			statement.setString(3, folga.getMes());
			statement.setString(4, folga.getAno());
			statement.setString(5, folga.getTipoFolga());

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

	public ArrayList<Ferias> listarEscalaMensalPorMediador(int idMediador){
		Ferias folga = new Ferias();
		Connection conexao = null;
		
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_escala_mes where id_mediador = "+idMediador);
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idMediador);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				folga.setIdEscalaMes(resultSet.getInt("id_escala_mes"));
				folga.setIdMediador(resultSet.getInt("id_mediador"));
				folga.setDia(resultSet.getString("dia"));
				folga.setMes(resultSet.getString("mes"));
				folga.setAno(resultSet.getString("ano"));
				folga.setTipoFolga(resultSet.getString("tipo_folga"));
				
				ferias.add(folga);
			}
			
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}
		
		return ferias;
	}
	
}






















