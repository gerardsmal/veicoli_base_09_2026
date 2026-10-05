package com.betacom.veicoli.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.models.Veicoli;

public class ListManager {
	private static ListManager instance = null;
	
	private Integer id = 0;
	Map<String, String[]> controlli = new HashMap<String, String[]>();
	Map<String, String> lTarge = new HashMap<String, String>();
	private List<Veicoli> listV = new ArrayList<Veicoli>();
	
	
	private ListManager() {
	}
	

	public static ListManager getInstance() {
		if (instance == null) {
			instance = new ListManager();
		}
		return instance;
	}
	
	public void loadConstant() {
		List<String> cons = List.of(
			"alim=benzina,diesel,electica,ibrida,manuale",
			"cat=strada,fuoristrada,suv,mtb,cross",
			"colore=bianco,nero,verde,giallo,marrone,rosso",
			"marca=Fiat,Renault,BMW,Telsla,Bianchi,Yamaha,Mercedes,Tecnizer",
			"sospenzione=senza,mono,bi"
		);
		for (String it:cons) {
			String[] el = it.split("=");
			controlli.put(el[0], el[1].split(","));
		};
	}
	
	public boolean isValidValue(String key, String value) {
	    String[] values = controlli.get(key);
	    for (String it:values) {
	    	if (value.equalsIgnoreCase(it))
	    		return true;
	    }
	    return false;
	}
	
	public boolean isTargaExist(String targa) {
		if (lTarge.containsKey(targa))
			return true;
		
		lTarge.put(targa.toUpperCase(), "");
		return false;	
		
	}
	
	public Veicoli insertVeicolo(Veicoli v) {
		v.setId(++id);
		listV.add(v);
		return v;
		
	}

	public void remove(Integer id) {
	    listV.removeIf(it -> it.getId() == id);

	}

	public List<Veicoli> getListV() {
		return listV;
	}

}
