package sae;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import sae.graphe.GrapheListe;
import sae.parcours.ParcoursDijkstra;

public class Main {

	public static void main(String [] args) throws IOException{
				
		if(args.length == 0) {
		
			File file = null;
			try {
				file = new File(ChooseIHM.dotFileChooser(null));
			}catch(Exception e) {
				System.out.println("Fichier inexistant ou erroné.");
				return;
			}
			
			GrapheListe gListe = new GrapheListe();
			
			gListe.creerGraphe(GrapheParse.parseAretes(file));
					
			ParcoursDijkstra pDijkstra = new ParcoursDijkstra(gListe);
			
			String ville1 = ChooseIHM.choisirVilleDepart(gListe.getSommets());
			String ville2 = ChooseIHM.choisirVilleArrivee(gListe.getSommets());
				
			if(pDijkstra.existeChemin(ville1, ville2)) {
				
				ChooseIHM.displayMessage("La distance entre " +ville1 + " et " + ville2 + " est de : " + pDijkstra.plusCourtChemin(ville1, ville2) +" Km.");

				if(ChooseIHM.boxChooser("Voulez-vous consulter le chemin ?") == 0)
					ChooseIHM.displayMessage("Chemin : " + pDijkstra.getChemin(pDijkstra.getParents(), ville2));
			}
			else
				ChooseIHM.displayMessage("Aucun chemin n'existe entre " + ville1 + " et " + ville2);		
		}
		else if (args[1].length() != 0 && args[2].length() != 0){
			File file = null;
			try {
				file = new File(args[0]);
				
			}catch(Exception e) {
				
			}
			
			GrapheListe gListe = new GrapheListe();
			
			gListe.creerGraphe(GrapheParse.parseAretes(file));
			
			if(gListe.getSommets().contains(args[1]) && gListe.getSommets().contains(args[2])) {
				
			}
			else {
				System.out.println("Une ou plusieurs des deux villes que vous avez choisies n'existe(nt) pas, verifiez l'orthographe.");
				return;
			}		
	
			ParcoursDijkstra pDijkstra = new ParcoursDijkstra(gListe);
			
			if(pDijkstra.existeChemin(args[1], args[2])) {
				
			}
			else {
				System.out.println("Aucun chemin n'existe entre " + args[1] + " et " + args[2] + ".");
			}

			System.out.println("Distance entre " +
					args[1] + " et " +
					args[2] + " est de : "+
					pDijkstra.plusCourtChemin(args[1], args[2]) +" Km.");
			
			
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Souhaitez vous visualiser le chemin ? [o/n] : ");
			while(scan.hasNext()) {
				
			    String test = scan.next();
			    if(test.equals("o")) {
			    	System.out.println("Chemin : " + pDijkstra.getChemin(pDijkstra.getParents(), args[2]));
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
