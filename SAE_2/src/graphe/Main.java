package graphe;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;


import sae2_2.Graphe;

public class Main {

	public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, IOException {
		
		
		
		GrapheMatrice gMatrice = new GrapheMatrice();
		
		GrapheListe gListe = new GrapheListe();
		/*
		gMatrice.ajouteSommet("a");
		gMatrice.ajouteSommet("b");
		gMatrice.ajouteSommet("c");
		gMatrice.ajouteSommet("d");
		
		gMatrice.ajouteArete("a", "d", 4.2);
		gMatrice.ajouteArete("d", "b", 2.6);
		gMatrice.ajouteArete("c", "a", 1.2);
		gMatrice.ajouteArete("c", "b", 8.3);
		
		gMatrice.ajouteSommet("e");
		gMatrice.ajouteSommet("f");
		gMatrice.ajouteSommet("g");
		gMatrice.ajouteSommet("h");
		
		gMatrice.ajouteArete("a", "f", 3.7);
		gMatrice.ajouteArete("d", "g", 6.1);
		gMatrice.ajouteArete("b", "h", 9.5);
		gMatrice.ajouteArete("c", "e", 7.0);
		
		gListe.ajouteSommet("a");
		gListe.ajouteSommet("b");
		gListe.ajouteSommet("c");
		gListe.ajouteSommet("d");
		
		gListe.ajouteArete("a", "d", 4.2);
		gListe.ajouteArete("d", "b", 2.6);
		gListe.ajouteArete("c", "a", 1.2);
		gListe.ajouteArete("c", "b", 8.3);
		
		gListe.ajouteSommet("e");
		gListe.ajouteSommet("f");
		gListe.ajouteSommet("g");
		gListe.ajouteSommet("h");
		
		gListe.ajouteArete("a", "f", 3.7);
		gListe.ajouteArete("d", "g", 6.1);
		gListe.ajouteArete("b", "h", 9.5);
		gListe.ajouteArete("c", "e", 7.0);


		
		//gMatrice.ajouteArete("d", "b", 4.0);
		//.ajouteArete("b", "d", 2.0);
		//gMatrice.ajouteArete("c", "a", 3.0);
		
		gMatrice.displayList();
		gListe.displayMatrice();
		
		System.out.println();
		
		System.out.println(gMatrice.getAretes());
		System.out.println(gMatrice.getSommets());
		System.out.println(gMatrice.getVoisins("a"));
		System.out.println(gMatrice.sontVoisins("c", "a"));
		
		System.out.println();
		
		System.out.println(gListe.getAretes());
		System.out.println(gListe.getSommets());
		System.out.println(gListe.getVoisins("a"));
		System.out.println(gListe.sontVoisins("a", "c"));
		
		GrapheParse parse = new GrapheParse();
		*/
		
		
		Scanner data = new Scanner(System.in);
		String file = data.next();
            
		File fil = new File("/home/romain/Bureau/SAE_2/Docs/ReseauxRoutiers/" + file);
		
		data.close();
		
		Graphe grapheM = GrapheParse.parseGraphe(gMatrice.getClass(), fil);
		System.out.println();
		Graphe grapheL = GrapheParse.parseGraphe(gListe.getClass(), fil);
		
		System.out.println(grapheM.getSommets());
		System.out.println(grapheM.getAretes());
		System.out.println(grapheL.getSommets());
		System.out.println(grapheL.getAretes());
		
		//GrapheListe gliste = new GrapheListe();
		
		//gliste.ajouteSommet("a");
		//gliste.ajouteSommet("b");
		//gliste.ajouteSommet("c");
		//gliste.ajouteSommet("d");
		//gliste.ajouteArete("a", "b", 2);
		//gliste.displayList();
		
	}

}
