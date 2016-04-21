package br.ages.mediador.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ages.exception.NegocioException;
import br.ages.exception.PersistenciaException;
import br.ages.mediador.dao.MediadorDAO;
import br.ages.model.Mediador;
import br.ages.util.MensagemContantes;
import br.ages.validator.CPFValidator;

public class MediadorBO {
	
	MediadorDAO mediadorDAO = null;
	CPFValidator cpfValidator = null;
	public MediadorBO(){
		mediadorDAO = new MediadorDAO();
		cpfValidator = new CPFValidator();
	}

	public boolean validaMediador(Mediador mediador) throws NegocioException{
		boolean isValido = true;
		StringBuilder msg = new StringBuilder();
		msg.append(MensagemContantes.MSG_ERR_MEDIADOR_DADOS_INVALIDOS.concat("<br>"));
		
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		Map<String, Object> cpf = new HashMap<>();
		cpf.put("CPF", mediador.getCpf());		
		
		try {
			if(!cpfValidator.validar(cpf)){
				isValido = false;
				msg.append(MensagemContantes.MSG_CPF_INVALIDO);
			}
			
			if(!mediador.getMatricula().matches("\\d{5,9}")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_MATRICULA_INVALIDA.replace("?", "Matrí­cula").concat("<br/>"));
			}
			
			if(mediador.getNome() == null || "".equals(mediador.getNome())){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Mediador").concat("<br/>"));
			}
			
			if(!mediador.getEmail().matches(EMAIL_PATTERN)){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_EMAIL_INVALIDO.replace("?", "Mediador").concat("<br/>"));
			}
			
			//String nome = Normalizer.normalize(mediador.getNome(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			
			if (mediador.getNome().equals("") || mediador.getNome() == null) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_NOME_INVALIDO.replace("?", "Nome ").concat("<br/>"));
			}
			
			if (!isValido) {
				throw new NegocioException(msg.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return isValido;
	}
	
	public int cadastraMediador(Mediador mediador) throws ClassNotFoundException, SQLException, NegocioException{
		int id;
		try {
			id = mediadorDAO.cadastrarMediador(mediador);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return id;
	}
	
	public void editaMediador(Mediador mediador) throws NegocioException{
		try {
			mediadorDAO.editaMediador(mediador);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	
	public void removeMediador(int idMediador) throws NegocioException{
		try {
			mediadorDAO.removeMediador(idMediador);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	public List<Mediador> listarMediadores() throws NegocioException{
		List<Mediador> listaMed = null;
		
		try{
			listaMed = mediadorDAO.listaMediadores();
		} catch(PersistenciaException | SQLException se){
			se.printStackTrace();
			throw new NegocioException(se);
		}
		return listaMed;
	}
	
	public Mediador pesquisarMediadorPorNome(String nome) throws NegocioException{
		Mediador med = new Mediador();
				
		try{
			med = mediadorDAO.pesquisarMediadorPorNome(nome);
		} catch(PersistenciaException | SQLException se){
			se.printStackTrace();
			throw new NegocioException(se);
		}	
		return med;
	}
	
	public Mediador pesquisarMediadorPorId(int id) throws NegocioException, ParseException{
		Mediador med = new Mediador();
				
		try{
			med = mediadorDAO.pesquisarMediadorPorId(id);
		} catch(PersistenciaException | SQLException se){
			se.printStackTrace();
			throw new NegocioException(se);
		}	
		return med;
	}
	
	public Mediador pesquisarMediadorPorCpf(String cpf) throws NegocioException{
		Mediador med = new Mediador();
				
		try{
			med = mediadorDAO.pesquisarMediadorPorCpf(cpf);
		} catch(PersistenciaException | SQLException se){
			se.printStackTrace();
			throw new NegocioException(se);
		}	
		return med;
	}
	
	public Mediador pesquisarMediadorPorMatricula(String matricula) throws NegocioException{
		Mediador med = new Mediador();
				
		try{
			med = mediadorDAO.pesquisarMediadorPorCpf(matricula);
		} catch(PersistenciaException | SQLException se){
			se.printStackTrace();
			throw new NegocioException(se);
		}	
		return med;
	}
}
