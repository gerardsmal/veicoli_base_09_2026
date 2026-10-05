package com.betacom.veicoli.models;

public class Moto extends Veicoli{

	private String targa;
	private Integer cc;
	
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
	
	@Override
	public String toString() {
		return "Moto [ Id=" + getId() + ", TipoVeicolo=" + getTipoVeicolo()
				+ ", NumeroRuote=" + getNumeroRuote() + ", TipoAlimentazione=" + getTipoAlimentazione()
				+ ", Categoria=" + getCategoria() + ", Colore=" + getColore() + ", Marca=" + getMarca()
				+ ", AnnoProduzione=" + getAnnoProduzione() + ", Modello=" + getModello() 
				+ ", targa=" + targa + ", cc=" + cc  + "]";
	}
}
