package sae.graphe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import sae2_2.Arete;
import sae2_2.Graphe;
import sae2_2.Voisin;



public class GrapheMatrice implements Graphe{
	
	public HashMap<String, Integer> dictionnaireDeSommets;
	
	public ArrayList<ArrayList<Double>> matriceDAdjacence;
	
	public GrapheMatrice() {
		
		dictionnaireDeSommets = new HashMap<String, Integer>();
		matriceDAdjacence = new ArrayList<ArrayList <Double>>();
	}

	@Override
	public void ajouteArete(String sommet1, String sommet2, double poids) {
	
		if(dictionnaireDeSommets.containsKey(sommet1) == false) {
			System.out.println("Le sommet " + sommet1 + " n'existe pas.");
			System.out.println("Création du sommet automatiquement...");
			ajouteSommet(sommet1);
		}
		if(dictionnaireDeSommets.containsKey(sommet2) == false) {
			System.out.println("Le sommet " + sommet2 + " n'existe pas.");
			System.out.println("Création du sommet automatiquement...");
			ajouteSommet(sommet2);
		}
		
		else {
			ArrayList<Double> addArete = matriceDAdjacence.get(dictionnaireDeSommets.get(sommet1));
			addArete.set(dictionnaireDeSommets.get(sommet2), poids);
			
			addArete = matriceDAdjacence.get(dictionnaireDeSommets.get(sommet2));
			addArete.set(dictionnaireDeSommets.get(sommet1), poids);
			
			System.out.println("L'arête entre les sommets " + sommet1 + " et " + sommet2 + " de poids " + poids + " à bien été créée.");
		}
	}

	@Override
	public void ajouteSommet(String etiquette) {
		
		if(dictionnaireDeSommets.containsKey(etiquette)) {
			
			//System.out.println("Le sommet " + etiquette + " existe déjà.");
		}
		
		else {
			
			dictionnaireDeSommets.put(etiquette, dictionnaireDeSommets.size());
			ArrayList<Double> slotArete = new ArrayList<Double>();
			
			matriceDAdjacence.add(slotArete);
			
			for (Map.Entry<String, Integer> mapentry : dictionnaireDeSommets.entrySet()) {
				
				ArrayList<Double> update = matriceDAdjacence.get(mapentry.getValue());
				
				for(int i = update.size(); i < dictionnaireDeSommets.size(); i++) {
					
					update.add(null);
				}
		    }	
			System.out.println("le sommet '" + etiquette + "' a bien été crée");
		}
	}

	@Override
	public void creerGraphe(Collection<Arete> aretes) {
		
		System.out.println("Création du Graphe...");

		for(Arete arete : aretes) {
	        ajouteSommet(arete.getU());
			ajouteSommet(arete.getV());
		}
		
		for(Arete arete : aretes)
	        ajouteArete(arete.getU(), arete.getV(), arete.getPoids());
		
		System.out.println();
		
		displayMatrice();
		
	}

	@Override
	public Collection<Arete> getAretes() {

		ArrayList<Arete> aretes = new ArrayList<Arete>();
		for (Map.Entry<String, Integer> mapentry : dictionnaireDeSommets.entrySet()) {
			
			ArrayList<Double> checker = matriceDAdjacence.get(mapentry.getValue());
			for(int i = 0; i < matriceDAdjacence.size(); i++) {
				
				if(checker.get(i) != null) {
					
					for (Map.Entry<String, Integer> getter : dictionnaireDeSommets.entrySet()) {
						if(getter.getValue().equals(i)) {
							Arete arete = new Arete(mapentry.getKey(),
								  					getter.getKey(),
								  					checker.get(i));
							aretes.add(arete);
						}
					}
					
				}
			}
			
	    }
		return aretes;
	}

	@Override
	public Collection<String> getSommets() {

		ArrayList<String> sommets = new ArrayList<String>();
		for (Map.Entry<String, Integer> mapentry : dictionnaireDeSommets.entrySet()) {
			
			sommets.add(mapentry.getKey());
	    }
		return sommets;

	}

	@Override
	public Collection<Voisin> getVoisins(String sommet) {
		
		ArrayList<Voisin> voisins = new ArrayList<Voisin>();
		
		ArrayList<Double> checker = matriceDAdjacence.get(dictionnaireDeSommets.get(sommet));
		for(int i = 0; i < matriceDAdjacence.size(); i++) {
			
			if(checker.get(i) != null) {
				
				for (Map.Entry<String, Integer> getter : dictionnaireDeSommets.entrySet()) {
					if(getter.getValue().equals(i)) {
						Voisin voisin = new Voisin(getter.getKey(), i);
						voisins.add(voisin);
					}
				}
				
			}
		}	
		return voisins;
	}

	@Override
	public boolean sontVoisins(String sommet1, String sommet2) {
		
		Boolean result = false;
		ArrayList<Double> checker = matriceDAdjacence.get(dictionnaireDeSommets.get(sommet1));

		if(checker.get(dictionnaireDeSommets.get(sommet2)) != null) {
				
			result = true;
				
		}

		return result;
	}
	

	public void displayMatrice() {
     
		for (Map.Entry<String, Integer> mapentry : dictionnaireDeSommets.entrySet()) {
			
			System.out.print(mapentry.getKey() + " --> ");
			System.out.println(matriceDAdjacence.get(mapentry.getValue()));
	    }	
	    
	}

}
