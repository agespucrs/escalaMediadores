package br.ages.mediador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ages.exception.PersistenciaException;
import br.ages.model.Mediador;
import br.ages.util.ConexaoUtil;
import br.ages.util.MensagemContantes;

public class MediadorDAO {
	
	
	public void cadastrarMediador(Mediador mediador) throws ClassNotFoundException, PersistenciaException, SQLException{
		Connection conexao = null;
		
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tb_mediador(id_mediador, cpf, matricula, nome, tipo_mediador, status_mediador, data_cadastro)");
			sql.append("values(?, ?, ?, ?, ?, ?, ?)");
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, mediador.getIdMediador());
			statement.setString(2, mediador.getCpf());
			statement.setString(3, mediador.getMatricula());
			statement.setString(4, mediador.getNome());
			statement.setString(5, mediador.getTipoMediador());
			statement.setString(6, mediador.getStatusMediador());
			statement.setDate(7, dataCadastro);
			
			statement.execute();
			
		} catch (ClassNotFoundException| SQLException se) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_CADASTRO_MEDIADOR);			
		} finally {
			conexao.close();
		}
	}
	
	public void editaMediador(Mediador mediador) throws PersistenciaException, SQLException{
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = mediador.getIdMediador();
			
			sql.append("update tb_mediador set cpf = ?, matricula = ?,"
					+ "nome = ?, tipo_mediador = ?, status_mediador = ?,"
					+ "data_cadastro = ? where id_mediador = "+id+";");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
		
			statement.setString(1, mediador.getCpf());
			statement.setString(2, mediador.getMatricula());
			statement.setString(3, mediador.getNome());
			statement.setString(4, mediador.getTipoMediador());
			statement.setString(5, mediador.getStatusMediador());
			statement.setDate(6, (Date) mediador.getDataCadastro());
			
			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException se) {
			throw new PersistenciaException(se);
		}finally {
			conexao.close();
		}
	}
}
