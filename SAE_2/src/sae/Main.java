package sae;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import sae.graphe.GrapheListe;
//import sae.graphe.GrapheMatrice;
import sae.parcours.ParcoursDijkstra;



public class Main {

	public static void main(String [] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, IOException {
		
		
		
		//GrapheMatrice gMatrice = new GrapheMatrice();
		
		GrapheListe gListe = new GrapheListe();
		
		
		//gMatrice.displayList();
		//gListe.displayMatrice();
		if(ChooseIHM.boxChooser("Voulez-vous utiliser le mode graphique ?") == 0) {
		
			
			File file = null;
			try {
				file = new File(ChooseIHM.dotFileChooser(null));
			}catch(Exception e) {
				System.out.println("Fichier inexistant");
				return;
			}
			
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
			
			if(ChooseIHM.boxChooser("Voulez-vous consulter le chemin ?") == 0)
				pDijkstra.getChemin(pDijkstra.getParents(), ville2);
		}
		else {
			File file = null;
			try {
				file = new File(args[0]);
			}catch(Exception e) {
				System.out.println("Fichier inexistant");
				return;
			}
			
			gListe.creerGraphe(GrapheParse.parseAretes(file));
				
			//gMatrice.creerGraphe(GrapheParse.parseAretes(file));
	
			System.out.println();
	
			//ParcoursProfondeur pp = new ParcoursProfondeur(gliste);
				
			//ParcoursLargeur pl = new ParcoursLargeur(gMatrice);
	
			ParcoursDijkstra pDijkstra = new ParcoursDijkstra(gListe);
	

			System.out.println("Distance entre " +
					args[1] + " et " +
					args[2] + " est de : "+
					pDijkstra.plusCourtChemin(args[1], args[2]) +"Km");
			pDijkstra.existeChemin(args[1], args[2]);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Souhaitez vous visulaiser le chemin ?");
			if(scan.hasNext("y"))
				pDijkstra.getChemin(pDijkstra.getParents(), args[2]);
			scan.close();
		}
		
		
		

		
	}

}
