package br.ages.validator;


import java.util.Map;

import br.ages.exception.ValidationException;

/**
 * Respons�vel por validar todo os tipos de valores do sistema
 * 
 * @author Devmedia
 * 
 */
public interface Validator {
	
	/**
	 * M�todo efetivo de valida��o que recebe o mapa com os valores e os nomes
	 * 
	 * @param valores
	 * @return
	 * @throws ValidationException
	 */
	public boolean validar(Map<String, Object> valores) throws ValidationException;

}
