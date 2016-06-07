package br.ages.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.mockito.cglib.core.Local;

import br.ages.area.dao.AreaConhecimentoDAO;
import br.ages.escalaDia.bo.EscalaDiaBO;
import br.ages.escalaDia.dao.EscalaDiaDAO;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.AreaConhecimento;
import br.ages.model.EscalaDia;
import br.ages.model.Mediador;
import br.ages.model.Turno;

public class TestAlgoritmo {

	
	public static void main(String[] args) throws ClassNotFoundException, PersistenciaException, SQLException {
		
		LocalDate data = LocalDate.of(2016,05,30);
		EscalaDiaBO escalaDia = new EscalaDiaBO();
		EscalaDia[] dia = escalaDia.gerarEscala(data);
		EscalaDiaDAO escalaDao = new EscalaDiaDAO();
		for (int i = 0; i < dia.length; i++) {
//			escalaDao.criarEscalaDia(dia[i]);
			System.out.println(dia[i].getMediador().getNome()+" - "+dia[i].getArea().getNome()+" - "+dia[i].getTurno());
		}
		
	}
	
	

}
