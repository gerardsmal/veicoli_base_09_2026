package com.betacom.veicoli.services;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.betacom.veicoli.MainVeicoli;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.singleton.ListManager;
import com.betacom.veicoli.utilities.CommonUtils;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ListImpl {

	public void list(String params) {
		log.debug("**** Elenco veicoli  *****{}", params);
		CommonUtils.writeFile(MainVeicoli.PATH_OUPUT, "Elenco Veicoli con parametri "+ params+ "***", true);
	
		Map<String, String> p = CommonUtils.decodeParamers(params);
		if ("all".equalsIgnoreCase(p.get("type"))) printAll();
		if ("filter".equalsIgnoreCase(p.get("type"))) printFilter(p);
		
	}
	private void printAll() {
		ListManager.getInstance().getListV().forEach(v -> {
			log.debug(v.toString());
			CommonUtils.writeFile(MainVeicoli.PATH_OUPUT, v.toString(), true);
		});
		
	}
	private void printFilter(Map<String, String> p) {
		Predicate<Veicoli> predicate = v -> true;   // initiliza predicate
		if (p.get("tipoVeicolo") != null) {         // insert condizione
			 predicate = predicate.and(
				      v -> v.getTipoVeicolo().equalsIgnoreCase(p.get("tipoVeicolo")
				    ));
		}
		
		if (p.get("modello") != null) {
			 predicate = predicate.and(
				      v -> v.getModello().equalsIgnoreCase(p.get("modello")
				    ));
		}

		if (p.get("colore") != null) {
			 predicate = predicate.and(
				      v -> v.getColore().equalsIgnoreCase(p.get("colore")
				    ));
		}

		
		List<Veicoli> result = ListManager.getInstance().getListV().stream()
				.filter(predicate)
		        .toList();
		result.forEach(v -> {
			log.debug(v.toString());
			CommonUtils.writeFile(MainVeicoli.PATH_OUPUT, v.toString(), true);
		});
		
	}
}
