package com.betacom.veicoli.services;

import java.io.File;
import java.util.List;

import com.betacom.veicoli.MainVeicoli;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.singleton.ListManager;
import com.betacom.veicoli.utilities.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonImpl {
	
	public void exportService() {
		log.debug("Begin ExportImpl");
		try {
		
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
			String json = mapper.writeValueAsString(ListManager.getInstance().getListV());
			CommonUtils.writeFile(MainVeicoli.PATH_EXPORT, json, false);
			log.info("Export di {} veicoli eseguito", ListManager.getInstance().getListV().size());
			
		} catch (JsonProcessingException e) {
			log.error("JsonProcessingException: {}", e.getMessage());
		}
	}
	
	public void importService() {
		log.debug("Begin importService");
		ObjectMapper mapper = new ObjectMapper();	
		
		try {			
			List<Veicoli> allV =   mapper.readValue(
				        new File(MainVeicoli.PATH_IMPORT),
				        new TypeReference<List<Veicoli>>() {}
				    );		
			ListManager.getInstance().insertAllVeicoli(allV);

			log.info("Import {} veicoli", allV.size());
		} catch (Exception e) {
			log.error("Errore nell'import : {}", e.getMessage());
			e.printStackTrace();
		} 
		
	}

}
