package br.ages.model;

import java.util.Date;

public class Mediador
{							
	private int idMediador;
	private String cpf;
	private String matricula;
	private String nome;
	private String email;
	private Tipo tipoMediador;
	private Status statusMediador;
	private Date dataCadastro;
	

	public Mediador(){
	}
	
	public Mediador(int idMediador, String cpf, String matricula, String nome, String email, Tipo tipoMediador,
			Status statusMediador, Date dataCadastro) {
		super();
		this.idMediador = idMediador;
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.tipoMediador = tipoMediador;
		this.statusMediador = statusMediador;
		this.dataCadastro = dataCadastro;
	}


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

	public Tipo getTipoMediador(){
		 return tipoMediador;
	}
 
	public void  setTipoMediador(Tipo value){
		 tipoMediador = value;
	}
	public Status getStatusMediador(){
		 return statusMediador;
	}
 
	public void  setStatusMediador(Status value){
		 statusMediador = value;
	}
	public Date getDataCadastro(){
		 return dataCadastro;
	}
 
	public void  setDataCadastro( Date value){
		 dataCadastro = value;
	}

	@Override
	public String toString() {
		return "[idMediador=" + idMediador + ", cpf=" + cpf + ", matricula=" + matricula + ", nome=" + nome
				+ ", email=" + email + ", tipoMediador=" + tipoMediador + ", statusMediador=" + statusMediador
				+ ", dataCadastro=" + dataCadastro + "]";
	}
	
	
}

