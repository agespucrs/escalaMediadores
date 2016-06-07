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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mysql.fabric.xmlrpc.base.Data;

import br.ages.area.bo.AreaConhecimentoBO;
import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.model.AreaConhecimento;
import br.ages.model.Pavimento;
import br.ages.model.Status;
import br.ages.model.Tipo;
import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.class)
public class testAreaBO {
	
	AreaConhecimento area = new AreaConhecimento();
	Pavimento pavimento;
	Tipo tipo;
	Status status;
	Date hoje;
	
	
	@Mock
	AreaConhecimentoDAO areaMockDAO;
	AreaConhecimentoBO areaBO;
		
	@Before
	public void setUp(){								
		areaBO = new AreaConhecimentoBO();
		areaBO.setAreaDAO(areaMockDAO);
	}
	
	

	@Test
	public void testCadastraArea() throws PersistenciaException, SQLException, NegocioException{
		area = new AreaConhecimento(80, 70, "Taes3te", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.criarArea(area)).thenReturn(80);
		int idAreaCriada = areaBO.cadastraAreaConhecimento(area);
	
		assertTrue(idAreaCriada == area.getIdAreaConhecimento());
				
	}
	
	
	
	public void testValidaArea() throws NegocioException, SQLException{
		AreaConhecimento area = new AreaConhecimento(50, 40, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaBO.validaArea(area)).thenReturn(true);
		assertTrue(areaBO.validaArea(area));
	}
		

}