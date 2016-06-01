package br.ages.escalaMensal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Statement;

import br.ages.exception.PersistenciaException;
import br.ages.model.Ferias;
import br.ages.util.ConexaoUtil;

public class EscalaMensalDAO {

	ArrayList<Ferias> ferias;
	
	public EscalaMensalDAO() {
		ferias = new ArrayList<Ferias>();
	}

	public int criarFeriasEscala(Ferias folga) throws ClassNotFoundException, PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			Integer idFerias = null;
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into tb_escala_mes(id_mediador, dia, mes, ano)");
			sql.append("values(?, ?, ?, ?)");
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, folga.getIdMediador());
			statement.setString(2, folga.getDia());
			statement.setString(3, folga.getMes());
			statement.setString(4, folga.getAno());

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

	public ArrayList<Object> listarEscalaMensal(String mes, String ano){		
		Map<String, Object> folga = new HashMap<>();
		ArrayList<Object> folgas = new ArrayList<>();
		
		Connection conexao = null;
		
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id_mediador, GROUP_CONCAT(dia SEPARATOR  ' - ' ) "
					+ "FROM  tb_escala_mes "
					+ "where mes = ? and ano = ? GROUP BY id_mediador;");			
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, mes);
			statement.setString(2, ano);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){	
				folga.put("idEscalaMes", resultSet.getInt("id_escala_mes"));
				folga.put("idMediador", resultSet.getInt("id_mediador"));
				folga.put("diasFolga", resultSet.getString("dia"));
				
				folgas.add(folga);
			}
			
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}
		
		return folgas;
	}
	
	public ArrayList<Ferias> listarEscalaMensalPorMediador(int idMediador, String mes){
		Ferias folga = new Ferias();
		Connection conexao = null;
		
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_escala_mes where id_mediador = ? and mes = ?;");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idMediador);
			statement.setString(2, mes);
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
	
	public void deletarFeriasPorIdMes(int id, String mes) throws SQLException{
		Connection conexao = null;
		
		try{
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from tb_escala_mes where id_mediador = ? and mes = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, id);
			statement.setString(2, mes);
			statement.execute();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}






















