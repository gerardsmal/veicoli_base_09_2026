package com.betacom.veicoli.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.utilities.CommonUtils;

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
		List<String> cons = CommonUtils.readFile("src/attributes.txt");
		for (String it:cons) {
			String[] el = it.split("=");
			controlli.put(el[0], el[1].split(","));
		};
	}
	
	public boolean isValidValue(String key, String value) {
	    String[] values = controlli.get(key);
	    return Arrays.stream(values)                 // control se contiene il value passato come parametro
	            .anyMatch(it -> value.equalsIgnoreCase(it));
	}
	
//	public boolean isTargaExist(String targa) {
//		if (lTarge.containsKey(targa))
//			return true;
//		
//		lTarge.put(targa.toUpperCase(), "");
//		return false;	
//		
//	}
	
	public boolean isTargaExist(String targa) {
	    return lTarge.putIfAbsent(targa.toUpperCase(), "") != null;  // return null se non esiste valore della targa se esiste
	}
	
	public Veicoli insertVeicolo(Veicoli v) {
		v.setId(++id);
		listV.add(v);
		return v;
		
	}

	public void insertAllVeicoli(List<Veicoli> veicoli) {
		listV.addAll(veicoli);
		id = listV.stream()
		        .mapToInt(Veicoli::getId)
		        .max()
		        .orElse(0);
		
	}
	
	public void remove(Integer id) {
	    listV.removeIf(it -> it.getId() == id);

	}

	public List<Veicoli> getListV() {
		return listV;
	}

}
