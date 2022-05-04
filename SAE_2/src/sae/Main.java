package sae;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import sae.graphe.GrapheListe;
import sae.parcours.ParcoursDijkstra;

public class Main {

	public static void main(String [] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, IOException {
		
				
		GrapheListe gListe = new GrapheListe();

		if(ChooseIHM.boxChooser("Voulez-vous utiliser le mode graphique ?") == 0) {
		
			
			File file = null;
			try {
				file = new File(ChooseIHM.dotFileChooser(null));
			}catch(Exception e) {
				System.out.println("Fichier inexistant");
				return;
			}
			
			gListe.creerGraphe(GrapheParse.parseAretes(file));
					
			ParcoursDijkstra pDijkstra = new ParcoursDijkstra(gListe);
			
			String ville1 = ChooseIHM.choisirVilleDepart(gListe.getSommets());
			String ville2 = ChooseIHM.choisirVilleArrivee(gListe.getSommets());
				
			if(pDijkstra.existeChemin(ville1, ville2)) {
				
				
				ChooseIHM.displayMessage("La distance entre " +ville1 + " et " + ville2 + " est de : " + pDijkstra.plusCourtChemin(ville1, ville2) +" Km.");
			
				if(ChooseIHM.boxChooser("Voulez-vous consulter le chemin ?") == 0)
					ChooseIHM.displayMessage(pDijkstra.getChemin(pDijkstra.getParents(), ville2));
			}
			else
				ChooseIHM.displayMessage("Aucun chemin n'existe entre " + ville1 + " et " + ville2);

			
			
		}
		else {
			File file = null;
			try {
				file = new File(args[0]);
			}catch(Exception e) {
				System.out.println("Fichier inexistant.");
				System.out.println("Si vous ne souhaitez pas utiliser le mode graphique, executez :\n" +
								   "java -jar <file.jar> </path/to/.dotFile> <villeDeDepart> <villeDArivee>");
				return;
			}
			
			gListe.creerGraphe(GrapheParse.parseAretes(file));
					
			System.out.println();
	
			ParcoursDijkstra pDijkstra = new ParcoursDijkstra(gListe);
	

			System.out.println("Distance entre " +
					args[1] + " et " +
					args[2] + " est de : "+
					pDijkstra.plusCourtChemin(args[1], args[2]) +" Km.");
			pDijkstra.existeChemin(args[1], args[2]);
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Souhaitez vous visualiser le chemin ? [o/n] : ");
			while(scan.hasNext()) {
				
			    String test = scan.next();
			    if(test.equals("o")) {
			    	System.out.println(pDijkstra.getChemin(pDijkstra.getParents(), args[2]));
			        break;
			    }
			    else if(test.equals("n"))
			    	break;
			    System.out.print("Répondez correctement [o/n] : ");
			}
			
			scan.close();
		}
	
	}

}
