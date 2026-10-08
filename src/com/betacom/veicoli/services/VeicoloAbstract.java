package com.betacom.veicoli.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.singleton.ListManager;
import com.betacom.veicoli.utilities.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class VeicoloAbstract {
	
	public abstract void add(String ope, String params) throws Exception;	
	
	
	public Veicoli  controlExecute(Veicoli vei,  Map<String, String> params) throws Exception {
		
		if (!CommonUtils.isNumeric(params.get("ruote")))
			throw new Exception("numero route invalido");
		vei.setNumeroRuote(Integer.parseInt(params.get("ruote")));			

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
			throw new Exception("Marca invalida :" + params.get("marca"));
		vei.setMarca(params.get("marca"));
		
		
		if (!CommonUtils.isNumeric(params.get("anno")))
			throw new Exception("Anno produzione invalida :" + params.get("anno"));
		vei.setAnnoProduzione(Integer.parseInt(params.get("anno")));			

		if (vei.getAnnoProduzione() < LocalDate.now().getYear() - 20 || vei.getAnnoProduzione() > LocalDate.now().getYear())
			throw new Exception("Anno produzione troppo vecchia");
		
		vei.setModello(params.get("modello"));
		
		
		return vei;
	}
	
	public void delete(String ope, String params) throws Exception {
		Map<String, String> p = CommonUtils.decodeParamers(params);
		log.info("deleteVeicolo: {}" , p);
		if (p.get("id") == null) {
			throw new Exception("id mancante per remove");
		}
		ListManager.getInstance().remove(Integer.parseInt(p.get("id")));
		log.info("Veicolo cancellata");
	}
}
