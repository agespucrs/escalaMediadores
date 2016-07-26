package br.ages.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.Mediador;
import br.ages.model.Status;
import br.ages.model.Tipo;

@RunWith(MockitoJUnitRunner.class)
public class testMediadorBO {

	Mediador mediador = new Mediador();
	Date hoje = new Date();

	@Mock
	private MediadorBO mediadorBO;
	private MediadorDAO mediadorMockDAO;

	@Before
	public void setUp() {
		mediadorMockDAO = new MediadorDAO();
		mediadorBO = new MediadorBO();
		mediadorBO.setMediadorDAO(mediadorMockDAO);

		// Mediador mediador = new Mediador(15, "02753400004",
		// "222222222","Alana", "alana@gmail.com", Tipo.DOIS, Status.ATIVO,
		// hoje);

	}

	@Test
	public void testCadastraMediador()
			throws  NegocioException, ClassNotFoundException, PersistenciaException, SQLException {
		mediador = new Mediador(15, "02753453004", "11111111", "Alan", "alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		Mockito.when(mediadorMockDAO.cadastrarMediador(mediador)).thenReturn(15);
		int idMediadorCriado = mediadorBO.cadastraMediador(mediador);

		assertTrue(idMediadorCriado == mediador.getIdMediador());

	}
	
	public void testValidaMediador() throws NegocioException, SQLException{
		Mediador mediador = new Mediador(15, "02753400004", "2222","Alan" , "Alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		assertTrue(mediadorBO.validaMediador(mediador));
	}
		
	@Test
	public void testEditaMediador() throws PersistenciaException, NegocioException, SQLException{
		Mediador mediador = new Mediador(15, "02753400004", "2222","Alan" , "Alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		Mockito.when(mediadorMockDAO.editaMediador(mediador)).thenReturn(true);
	}
	
	@Test
	public void testRemoveMediador() throws PersistenciaException, SQLException, NegocioException {
		Mediador mediador = new Mediador(15, "02753400004", "2222","Alan" , "Alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		Mockito.when(mediadorMockDAO.removeMediador(mediador.getIdMediador())).thenReturn(true);

	}
	
	@Test
	public void testPesquisaMediadorNome() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		Mediador mediador = new Mediador(15, "02753400004", "2222","Alan" , "Alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		Mockito.when(mediadorMockDAO.pesquisarMediadorPorNome(mediador.getNome())).thenReturn(mediador);
		assertTrue(mediador == mediadorBO.pesquisarMediadorPorNome(mediador.getNome()));
	}
	
	@Test
	public void testPesquisaMediadorId() throws PersistenciaException, ClassNotFoundException, NegocioException, ParseException, SQLException {
		Mediador mediador = new Mediador(15, "02753400004", "2222","Alan" , "Alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		Mockito.when(mediadorMockDAO.pesquisarMediadorPorId(mediador.getIdMediador())).thenReturn(mediador);
		assertTrue(mediador == mediadorBO.pesquisarMediadorPorId(mediador.getIdMediador()));
	}
	
	@Test
	public void testPesquisaMediadorCpf() throws PersistenciaException, ClassNotFoundException, NegocioException, ParseException, SQLException {
		Mediador mediador = new Mediador(15, "02753400004", "2222","Alan" , "Alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		Mockito.when(mediadorMockDAO.pesquisarMediadorPorCpf(mediador.getCpf())).thenReturn(mediador);
		assertTrue(mediador == mediadorBO.pesquisarMediadorPorCpf(mediador.getCpf()));
	}
	
	@Test
	public void testPesquisaMediadorMatricula() throws PersistenciaException, ClassNotFoundException, NegocioException, ParseException, SQLException {
		Mediador mediador = new Mediador(15, "02753400004", "2222","Alan" , "Alan@gmail.com", Tipo.DOIS, Status.ATIVO, hoje);
		Mockito.when(mediadorMockDAO.pesquisarMediadorPorMatricula(mediador.getMatricula())).thenReturn(mediador);
		assertTrue(mediador == mediadorBO.pesquisarMediadorPorMatricula(mediador.getMatricula()));
	}

}
