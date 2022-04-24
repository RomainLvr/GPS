package sae.graphe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import sae2_2.Arete;
import sae2_2.Graphe;
import sae2_2.Voisin;

public class GrapheListe implements Graphe{
	
	
	public HashMap<String, Collection<Arete>> listeDAdjacence;
	
	public GrapheListe() {
		
		listeDAdjacence = new HashMap<String, Collection<Arete>>();
	}

	@Override
	public void ajouteArete(String sommet1, String sommet2, double poids) {
		
		Arete edge1 = new Arete(sommet1, sommet2, poids);
		Arete edge2 = new Arete(sommet2, sommet1, poids);
		
		if(listeDAdjacence.containsKey(sommet1) == false) {
			System.out.println("Le sommet " + sommet1 + " n'existe pas.");
			System.out.println("Création du sommet automatiquement...");
			ajouteSommet(sommet1);
		}
		if(listeDAdjacence.containsKey(sommet2) == false) {
			System.out.println("Le sommet " + sommet2 + " n'existe pas.");
			System.out.println("Création du sommet automatiquement...");
			ajouteSommet(sommet2);
		}
			
			Collection<Arete> arete1 = listeDAdjacence.get(sommet1);
	        
				if(arete1==null) {
		            arete1 = new ArrayList<Arete>();                       
		            listeDAdjacence.put(sommet1, arete1);
		        }
		        arete1.add(edge1);
	        
	        Collection<Arete> arete2 = listeDAdjacence.get(sommet2);
	        
		        if(arete2==null) {
		            arete2 = new ArrayList<Arete>();                       
		            listeDAdjacence.put(sommet2, arete2);
		        }
		        arete2.add(edge2);
	        
	        if(listeDAdjacence.get(sommet1).contains(edge1) == true && listeDAdjacence.get(sommet2).contains(edge2) == true) {
	        	
	        	System.out.println("Les aretes " + edge1 + 
	        					   " et " + edge2 + " ont bien été crées.");
	        }
	}

	@Override
	public void ajouteSommet(String etiquette) {

		if(listeDAdjacence.containsKey(etiquette)) {
			//System.out.println("Le sommet " + etiquette + " existe déjà.");
		}
		
		else {
			listeDAdjacence.put(etiquette, new ArrayList<Arete>());
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
		
		//displayList();
		
	}

	@Override
	public Collection<Arete> getAretes() {
		
		ArrayList<Arete> values = new ArrayList<>();
		listeDAdjacence.forEach( (Key,Arete) -> {
			values.addAll(Arete);
        });
		return values;
	}
	@Override
	public Collection<String> getSommets() {

		ArrayList<String> keys = new ArrayList<>();
		listeDAdjacence.forEach( (Key,Arete) -> {
			keys.add(Key);
        });
		return keys;
	}

	@Override
	public Collection<Voisin> getVoisins(String sommet) {

		ArrayList<Voisin> voisins = new ArrayList<Voisin>();
		Collection<Arete> checker = (listeDAdjacence.get(sommet));
		for (Arete element : checker) {
			
		    Voisin voisin = new Voisin(element.getV(), element.getPoids());
		    voisins.add(voisin);
		}
		return voisins;
	}

	@Override
	public boolean sontVoisins(String sommet1, String sommet2) {

		Boolean result = false;
		Collection<Arete> checker = (listeDAdjacence.get(sommet1));
		for (Arete element : checker) {
			
		    if(element.getV() == sommet2) {
		    	
		    	result = true;
		    }
		}
		return result;
	}
	
	public void displayList() {

		//System.out.println(Collections.singletonList(listeDAdjacence));
		
		for (Entry<String, Collection<Arete>> mapentry : listeDAdjacence.entrySet()) {
			
			System.out.print(mapentry.getKey() + " --> ");
			System.out.println(mapentry.getValue());
	    }
	}

}
