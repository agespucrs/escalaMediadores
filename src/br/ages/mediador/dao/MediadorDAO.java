package br.ages.mediador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import java.util.ArrayList;
import java.util.List;

import br.ages.exception.PersistenciaException;
import br.ages.model.Mediador;
import br.ages.util.ConexaoUtil;
import br.ages.util.MensagemContantes;

public class MediadorDAO {
	
	private ArrayList<Mediador> listaResultado;
	
	public MediadorDAO() {
		listaResultado = new ArrayList<Mediador>();
	}

	public int cadastrarMediador(Mediador mediador) throws ClassNotFoundException, PersistenciaException, SQLException{

		Connection conexao = null;
		
		try {
			Integer idMediador = null;
			
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tb_mediador(id_mediador, cpf, matricula, nome, email, tipo_mediador, status_mediador, data_cadastro)");
			sql.append("values(?, ?, ?, ?, ?, ?, ?, ?)");
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, mediador.getIdMediador());
			statement.setString(2, mediador.getCpf());
			statement.setString(3, mediador.getMatricula());
			statement.setString(4, mediador.getNome());
			statement.setString(5, mediador.getEmail());
			statement.setString(6, mediador.getTipoMediador());
			statement.setString(7, mediador.getStatusMediador());
			statement.setDate(8, dataCadastro);
			
			statement.executeUpdate();
			
			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idMediador = resultset.getInt(1);

			}
			return idMediador;
			
		} catch (ClassNotFoundException| SQLException se) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_CADASTRO_MEDIADOR);			
		} finally {
			conexao.close();
		}
	}
	
	public boolean editaMediador(Mediador mediador) throws PersistenciaException, SQLException{
		boolean ok = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = mediador.getIdMediador();
			
			sql.append("update tb_mediador set cpf = ?, matricula = ?,"
					+ "nome = ?, email = ?, tipo_mediador = ?, status_mediador = ?,"
					+ "data_cadastro = ? where id_mediador = "+id+";");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
		
			statement.setString(1, mediador.getCpf());
			statement.setString(2, mediador.getMatricula());
			statement.setString(3, mediador.getNome());
			statement.setString(4, mediador.getEmail());
			statement.setString(5, mediador.getTipoMediador());
			statement.setString(6, mediador.getStatusMediador());
			statement.setDate(6, (Date) mediador.getDataCadastro());
			
			ok = statement.execute();
			
		} catch (ClassNotFoundException | SQLException se) {
			throw new PersistenciaException(se);
		}finally {
			conexao.close();
		}
		return ok;
	}
	
    public List<Mediador> listaMediadores() throws PersistenciaException, SQLException {
        Connection conexao = null;
        try{
            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("select * from tb_mediador;");
             
             
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Mediador med = new Mediador();
                java.util.Date dataCadastro = new java.util.Date();
                dataCadastro = resultSet.getDate("data_cadastro");
                med.setIdMediador(resultSet.getInt("id_mediador"));
                med.setCpf(resultSet.getString("cpf"));
                med.setMatricula(resultSet.getString("matricula"));
                med.setNome(resultSet.getString("nome"));
                med.setTipoMediador(resultSet.getString("tipo_mediador"));
                med.setStatusMediador(resultSet.getString("status_mediador"));
                med.setDataCadastro(dataCadastro);
                 
                listaResultado.add(med);
            }
        } catch(ClassNotFoundException | SQLException se){
            throw new PersistenciaException(se);
        } finally{
            conexao.close();
        }
         
        return listaResultado;
    }
	
	public Mediador pesquisarMediadorPorNome(String nome) throws PersistenciaException, SQLException{
		Connection conexao = null;
		Mediador med = new Mediador();
		
		try{
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_mediador where upper(nome) like upper('?');");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, nome);
			ResultSet resultSet = statement.executeQuery();
			
			med.setCpf(resultSet.getString("cpf"));
			med.setIdMediador(resultSet.getInt("id_mediador"));
			med.setMatricula(resultSet.getString("matricula"));
			med.setNome(resultSet.getString("nome"));
			med.setTipoMediador(resultSet.getString("tipo_mediador"));
			med.setStatusMediador(resultSet.getString("status_mediador"));
			med.setDataCadastro(resultSet.getDate("data_cadastro"));
		} catch (ClassNotFoundException | SQLException se){
			throw new PersistenciaException(se);
		} finally {
			conexao.close();
		}
		return med;
	}
	
	public Mediador pesquisarMediadorPorId(int id) throws PersistenciaException, SQLException{
		Connection conexao = null;
		Mediador med = new Mediador();
		
		try{
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_mediador where id_mediador=?;");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			med.setCpf(resultSet.getString("cpf"));
			med.setIdMediador(resultSet.getInt("id_mediador"));
			med.setMatricula(resultSet.getString("matricula"));
			med.setNome(resultSet.getString("nome"));
			med.setTipoMediador(resultSet.getString("tipo_mediador"));
			med.setStatusMediador(resultSet.getString("status_mediador"));
			med.setDataCadastro(resultSet.getDate("data_cadastro"));
		} catch (ClassNotFoundException | SQLException se){
			throw new PersistenciaException(se);
		} finally {
			conexao.close();
		}
		return med;
	}
	
	public Mediador pesquisarMediadorPorCpf(String cpf) throws PersistenciaException, SQLException{
		Connection conexao = null;
		Mediador med = new Mediador();
		
		try{
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_mediador where cpf='?';");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, cpf);
			ResultSet resultSet = statement.executeQuery();
			
			med.setCpf(resultSet.getString("cpf"));
			med.setIdMediador(resultSet.getInt("id_mediador"));
			med.setMatricula(resultSet.getString("matricula"));
			med.setNome(resultSet.getString("nome"));
			med.setTipoMediador(resultSet.getString("tipo_mediador"));
			med.setStatusMediador(resultSet.getString("status_mediador"));
			med.setDataCadastro(resultSet.getDate("data_cadastro"));
		} catch (ClassNotFoundException | SQLException se){
			throw new PersistenciaException(se);
		} finally {
			conexao.close();
		}
		return med;
	}
	
	public Mediador pesquisarMediadorPorMatricula(String matricula) throws PersistenciaException, SQLException{
		Connection conexao = null;
		Mediador med = new Mediador();
		
		try{
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_mediador where matricula='?';");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, matricula);
			ResultSet resultSet = statement.executeQuery();
			
			med.setCpf(resultSet.getString("cpf"));
			med.setIdMediador(resultSet.getInt("id_mediador"));
			med.setMatricula(resultSet.getString("matricula"));
			med.setNome(resultSet.getString("nome"));
			med.setTipoMediador(resultSet.getString("tipo_mediador"));
			med.setStatusMediador(resultSet.getString("status_mediador"));
			med.setDataCadastro(resultSet.getDate("data_cadastro"));
		} catch (ClassNotFoundException | SQLException se){
			throw new PersistenciaException(se);
		} finally {
			conexao.close();
		}
		return med;
	}
}
