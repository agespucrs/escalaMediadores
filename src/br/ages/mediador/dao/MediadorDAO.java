package br.ages.mediador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.ages.exception.PersistenciaException;
import br.ages.model.Mediador;
import br.ages.util.ConexaoUtil;
import br.ages.util.MensagemContantes;

public class MediadorDAO {
	
	
	public int cadastrarMediador(Mediador mediador) throws ClassNotFoundException, PersistenciaException, SQLException{
		Connection conexao = null;
		
		try {
			Integer idMediador = null;
			
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tb_mediador(id_mediador, cpf, matricula, nome, email, tipo_mediador, status_mediador, data_cadastro)");
			sql.append("values(?, ?, ?, ?, ?, ?, ?)");
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, mediador.getIdMediador());
			statement.setString(2, mediador.getCpf());
			statement.setString(3, mediador.getMatricula());
			statement.setString(4, mediador.getNome());
			//statement.setString(5, mediador.getEmail());
			statement.setString(6, mediador.getTipoMediador());
			statement.setString(7, mediador.getStatusMediador());
			statement.setDate(7, dataCadastro);
			
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
			//statement.setString(4, mediador.getEmail());
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
}
