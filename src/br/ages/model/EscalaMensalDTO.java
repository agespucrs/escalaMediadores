package br.ages.model;

public class EscalaMensalDTO{
	
	private int idMediador;
	private String nome;
	private String diasFolga;
	
	public EscalaMensalDTO(int idMediador, String nome, String diasFolga) {
		super();
		this.idMediador = idMediador;
		this.nome = nome;
		this.diasFolga = diasFolga;
	}
	
	public EscalaMensalDTO(){
		
	}
	
	public int getIdMediador() {
		return idMediador;
	}

	public void setIdMediador(int idMediador) {
		this.idMediador = idMediador;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiasFolga() {
		return diasFolga;
	}

	public void setDiasFolga(String diasFolga) {
		this.diasFolga = diasFolga;
	}
}