package br.ages.test;

import java.sql.SQLException;
import java.time.LocalDate;

import br.ages.escalaDia.bo.EscalaDiaBO;
import br.ages.escalaDia.dao.EscalaDiaDAO;
import br.ages.exception.PersistenciaException;
import br.ages.model.EscalaDia;

public class TestAlgoritmo {

	
	public static void main(String[] args) throws ClassNotFoundException, PersistenciaException, SQLException {
		
		LocalDate data = LocalDate.now();
		EscalaDiaBO escalaDia = new EscalaDiaBO();
		EscalaDia[] dia = escalaDia.gerarEscala(data);
		EscalaDiaDAO escalaDao = new EscalaDiaDAO();
		for (int i = 0; i < dia.length; i++) {
//			escalaDao.criarEscalaDia(dia[i]);
			System.out.println(dia[i].getMediador().getNome()+" - "+dia[i].getArea().getNome()+" - "+dia[i].getTurno()+" - "+dia[i].getData().toString());
		}
		
	}
	
	

}
