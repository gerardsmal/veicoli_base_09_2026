package com.betacom.veicoli.process;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.MainVeicoli;
import com.betacom.veicoli.services.BiciImpl;
import com.betacom.veicoli.services.ListImpl;
import com.betacom.veicoli.services.MacchinaImpl;
import com.betacom.veicoli.services.MotoImpl;
import com.betacom.veicoli.services.VeicoloAbstract;
import com.betacom.veicoli.singleton.ListManager;
import com.betacom.veicoli.utilities.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartVeicolo {
	public final static int OPERATION=0;
	public final static int TIPO_VEICOLO=1;
	public final static int PARAMETERS=2;
	public final static int PARAMETERS_LIST=1;
	
	private Map<String,VeicoloAbstract> cache = new HashMap<String, VeicoloAbstract>();  // cache per evitare multiple new instance
	private final static String PATH_SERVICES = "com.betacom.veicoli.services";
	private final static ListImpl listService = new ListImpl();
	
	public void execute(List<String> param)  {
		
		ListManager.getInstance().loadConstant();
		CommonUtils.writeFile(MainVeicoli.PATH_OUPUT, "Begin Veicoli ***", false);
		
		for (String para:param) {
			try {
				String[] inp = para.split(";");
				String operation = inp[OPERATION].trim();
				executeCommand(operation, inp);
			} catch (Exception e) {
				log.error(e.getMessage());
			}

		}
		CommonUtils.writeFile(MainVeicoli.PATH_OUPUT, "End Veicoli ***", true);
	}
	private void executeCommand(String operation, String[] inp) throws Exception{
		if ("list".equalsIgnoreCase(operation)) {
			if (inp.length != 2)
				throw new Exception("parametro invalido per la list " + inp.length);
			listService.list(inp[PARAMETERS_LIST]);
			return;  // early return
		}
		if (inp.length != 3)
			throw new Exception("parametro invalido per " + operation + " " + inp.length);		
		String tipo = inp[TIPO_VEICOLO].trim();
		VeicoloAbstract ex = loadService(tipo);
		executeOperation(operation,ex,inp[PARAMETERS]);		
	}
	
	/*
	 * Dynamic load e new instance process class
	 */
	private VeicoloAbstract loadService(String name)  throws Exception{
		try {
			if (cache.containsKey(name)) return cache.get(name);
			
			Class<?> cl = Class.forName(PATH_SERVICES + "." + CommonUtils.buildClassName(name));
			VeicoloAbstract obj = (VeicoloAbstract)cl.getDeclaredConstructor().newInstance();
			cache.put(name, obj);
			return obj;
			
		} catch (ClassNotFoundException e) {
			throw new Exception("tipo veicolo non supportato " + name);
		}		
	}
	
	/*
	 * Dynamic execute specific method for any vehicle
	 * use reflection API
	 */
	private void executeOperation(String operation, VeicoloAbstract myService, String parameters) throws Exception{
		try {
			String methodName =  operation.toLowerCase().trim();
			Method metodo = myService.getClass().getMethod(methodName, String.class, String.class);
			metodo.invoke(myService,operation,parameters);		
			
		} catch (SecurityException e) {
			throw new Exception("error di sicurezza.." + e.getMessage());
		} catch (IllegalAccessException e) {
			throw new Exception("Errore IllegalAccess" + e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new Exception("Errore IllegalArgument" + e.getMessage());
		} catch (InvocationTargetException e) {            // retrieve error from invoke method (AcademyException)
			throw new Exception(e.getCause().getMessage());
		} catch (NoSuchMethodException e) {
			throw new Exception("funzione non trovata:" + operation);
		}
	}
}
