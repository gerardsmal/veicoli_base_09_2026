package com.betacom.veicoli.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Moto extends Veicoli{

	private String targa;
	private Integer cc;
	
	
	@Override
	public String toString() {
		return "Moto [ Id=" + getId() + ", TipoVeicolo=" + getTipoVeicolo()
				+ ", NumeroRuote=" + getNumeroRuote() + ", TipoAlimentazione=" + getTipoAlimentazione()
				+ ", Categoria=" + getCategoria() + ", Colore=" + getColore() + ", Marca=" + getMarca()
				+ ", AnnoProduzione=" + getAnnoProduzione() + ", Modello=" + getModello() 
				+ ", targa=" + targa + ", cc=" + cc  + "]";
	}
}
