package com.betacom.veicoli.services;

import java.util.Map;

import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.singleton.ListManager;
import com.betacom.veicoli.utilities.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MacchinaImpl extends VeicoloAbstract{

	@Override
	public void add(String ope, String params) throws Exception {
	
		
		Map<String, String> p = CommonUtils.decodeParamers(params);

		Macchina mac = new Macchina();
		mac.setTipoVeicolo("macchina");
		
		mac = (Macchina) controlExecute(mac, p);
	
		
		if (!CommonUtils.isNumeric(p.get("porte")))
			throw new Exception("numero porte invalido per macchina ");
		mac.setNumeroPorte(Integer.parseInt(p.get("porte")));			
		
		if (ListManager.getInstance().isTargaExist(p.get("targa").toUpperCase()))
			throw new Exception("Targa già inserita. Numero targa " + p.get("targa") + " (macchina)");
		mac.setTarga(p.get("targa").toUpperCase());
		
		if (!CommonUtils.isNumeric(p.get("cc")))
			throw new Exception("cilindrato invalido cc:" + p.get("cc"));
			
		mac.setCc(Integer.parseInt(p.get("cc")));			
		
		mac = (Macchina) ListManager.getInstance().insertVeicolo(mac);
		log.info("Macchina inserita");
		
	}

}
