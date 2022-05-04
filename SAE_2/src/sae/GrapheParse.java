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
	                    .map(line ->
	                    	new Arete(
	                    			line.substring(getIndex(line, "\"", 0) + 1, getIndex(line, "\"", 1)),
	                    			line.substring(getIndex(line, "\"", 2) + 1, getIndex(line, "\"", 3)),
	                    			Double.parseDouble(line.substring(line.indexOf("=") + 1, line.indexOf(",")))))
	                    .collect(Collectors.toSet());
	            
	            aretes.addAll(arete);
	        }      
	        finally {
	            
	        	if (reader != null)
	        		reader.close();
	        }
	        return aretes;
	    }

	    private static int getIndex(String ligne, String string, int a) {
	        
	    	int index = ligne.indexOf(string);
	        while (index >= 0) {
	            if (a == 0)
	                return index;

	            a -= 1;
	            index = ligne.indexOf(string, index + 1);
	        }
	        return index;
	    }

	}
