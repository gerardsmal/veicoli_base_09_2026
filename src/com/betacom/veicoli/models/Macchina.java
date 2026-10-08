package com.betacom.veicoli.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Macchina extends Veicoli{

	private String targa;    // deve essere univoca
	private Integer cc;
	private Integer numeroPorte;
	
	
	@Override
	public String toString() {
		return "Macchina [ Id=" + getId() + ", TipoVeicolo=" + getTipoVeicolo()
				+ ", NumeroRuote=" + getNumeroRuote() + ", TipoAlimentazione=" + getTipoAlimentazione()
				+ ", Categoria=" + getCategoria() + ", Colore=" + getColore() + ", Marca=" + getMarca()
				+ ", AnnoProduzione=" + getAnnoProduzione() + ", Modello=" + getModello() 
				+ ", targa=" + targa + ", cc=" + cc  + "]";
	}
}
