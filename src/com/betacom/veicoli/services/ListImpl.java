package com.betacom.veicoli.services;

import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.singleton.ListManager;

public class ListImpl {

	public void list() {
		System.out.println("**** Elenco veicoli  *****");
		
		for (Veicoli ve:ListManager.getInstance().getListV()) {
			System.out.println(ve);
		}
	}
}
