package graphe;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

import sae2_2.Arete;
import sae2_2.Graphe;

public class GrapheParse {
	

	    public static Graphe parseGraphe(Class<? extends Graphe> clazz, File file)
	            throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException,
	            IllegalArgumentException, NoSuchMethodException, SecurityException {
	        
	    	Graphe graphe = clazz.getConstructor().newInstance();
	        BufferedReader br = null;

	        try {
	            br = new BufferedReader(new FileReader(file));
	            Set<Arete> aretes = br.lines().skip(1).filter(line -> !line.equals("}"))
	                    .map(line -> new Arete(getSommet1(line), getSommet2(line), getPoids(line)))
	                    .collect(Collectors.toSet());
	            
	            graphe.creerGraphe(aretes);
	        } finally {
	            if (br != null)
	                br.close();
	        }

	        return graphe;
	        
	        
	    }

	    private static String getSommet1(String str) {
	        return str.substring(getIndexOf(str, "\"", 0) + 1, getIndexOf(str, "\"", 1));
	    }

	    private static String getSommet2(String str) {
	        return str.substring(getIndexOf(str, "\"", 2) + 1, getIndexOf(str, "\"", 3));
	    }

	    private static Double getPoids(String str) {
	        return Double.parseDouble(str.substring(str.indexOf("=") + 1, str.indexOf(",")));
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
