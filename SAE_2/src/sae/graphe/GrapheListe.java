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
			//Le sommet1 n'existe pas
			//Création du sommet automatiquement
			ajouteSommet(sommet1);
		}
		if(listeDAdjacence.containsKey(sommet2) == false) {
			//Le sommet2 n'existe pas
			//Création du sommet automatiquement
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

	}

	@Override
	public void ajouteSommet(String etiquette) {

		if(listeDAdjacence.containsKey(etiquette)) {
			//Le sommet existe déjà.
		}
		
		else {
			
			listeDAdjacence.put(etiquette, new ArrayList<Arete>());	
		}
	}
	
	@Override
	public void creerGraphe(Collection<Arete> aretes) {
				
		for(Arete arete : aretes) {
	        ajouteSommet(arete.getU());
			ajouteSommet(arete.getV());
		}
		
		for(Arete arete : aretes)
	        ajouteArete(arete.getU(), arete.getV(), arete.getPoids());	
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
		
		for (Entry<String, Collection<Arete>> mapentry : listeDAdjacence.entrySet()) {
			
			System.out.print(mapentry.getKey() + " --> ");
			System.out.println(mapentry.getValue());
	    }
	}

}
