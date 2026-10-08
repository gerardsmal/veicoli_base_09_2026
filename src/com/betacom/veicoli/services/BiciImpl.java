package com.betacom.veicoli.services;

import java.util.Map;

import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.singleton.ListManager;
import com.betacom.veicoli.utilities.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BiciImpl extends VeicoloAbstract{

	@Override
	public void add(String ope, String params) throws Exception {
		Map<String, String> p = CommonUtils.decodeParamers(params);
		Bici bici = new Bici();
		bici.setTipoVeicolo("bici");
		
		bici = (Bici) controlExecute(bici, p);

		if (!CommonUtils.isNumeric(p.get("marce")))
			throw new Exception("numero marce invalido");
		bici.setNumeroMarce(Integer.parseInt(p.get("marce")));			

		if (!ListManager.getInstance().isValidValue("sospenzione", p.get("sospenzione")))
			throw new Exception("Tipo sospenzione invalida");
		bici.setTipoSospenzione(p.get("sospenzione"));
		
		bici.setPiegevole(p.get("piegevole").trim().equalsIgnoreCase("si") ? true : false);


		bici = (Bici) ListManager.getInstance().insertVeicolo(bici);
		
		log.info(".... Bici inserita");
		
	}

}
