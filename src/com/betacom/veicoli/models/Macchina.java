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
	public Integer getNumeroPorte() {
		return numeroPorte;
	}
	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}
	
	@Override
	public String toString() {
		return "Macchina [ Id=" + getId() + ", TipoVeicolo=" + getTipoVeicolo()
				+ ", NumeroRuote=" + getNumeroRuote() + ", TipoAlimentazione=" + getTipoAlimentazione()
				+ ", Categoria=" + getCategoria() + ", Colore=" + getColore() + ", Marca=" + getMarca()
				+ ", AnnoProduzione=" + getAnnoProduzione() + ", Modello=" + getModello() 
				+ ", targa=" + targa + ", cc=" + cc  + "]";
	}
}
