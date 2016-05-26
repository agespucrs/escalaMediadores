package br.ages.model;

public class EscalaMensalDTO{
	
	private int idEscalaMes;
	private int idMediador;
	private String diasFolga;
	
	public EscalaMensalDTO(int idEscalaMes, int idMediador, String diasFolga) {
		super();
		this.idEscalaMes = idEscalaMes;
		this.idMediador = idMediador;
		this.diasFolga = diasFolga;
	}
	
	public EscalaMensalDTO(){
		
	}

	public int getIdEscalaMes() {
		return idEscalaMes;
	}

	public void setIdEscalaMes(int idEscalaMes) {
		this.idEscalaMes = idEscalaMes;
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