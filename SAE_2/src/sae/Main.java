package sae;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import sae.graphe.GrapheListe;
//import sae.graphe.GrapheMatrice;
import sae.parcours.ParcoursDijkstra;


public class Main {

	public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, IOException {
		
		
		
		//GrapheMatrice gMatrice = new GrapheMatrice();
		
		GrapheListe gListe = new GrapheListe();
		
		
		//gMatrice.displayList();
		//gListe.displayMatrice();
		
		
		File file = new File(ChooseIHM.dotFileChooser(null));
			
		gListe.creerGraphe(GrapheParse.parseAretes(file));
			
		//gMatrice.creerGraphe(GrapheParse.parseAretes(file));

		System.out.println();

		//ParcoursProfondeur pp = new ParcoursProfondeur(gliste);
			
		//ParcoursLargeur pl = new ParcoursLargeur(gMatrice);

		ParcoursDijkstra pDijkstra = new ParcoursDijkstra(gListe);

		
		String ville1 = ChooseIHM.choisirVilleDepart(gListe.getSommets());
		String ville2 = ChooseIHM.choisirVilleArrivee(gListe.getSommets());
		System.out.println("Distance entre " +
				ville1 + " et " +
				ville2 + " est de : "+
				pDijkstra.plusCourtChemin(ville1, ville2) +"Km");
		pDijkstra.existeChemin(ville1, ville2);
		

		Scanner ask = new Scanner(System.in);
		System.out.print("Voulez-vous consulter le chemin ? [y/n] : ");
		
		if(ask.hasNext("y"))
			pDijkstra.getChemin(pDijkstra.getParents(), ville2);

		ask.close();
		
	}

}
