package br.ages.model;

import java.util.Date;

public class AreaConhecimento
{									
	private int idAreaConhecimento;
	private int numero;
	private String nome;
	private Pavimento pavimento;
	//private Turno turno;
	private Tipo tipoArea;
	private String statusArea;
	private int numeroMediadores;
	private String observacao;
	private Date dataCadastro;
									
	public int getIdAreaConhecimento(){
		 return idAreaConhecimento;
	}
 
	public void  setIdAreaConhecimento( int value){
		 idAreaConhecimento = value;
	}
	public int getNumero(){
		 return numero;
	}
 
	public void  setNumero( int value){
		 numero = value;
	}
	public String getNome(){
		 return nome;
	}
 
	public void  setNome( String value){
		 nome = value;
	}
	public Pavimento getPavimento(){
		 return pavimento;
	}
 
	public void  setPavimento(Pavimento value){
		 pavimento = value;
	}
	public Tipo getTipoArea(){
		 return tipoArea;
	}
 
	public void  setTipoArea(Tipo value){
		 tipoArea = value;
	}
	public String getStatusArea(){
		 return statusArea;
	}
 
	public void  setStatusArea( String value){
		 statusArea = value;
	}
	public int getNumeroMediadores(){
		 return numeroMediadores;
	}
 
	public void  setNumeroMediadores( int value){
		 numeroMediadores = value;
	}
	public String getObservacao(){
		 return observacao;
	}
 
	public void  setObservacao( String value){
		 observacao = value;
	}
	public Date getDataCadastro(){
		 return dataCadastro;
	}
 
	public void  setDataCadastro( Date value){
		 dataCadastro = value;
	}
}
