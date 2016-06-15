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
import br.ages.exception.NegocioException;
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
		AreaConhecimento areaEdit = new AreaConhecimento(110, -5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
	}
	
	

	@Test
	public void testCadastraArea() throws PersistenciaException, SQLException, NegocioException{
		area = new AreaConhecimento(80, 70, "Taes3te", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.criarArea(area)).thenReturn(80);
		int idAreaCriada = areaBO.cadastraAreaConhecimento(area);
	
		assertTrue(idAreaCriada == area.getIdAreaConhecimento());
				
	}
	
	@Test
	public void testValidaArea() throws NegocioException {
		AreaConhecimento area = new AreaConhecimento(50, 40, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		assertTrue(areaBO.validaArea(area));
	}
	
	
	//@Test
	//public void testValidaAreaNeg() throws NegocioException {
	//	AreaConhecimento area = new AreaConhecimento(60, -5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
	//	Mockito.when(areaBO.validaArea(area)).thenThrow(NegocioException.class);
	//	try{			
	//		areaBO.validaArea(area);
	//		fail("NegocioException was expected");
	//	} catch(NegocioException e) {			
	//	}
	//}
	
	
	@Test
	public void testEditaArea() throws PersistenciaException, NegocioException{
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.editaArea(area)).thenReturn(true);
		assertTrue(areaBO.editarAreaConhecimento(area));		
	}
	
	@Test
	public void testEditaAreaNeg() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.editaArea(area)).thenThrow(ClassNotFoundException.class);
		try {
		areaBO.editarAreaConhecimento(area);
		fail("ClassNotFoundException was expected");
		} catch (NegocioException e) {			
		}
	}
		
	
	
	public void testListarAreaConhecimento(){		
	}
	
	@Test
	public void testPesquisaAreaNome() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.buscarPorNome(area.getNome())).thenReturn(area);
		assertTrue(area == areaBO.pesquisarAreaPorNome(area.getNome()));
	}
	
	@Test
	public void testPesquisaAreaNomeNeg() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.buscarPorNome(area.getNome())).thenThrow(ClassNotFoundException.class);
		try {
			areaBO.pesquisarAreaPorNome(area.getNome());
			fail("ClassNotFoundException was expected");
		} catch(ClassNotFoundException e) {
		}
	}
	
	@Test
	public void testPesquisaAreaPavimento() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.buscarPorPavimento(area.getPavimento())).thenReturn(area);
		assertTrue(area == areaBO.pesquisarAreaPorPavimento(area.getPavimento()));
	}
	
	@Test
	public void testPesquisaAreaPavimentoNeg() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.buscarPorPavimento(area.getPavimento())).thenThrow(ClassNotFoundException.class);
		try {
			areaBO.pesquisarAreaPorPavimento(area.getPavimento());
			fail("ClassNotFoundException was expected");
		} catch(ClassNotFoundException e) {
		}
	}
	
	@Test
	public void testPesquisaAreaNumero() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.buscarAreaPorNumero(area.getNumero())).thenReturn(area);
		assertTrue(area == areaBO.pesquisarAreaPorNumero(area.getNumero()));
	}
	
	@Test
	public void testPesquisaAreaNumeroNeg() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.buscarAreaPorNumero(area.getNumero())).thenThrow(ClassNotFoundException.class);
		try {
			areaBO.pesquisarAreaPorNumero(area.getNumero());
			fail("ClassNotFoundException was expected");
		} catch(ClassNotFoundException e) {
		}
	}
	
	
	@Test
	public void testPesquisaAreaId() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.pesquisarAreaPorId(area.getIdAreaConhecimento())).thenReturn(area);
		assertTrue(area == areaBO.pesquisarAreaPorId(area.getIdAreaConhecimento()));
	}
	
	@Test	
	public void testPesquisaAreaIdNeg() throws PersistenciaException, SQLException, ClassNotFoundException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.pesquisarAreaPorId(area.getIdAreaConhecimento())).thenThrow(ClassNotFoundException.class);
		try {
		areaBO.pesquisarAreaPorId(area.getIdAreaConhecimento());
		fail("ClassNotFoundException was expected");
		} catch(ClassNotFoundException e) {
		}
	}
	
	@Test
	public void testRemoveArea() throws PersistenciaException, SQLException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.removeArea(area.getIdAreaConhecimento())).thenReturn(true);
		assertTrue(areaBO.removeArea(area.getIdAreaConhecimento()));

	}
		
	@Test
	public void testRemoveAreaNeg() throws PersistenciaException, SQLException, NegocioException {
		AreaConhecimento area = new AreaConhecimento(73, 5, "Teste", Pavimento.MEZANINO, Tipo.DOIS, Status.ATIVO, 6, "Teste", hoje);
		Mockito.when(areaMockDAO.removeArea(area.getIdAreaConhecimento())).thenThrow(NegocioException.class);
		try{
		areaBO.removeArea(area.getIdAreaConhecimento());
		fail("NegocioException was expected");
		} catch(NegocioException e) {			
		}

	}	
	
	

}
