package com.betacom.veicoli.services;

import java.util.Map;

import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.singleton.ListManager;

public class BiciImpl extends VeicoloAbstract{

	@Override
	public void add(String ope, String params) throws Exception {
		Map<String, String> p = decodeParamers(params);
		Bici bici = new Bici();
		bici.setTipoVeicolo("bici");
		
		bici = (Bici) controlExecute(bici, p);

		try {
			bici.setNumeroMarce(Integer.parseInt(p.get("marce")));			
		} catch (Exception e) {
			throw new Exception("numero marce invalido");
		}

		if (!ListManager.getInstance().isValidValue("sospenzione", p.get("sospenzione")))
			throw new Exception("Tipo sospenzione invalida");
		bici.setTipoSospenzione(p.get("sospenzione"));
		
		bici.setPiegevole(p.get("piegevole").trim().equalsIgnoreCase("si") ? true : false);


		bici = (Bici) ListManager.getInstance().insertVeicolo(bici);
		
		System.out.println(".... Bici inserita");
		
	}

}
