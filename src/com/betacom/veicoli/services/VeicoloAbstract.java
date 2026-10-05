package com.betacom.veicoli.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.singleton.ListManager;

public abstract class VeicoloAbstract {
	
	public abstract void add(String ope, String params) throws Exception;	
	
	public Map<String, String> decodeParamers(String para){
		String[] p = para.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String it:p) {
			String[] elem = it.split("=");
			map.put(elem[0],elem[1]);
		}
		return map;
	}
	
	public Veicoli  controlExecute(Veicoli vei,  Map<String, String> params) throws Exception {
		
		try {
			vei.setNumeroRuote(Integer.parseInt(params.get("ruote")));			
		} catch (Exception e) {
			throw new Exception("numero route invalido");
		}
		if (!ListManager.getInstance().isValidValue("alim", params.get("alim")))
			throw new Exception("Tipo alimentazione invalida");
		vei.setTipoAlimentazione(params.get("alim"));
		
		
		if (!ListManager.getInstance().isValidValue("cat", params.get("cat")))
			throw new Exception("Categoria invalida");
		vei.setCategoria(params.get("cat"));

		if (!ListManager.getInstance().isValidValue("colore", params.get("colore")))
			throw new Exception("Colore invalida");
		vei.setColore(params.get("colore"));


		if (!ListManager.getInstance().isValidValue("marca", params.get("marca")))
			throw new Exception("Marca invalida");
		vei.setMarca(params.get("marca"));
		
		
		try {
			vei.setAnnoProduzione(Integer.parseInt(params.get("anno")));			
		} catch (NumberFormatException e) {
			throw new Exception("Anno produzione invalida");
		}

		if (vei.getAnnoProduzione() < LocalDate.now().getYear() - 20 || vei.getAnnoProduzione() > LocalDate.now().getYear())
			throw new Exception("Anno produzione invalida");
		
		vei.setModello(params.get("modello"));
		
		
		return vei;
	}
}
