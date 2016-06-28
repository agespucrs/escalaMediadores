package br.ages.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
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

}
