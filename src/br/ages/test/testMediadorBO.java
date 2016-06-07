	package br.ages.test;

	import static org.junit.Assert.*;

	import java.sql.Date;
	import java.sql.SQLException;

	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.runners.MockitoJUnitRunner;

	import com.mysql.fabric.xmlrpc.base.Data;

	import br.ages.exception.NegocioException;
	import br.ages.exception.PersistenciaException;
import br.ages.mediador.bo.MediadorBO;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.AreaConhecimento;
    import br.ages.model.Mediador;
    import br.ages.model.Pavimento;
	import br.ages.model.Status;
	import br.ages.model.Tipo;
	import junit.framework.Assert;


	@RunWith(MockitoJUnitRunner.class)
	public class testMediadorBO {
		
		Mediador mediador = new Mediador();
		 int idMediador;
		 String cpf;
		 String matricula;
		 String nome;
		 String email;
		 Tipo tipoMediador;
		 Status statusMediador;
		 Date dataCadastro;
		
		
		@Mock
		private MediadorBO mediadorBO;
		private MediadorDAO mediadorMockDAO;
			
		@Before
		public void setUp(){	
					mediadorBO = new MediadorBO();
					mediadorMockDAO = new MediadorDAO();
		}
		
		@Test
		public void testCadastraArea() throws PersistenciaException, SQLException, NegocioException, ClassNotFoundException{
			Mediador mediador = new Mediador(6, "85434345665", "56756","Laura" , "Laura@gmail.com", Tipo.DOIS, Status.ATIVO, null);
			Mockito.when(mediadorMockDAO.cadastrarMediador(mediador)).thenReturn(80);
			assertTrue(mediadorBO.cadastraMediador(mediador) == mediador.getIdMediador());
					
		}
		
		public void testValidaMediador() throws NegocioException, SQLException{
			Mediador mediador = new Mediador(6, "85434345665", "56756","Laura" , "Laura@gmail.com", Tipo.DOIS, Status.ATIVO, null);
			Mockito.when(mediadorBO.validaMediador(mediador)).thenReturn(true);
			assertTrue(mediadorBO.validaMediador(mediador));
		}
			

	}


