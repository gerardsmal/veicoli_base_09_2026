package com.betacom.veicoli.models;

public class Macchina extends Veicoli{

	private String targa;    // deve essere univoca
	private Integer cc;
	private Integer numeroPorte;
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	public Integer getNumeroPoorte() {
		return numeroPorte;
	}
	public void setNumeroPoorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}
}
