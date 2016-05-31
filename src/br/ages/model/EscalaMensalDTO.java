package br.ages.model;

public class EscalaMensalDTO{
	
	private int idMediador;
	private String diasFolga;
	
	public EscalaMensalDTO(int idMediador, String diasFolga) {
		super();
		this.idMediador = idMediador;
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

	public String getDiasFolga() {
		return diasFolga;
	}

	public void setDiasFolga(String diasFolga) {
		this.diasFolga = diasFolga;
	}
}