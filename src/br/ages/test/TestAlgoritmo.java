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
//		MediadorDAO mediadorDao = new MediadorDAO();
//		EscalaDiaDAO escalaDao = new EscalaDiaDAO();
//		List<Mediador> mediadoresAtivos = mediadorDao.listaMediadoresAtivos(LocalDate.now()); 
//		EscalaDia[] escala = new EscalaDia[mediadoresAtivos.size()];
//		AreaConhecimentoDAO areaDao = new AreaConhecimentoDAO();
//		
//		
//		
//		for (int i = 0; i < escala.length; i++) {
//			escala[i] = new EscalaDia();
//			escala[i].setMediador(mediadoresAtivos.get(i));
//		}
//		
//		List<AreaConhecimento> areasDisponiveis = areaDao.listarAreasDisponiveis();
//		boolean procurando = true;
//		int count = 1;
//		int i = 0;
//		while(procurando){
//			AreaConhecimento novaAreaManha = areasDisponiveis.get(areasDisponiveis.indexOf(count%(areasDisponiveis.size()-1)));
//			AreaConhecimento novaAreaAlmoco = areasDisponiveis.get(areasDisponiveis.indexOf((count+1)%(areasDisponiveis.size()-1)));
//			AreaConhecimento novaAreaTarde = areasDisponiveis.get(areasDisponiveis.indexOf((count+2)%(areasDisponiveis.size()-1)));
//			if (novaAreaManha.getNumeroMediadores() > 0) {
//				escala[i].setArea(novaAreaManha);
//				escala[i].setTurno(Turno.MANHÃ);
//				novaAreaManha.setNumeroMediadores(novaAreaManha.getNumeroMediadores()-1);
//				procurando = false;
//			}else{
//				count++;
//			}
//			if (novaAreaAlmoco.getNumeroMediadores() > 0) {
//				escala[i].setArea(novaAreaAlmoco);
//				escala[i].setTurno(Turno.MANHÃ);
//				novaAreaAlmoco.setNumeroMediadores(novaAreaAlmoco.getNumeroMediadores()-1);
//				procurando = false;
//			}else{
//				count++;
//			}
//			if (novaAreaTarde.getNumeroMediadores() > 0) {
//				escala[i].setArea(novaAreaTarde);
//				escala[i].setTurno(Turno.MANHÃ);
//				novaAreaTarde.setNumeroMediadores(novaAreaTarde.getNumeroMediadores()-1);
//				procurando = false;
//			}else{
//				count++;
//			}
//			
//		}
		
//		
//		for (int j = 0; j < escala.length; j++) {
//			escalaDao.criarEscalaDia(escala[j]);
//		}
//		
		
		LocalDate data = LocalDate.of(2016,05,30);
		EscalaDiaBO escalaDia = new EscalaDiaBO();
		EscalaDia[] dia = escalaDia.gerarEscala(data);
		for (int i = 0; i < dia.length; i++) {
			System.out.println(dia[i].getMediador().getNome());
		}
		
	}
	
	

}
