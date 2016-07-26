package br.ages.model;

import java.time.LocalDate;

public class EscalaDia {
	
	private Mediador mediador;
	private AreaConhecimento area;
	private LocalDate data;
	private Turno turno;
	 
	public Mediador getMediador() {
		return mediador;
	}
	public void setMediador(Mediador mediador) {
		this.mediador = mediador;
	}
	public AreaConhecimento getArea() {
		return area;
	}
	public void setArea(AreaConhecimento area) {
		this.area = area;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
 
 
 
}
