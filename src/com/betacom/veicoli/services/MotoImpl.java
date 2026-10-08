package com.betacom.veicoli.services;

import java.util.Map;

import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.singleton.ListManager;
import com.betacom.veicoli.utilities.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MotoImpl extends VeicoloAbstract{

	@Override
	public void add(String ope, String params) throws Exception {
		Map<String, String> p = CommonUtils.decodeParamers(params);
		
		Moto moto = new Moto();
		moto.setTipoVeicolo("moto");
		
		moto = (Moto) controlExecute(moto, p);
		
		if (ListManager.getInstance().isTargaExist(p.get("targa").toUpperCase()))
			throw new Exception("Targa già inserita");
		moto.setTarga(p.get("targa").toUpperCase());
		
		if (!CommonUtils.isNumeric(p.get("cc")))
			throw new Exception("cilindrato invalido");	
		moto.setCc(Integer.parseInt(p.get("cc")));			
		
		moto = (Moto) ListManager.getInstance().insertVeicolo(moto);
		log.info("Moto inserita");
		
	}


}
