package br.ages.model;

import java.util.Date;

public class Mediador
{							
	private int idMediador;
	private String cpf;
	private String matricula;
	private String nome;
	private String email;
	private String tipoMediador;
	private String statusMediador;
	private Date dataCadastro;
							
	public int getIdMediador(){
		 return idMediador;
	}
 
	public void  setIdMediador( int value){
		 idMediador = value;
	}
	public String getCpf(){
		 return cpf;
	}
 
	public void  setCpf( String value){
		 cpf = value;
	}
	public String getMatricula(){
		 return matricula;
	}
 
	public void  setMatricula( String value){
		 matricula = value;
	}
	public String getNome(){
		 return nome;
	}
 
	public void  setNome( String value){
		 nome = value;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoMediador(){
		 return tipoMediador;
	}
 
	public void  setTipoMediador( String value){
		 tipoMediador = value;
	}
	public String getStatusMediador(){
		 return statusMediador;
	}
 
	public void  setStatusMediador( String value){
		 statusMediador = value;
	}
	public Date getDataCadastro(){
		 return dataCadastro;
	}
 
	public void  setDataCadastro( Date value){
		 dataCadastro = value;
	}
}

