package br.ages.area.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.exception.PersistenciaException;
import br.ages.model.AreaConhecimento;
import br.ages.model.Pavimento;
import br.ages.model.Status;
import br.ages.model.Tipo;
import br.ages.util.ConexaoUtil;
import br.ages.util.MensagemContantes;

public class AreaConhecimentoDAO {

	List<AreaConhecimento> areas;
	
	public AreaConhecimentoDAO(){
		areas = new ArrayList<AreaConhecimento>();
	}
	
	public int criarArea(AreaConhecimento area) throws PersistenciaException, SQLException{
		
		Connection conexao = null;
		
		try {
			Integer idArea = null;
			
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tb_area_conhecimento (id_area_conhecimento,numero,nome,pavimento,tipo_area,status_area,numero_mediadores,observacao,data_cadastro)");
			sql.append("values(?,?,?,?,?,?,?,?,?)");
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, area.getIdAreaConhecimento());
			statement.setInt(2, area.getNumero());
			statement.setString(3, area.getNome());
			statement.setString(4, String.valueOf(area.getPavimento()));
			statement.setString(5, String.valueOf(area.getTipoArea()));
			statement.setString(6, String.valueOf(area.getStatusArea()));
			statement.setInt(7, area.getNumeroMediadores());
			statement.setString(8, area.getObservacao());
			statement.setDate(9, dataCadastro);
			
			statement.executeUpdate();
			
			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idArea = resultset.getInt(1);
			}
			return idArea;
			
		} catch (Exception e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_CADASTRO_AREA+"\n"+e.getMessage());
		}finally {
			conexao.close();
		}
	}
	
	public boolean editaArea(AreaConhecimento area) throws PersistenciaException{
		boolean ok = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = area.getIdAreaConhecimento();
			
			sql.append("update tb_area_conhecimento set numero = ?, "
					+ "nome = ?, pavimento = ?, tipo_area = ?, status_area = ?, "
					+ "numero_mediadores = ?, observacao = ?, data_cadastro = ? "
					+ "where id_area_conhecimento = "+id+";");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			
			statement.setInt(1, area.getNumero());
			statement.setString(2, area.getNome());
			statement.setString(3, String.valueOf(area.getPavimento()));
			statement.setString(4, String.valueOf(area.getTipoArea()));
			statement.setString(5, String.valueOf(area.getStatusArea()));
			statement.setInt(6, area.getNumeroMediadores());
			statement.setString(7, area.getObservacao());
			statement.setDate(8, (Date) area.getDataCadastro());
			
			ok = statement.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return ok;
	}

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
				area.setNumero(resultSet.getInt("numero"));
				area.setPavimento(Pavimento.valueOf(resultSet.getString("pavimento")));
				area.setObservacao(resultSet.getString("observacao"));
				area.setStatusArea(Status.valueOf(resultSet.getString("status_area")));
				area.setNumeroMediadores(resultSet.getInt("numero_mediadores"));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));				

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
				area.setStatusArea(Status.valueOf(resultSet.getString("status_area")));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
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
				area.setStatusArea(Status.valueOf(resultSet.getString("status_area")));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
				area.setNumero(resultSet.getInt("numero"));
			}
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}

		return area;
	}
	
	public AreaConhecimento buscarPorPavimento(Pavimento pavimento) throws PersistenciaException, SQLException {
		AreaConhecimento area = new AreaConhecimento();

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			String pav = String.valueOf(pavimento);
			sql.append("select * from tb_area_conhecimento where upper(pavimento) like upper('?') ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, pav);
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
				area.setStatusArea(Status.valueOf(resultSet.getString("status_area")));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
				area.setNumero(resultSet.getInt("numero"));
			}
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}

		return area;
	}
	
	public AreaConhecimento pesquisarAreaPorId(int id) throws PersistenciaException, SQLException{
		AreaConhecimento area = new AreaConhecimento();
		Connection conexao = null;
		
		try{
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_area_conhecimento where id_area_conhecimento = ?");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				java.util.Date data = new java.util.Date();
				data = resultSet.getDate("data_cadastro");
				area.setDataCadastro(data);
				area.setIdAreaConhecimento(resultSet.getInt("id_area_conhecimento"));
				area.setNome(resultSet.getString("nome"));
				area.setNumeroMediadores(resultSet.getInt("numero_mediadores"));
				area.setObservacao(resultSet.getString("observacao"));
				area.setPavimento(Pavimento.valueOf(resultSet.getString("pavimento")));
				area.setStatusArea(Status.valueOf(resultSet.getString("status_area")));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
				area.setNumero(resultSet.getInt("numero"));
			}
			
		} catch(ClassNotFoundException | SQLException se){
			se.printStackTrace();
		}
		
		return area;
	}
	
	
	public boolean removeArea(int idArea) throws PersistenciaException, SQLException{
		boolean ok = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			//int id = mediador.getIdMediador();
			sql.append("update tb_area_conhecimento set status_area = 'EXCLUÍDO' where id_area_conhecimento = "+idArea+";");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ok = statement.execute();
			
		} catch (ClassNotFoundException  SQLException) {
			throw new PersistenciaException(SQLException);
		}finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ok;
	}
	
	
}
