package com.betacom.veicoli.models;

public class Bici extends Veicoli{
	
	private Integer numeroCorone;
	private Integer numeroMarce;
	private String tipoFreno; 
	private String tipoSospenzione;  // senza, mono, bi
	private Boolean piegevole;
	
	public Integer getNumeroCorone() {
		return numeroCorone;
	}
	public void setNumeroCorone(Integer numeroCorone) {
		this.numeroCorone = numeroCorone;
	}
	public Integer getNumeroMarce() {
		return numeroMarce;
	}
	public void setNumeroMarce(Integer numeroMarce) {
		this.numeroMarce = numeroMarce;
	}
	public String getTipoFreno() {
		return tipoFreno;
	}
	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}
	public String getTipoSospenzione() {
		return tipoSospenzione;
	}
	public void setTipoSospenzione(String tipoSospenzione) {
		this.tipoSospenzione = tipoSospenzione;
	}
	public Boolean getPiegevole() {
		return piegevole;
	}
	public void setPiegevole(Boolean piegevole) {
		this.piegevole = piegevole;
	}

}
