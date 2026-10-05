package com.betacom.veicoli;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PageRanges;

import com.betacom.veicoli.process.StartVeicolo;

public class MainVeicoli {

	/*
	 * 	parsing parametri
	 *  controllare 1. parametri veicolo .. validità del valore del parametro (cat = una categaria prevista) , alim
	 *  									univocita della targa
	 *  									campi numerici sono veramente numerici
	 *  									
	 *  			2. veicolo specifico 
	 *  se va bene inserire l'oggetto dentro un liste commune per tutti (creazione d'un id progressivo)
	 *  con la funzione list, fare la list dei oggetti ...
	 */
	
	public static void main(String[] args) {
		List<String> param = List.of(
				"add;macchina;ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2025,modello=500,porte=4,targa=el234gx,cc=1200",
				"add;macchina;ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2026,modello=panda,porte=4,targa=fl234gx,cc=1300",
				"add;macchina;ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2026,modello=panda,porte=4,targa=fl234gx,cc=1300",
				"add;moto;ruote=2,alim=benzina,cat=strada,colore=nero,marca=Yamaha,anno=2025,modello=r1,targa=EL22239,cc=900",
				"add;bici;ruote=2,alim=manuale,cat=strada,colore=nero,marca=Bianchi,anno=2025,modello=Grizl 5,marce=10,sospenzione=senza,piegevole=no",
				"list"
		);
		
		System.out.println("Start Veicoli");
		new StartVeicolo().execute(param);
	}

}
