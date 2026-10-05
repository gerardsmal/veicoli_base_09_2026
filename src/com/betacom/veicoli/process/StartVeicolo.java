package com.betacom.veicoli.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.services.BiciImpl;
import com.betacom.veicoli.services.ListImpl;
import com.betacom.veicoli.services.MacchinaImpl;
import com.betacom.veicoli.services.MotoImpl;
import com.betacom.veicoli.services.VeicoloAbstract;
import com.betacom.veicoli.singleton.ListManager;

public class StartVeicolo {
	public final static int OPERATION=0;
	public final static int TIPO_VEICOLO=1;
	public final static int PARAMETERS=2;
	
	
	
	public void execute(List<String> param)  {
		Map<String, VeicoloAbstract> pr = new HashMap<String, VeicoloAbstract>();
		pr.put("macchina", new MacchinaImpl());
		pr.put("moto", new MotoImpl());
		pr.put("bici", new BiciImpl());
		
		ListManager.getInstance().loadConstant();
		
		for (String para:param) {
			String[] inp = para.split(";");
			String operation = inp[OPERATION].trim();
			if ("list".equalsIgnoreCase(operation)) {
				System.out.println(">>>" + operation );
				new ListImpl().list();				
			}
			else {
				if (pr.containsKey(inp[TIPO_VEICOLO])){
					if (operation.equalsIgnoreCase("add")) {
						VeicoloAbstract veicolo = pr.get(inp[TIPO_VEICOLO]);
						try {
							System.out.println(inp[PARAMETERS]);
							veicolo.add(operation, inp[PARAMETERS]);
											
						} catch (Exception e) {
							System.err.println("Error found:" + e.getMessage());
						}
					}

				} else
					System.err.println("il tipo " + inp[TIPO_VEICOLO] + " non é previsto.");
			}
			
			
		}
	}
}
