package com.betacom.veicoli;

import java.util.List;

import com.betacom.veicoli.process.StartVeicolo;
import com.betacom.veicoli.utilities.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainVeicoli {

	public static String PATH_OUPUT= "/Users/gerard/Downloads/result_veicoli.txt";
	
	public static void main(String[] args) {
		List<String> param = CommonUtils.readFile("src/input_parameters.txt");
		log.info(" start veicoli base *****");
		new StartVeicolo().execute(param);
	}

}
