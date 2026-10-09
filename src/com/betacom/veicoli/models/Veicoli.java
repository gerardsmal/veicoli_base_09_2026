package com.betacom.veicoli.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.EXISTING_PROPERTY,
	    property = "tipoVeicolo",
	    visible = true
	)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Macchina.class, name = "macchina"),
    @JsonSubTypes.Type(value = Moto.class, name = "moto"),
    @JsonSubTypes.Type(value = Bici.class, name = "bici")
})
public class Veicoli {
	private Integer id;                 //id univoco del record
	private String  tipoVeicolo;        // macchina , moto , bici
	private Integer numeroRuote;        // dipende del tipo veicolo
	private String  tipoAlimentazione;  // bensine, diesel, electrica, hybrid, manual
	private String  categoria;          // strada, fuoristrada, suv, moticross......
	private String  colore;
	private String  marca;             // fiat, bmw....
	private Integer annoProduzione;
	private String modello;
	
	
}
