package sae;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import sae2_2.Arete;


public class GrapheParse {
	

	    public static Collection<Arete> parseAretes(File file) throws IOException,
	    																				  InvocationTargetException,
	    																				  InstantiationException,
	    																				  IllegalAccessException,
	    																				  IllegalArgumentException,
	    																				  NoSuchMethodException,
	    																				  SecurityException
	    {

	    	ArrayList<Arete> aretes = new ArrayList<Arete>();
	    	
	    	BufferedReader reader = null;

	        try {
	        	reader = new BufferedReader(new FileReader(file));
	            
	            Set<Arete> arete = reader.lines().skip(1).filter(line -> !line.equals("}"))
	                    			.map(line -> new Arete(getSommet1(line), getSommet2(line), getPoids(line)))
	                    			.collect(Collectors.toSet());
	            
	            aretes.addAll(arete);
	        }
	        
	        finally {
	            
	        	if (reader != null)
	        		reader.close();
	        }

	        return aretes;
	        
	        
	    }

	    private static String getSommet1(String arete) {
	        return arete.substring(getIndexOf(arete, "\"", 0) + 1, getIndexOf(arete, "\"", 1));
	    }

	    private static String getSommet2(String arete) {
	        return arete.substring(getIndexOf(arete, "\"", 2) + 1, getIndexOf(arete, "\"", 3));
	    }

	    private static Double getPoids(String arete) {
	        return Double.parseDouble(arete.substring(arete.indexOf("=") + 1, arete.indexOf(",")));
	    }

	    private static int getIndexOf(String line, String str, int n) {
	        int index = line.indexOf(str);
	        while (index >= 0) {
	            if (n == 0)
	                return index;

	            n -= 1;
	            index = line.indexOf(str, index + 1);
	        }

	        return index;
	    }

	}
