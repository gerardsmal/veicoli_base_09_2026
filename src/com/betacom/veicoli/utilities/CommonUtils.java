package com.betacom.veicoli.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CommonUtils {

	public static Map<String, String> decodeParamers(String para){
		String[] p = para.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String it:p) {
			String[] elem = it.split("=");
			map.put(elem[0],elem[1]);
		}
		return map;
	}

	
	/*
	 * read parameters
	 */
	public static List<String> readFile(String path) {
	    try (Stream<String> lines = Files.lines(Path.of(path))) {     // Files.lines -> read all lines . result in putting into stream
	        return lines.toList();
	    } catch (IOException e) {
	        System.err.println(e.getMessage());
	        return Collections.emptyList();
	    }
	}
	
	public static void writeFile(String path,String inp, boolean mode) {
		
		try (FileWriter o = new FileWriter(path, mode)){
			o.write(inp);
			o.write("\n");
		
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static boolean isNumeric(String numero) {
		return numero.matches("\\d+");
	}
	
	public static String buildClassName(String par) {		 
		if (par == null || par.isBlank()) return par;		    
		return par.substring(0, 1).toUpperCase() + par.substring(1).toLowerCase() + "Impl";
	}
	
}
