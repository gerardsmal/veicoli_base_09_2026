package com.betacom.veicoli.services;

import java.util.Map;

import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.singleton.ListManager;

public class MotoImpl extends VeicoloAbstract{

	@Override
	public void add(String ope, String params) throws Exception {
		Map<String, String> p = decodeParamers(params);
		
		Moto moto = new Moto();
		moto.setTipoVeicolo("moto");
		
		moto = (Moto) controlExecute(moto, p);
		
		if (ListManager.getInstance().isTargaExist(p.get("targa").toUpperCase()))
			throw new Exception("Targa già inserita");
		moto.setTarga(p.get("targa").toUpperCase());
		
		try {
			moto.setCc(Integer.parseInt(p.get("cc")));			
		} catch (Exception e) {
			throw new Exception("cilindrato invalido");
		}
		
		moto = (Moto) ListManager.getInstance().insertVeicolo(moto);
		System.out.println("Moto inserita");
		
	}


}
