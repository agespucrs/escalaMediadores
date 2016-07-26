package br.ages.model;

public class Ferias {
	private int idEscalaMes;
	private int idMediador;
	private String dia;
	private String mes;
	private String ano;
	private String tipoFolga;
	
	public Ferias(){
		
	}

	public Ferias(int idEscalaMes, int idMediador, String dia, String mes, String ano, String tipoFolga) {
		super();
		this.idEscalaMes = idEscalaMes;
		this.idMediador = idMediador;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.tipoFolga = tipoFolga;
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

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTipoFolga() {
		return tipoFolga;
	}

	public void setTipoFolga(String tipoFolga) {
		this.tipoFolga = tipoFolga;
	}
}
