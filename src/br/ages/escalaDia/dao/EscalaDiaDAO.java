package br.ages.escalaDia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ages.exception.PersistenciaException;
import br.ages.model.AreaConhecimento;
import br.ages.model.EscalaDia;
import br.ages.model.Mediador;
import br.ages.model.Pavimento;
import br.ages.model.Status;
import br.ages.model.Tipo;
import br.ages.model.Turno;
import br.ages.util.ConexaoUtil;

public class EscalaDiaDAO {
	
	List<EscalaDia> escalaDia ;
	
	

	public EscalaDiaDAO() {
		this.escalaDia = new ArrayList<EscalaDia>();
	}

	public int criarEscalaDia(EscalaDia escala) throws ClassNotFoundException, PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			Integer idFerias = null;
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			LocalDate localDate =  escala.getData();
			Date data = Date.valueOf(localDate);
			
			sql.append("insert into tb_escala_dia(id_mediador, id_area_conhecimento, data_escala_dia, turno)");
			sql.append("values(?, ?, ?, ?)");
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, escala.getMediador().getIdMediador());
			statement.setInt(2, escala.getArea().getIdAreaConhecimento());
			statement.setDate(3, data);
			statement.setString(4, escala.getTurno().toString());

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
	
	public List<EscalaDia> ultimaEscala (LocalDate data) throws ClassNotFoundException, PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			Date date = Date.valueOf(data);
			sql.append("select m.id_mediador, m.cpf, m.matricula, m.nome, m.email, m.tipo_mediador, m.status_mediador, m.data_cadastro, "+
						"e.id_escala_dia, e.id_mediador as mediador_id, e.id_area_conhecimento as area_id, e.data_escala_dia, e.turno, "+
						"a.id_area_conhecimento as id_area, a.numero, a.nome as nome_area, a.pavimento, a.tipo_area, a.status_area, "+
						"a.numero_mediadores, a.observacao, a.data_cadastro as cadastro_area "+
						"from tb_mediador m "+
						"join tb_escala_dia e on e.id_mediador = m.id_mediador "+
						"join tb_area_conhecimento a on a.id_area_conhecimento =  e.id_area_conhecimento "+
						"where e.data_escala_dia = '"+date+"' ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Mediador mediador = new Mediador();
				AreaConhecimento area = new AreaConhecimento();
				EscalaDia ultimaEscala = new EscalaDia();
				mediador.setNome(resultSet.getString("nome"));
				mediador.setIdMediador(resultSet.getInt("id_mediador"));
				mediador.setCpf(resultSet.getString("cpf"));
				mediador.setMatricula(resultSet.getString("matricula"));
				mediador.setEmail(resultSet.getString("email"));
				mediador.setTipoMediador(Tipo.valueOf(resultSet.getString("tipo_mediador")));
				mediador.setStatusMediador(Status.valueOf(resultSet.getString("status_mediador")));
				java.util.Date dataCadastro = new java.util.Date();
				dataCadastro = resultSet.getDate("data_cadastro");
				mediador.setDataCadastro(dataCadastro);
				
				area.setIdAreaConhecimento(resultSet.getInt("id_area"));
				area.setNumero(resultSet.getInt("numero"));
				area.setNome(resultSet.getString("nome_area"));
				area.setPavimento(Pavimento.valueOf(resultSet.getString("pavimento")));
				area.setTipoArea(Tipo.valueOf(resultSet.getString("tipo_area")));
				area.setStatusArea(Status.valueOf(resultSet.getString("status_area")));
				area.setNumeroMediadores(resultSet.getInt("numero_mediadores"));
				area.setObservacao(resultSet.getString("observacao"));
				java.util.Date cadastroData = new java.util.Date();
				dataCadastro = resultSet.getDate("cadastro_area");
				area.setDataCadastro(cadastroData);
				
				ultimaEscala.setMediador(mediador);
				ultimaEscala.setArea(area);
				Date cadastro = resultSet.getDate("data_escala_dia");
				LocalDate cadastroLocal = cadastro.toLocalDate();
				ultimaEscala.setData(cadastroLocal);
				ultimaEscala.setTurno(Turno.valueOf(resultSet.getString("turno")));
				
				escalaDia.add(ultimaEscala);
			}

		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}

		return escalaDia;
	}
	
}
