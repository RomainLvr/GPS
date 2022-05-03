package sae.parcours;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import sae2_2.Arete;
import sae2_2.Graphe;
import sae2_2.Voisin;

public class ParcoursDijkstra extends ParcoursGraphe{
	
	Comparator<Arete> aretesComparator = new Comparator<Arete>() {
	
		@Override
		public int compare(Arete arg0, Arete arg1) {
	
			return Double.compare(arg0.getPoids(), arg1.getPoids());
		}
	};
    
	Map<String, String> parents = new HashMap<String, String>();
	Set<String> checked = new HashSet<String>();
	PriorityQueue<Arete> temp = new PriorityQueue<Arete>(aretesComparator);
	
	
	public ParcoursDijkstra(Graphe graphe) {
		
		super(graphe);
	}

	@Override
	public boolean existeChemin(String sommet1, String sommet2) {
		
		Boolean temoin = false;
		if(plusCourtChemin(sommet1, sommet2) == null)
			temoin = true;
		return temoin;
	}

	@Override
	public Double plusCourtChemin(String sommet1, String sommet2) {
		
		Double poids = null;
	    Arete startArete = new Arete(sommet1, null, 0);
	    temp.add(startArete);

	    while (temp.size() > 0) {
	    	
	    	Arete noeudActuel = temp.remove();

	    	if (!checked.contains(noeudActuel.getU())) {
		        //String currentNode = currentPathNode.getV();
		        parents.put(noeudActuel.getU(), noeudActuel.getV());
		        checked.add(noeudActuel.getU());
	
		        //	Si le sommet2 est atteint, retourner le poids (et le chemin)
		        if (noeudActuel.getU().equals(sommet2)) {
		        	
		        	poids = noeudActuel.getPoids() / 10;
		  	      	break;
		        }
	
		        Collection<Voisin> voisins = graphe.getVoisins(noeudActuel.getU());
		        for (Voisin voisinElement : voisins) {
		        	Voisin voisin = voisinElement;
	
		        	Double poidsEntreSommets = noeudActuel.getPoids() + voisin.getPoids();
		          // temp fait en sorte que le noeud avec la plus courte distance soit mise
		          // en tête de liste
		        	temp.add(new Arete(voisin.getEtiquette(), noeudActuel.getU(), poidsEntreSommets));
		        }
	
	//	        System.out.println("PriorityQueue: " + temp);
	//	        System.out.println("Parents: " + parents);
	//	        System.out.println("Visited: " + checked);
	//	        System.out.println("");
	      }
	      
	    }
	    
	    //System.out.println(currentNode.getPoids());
	    //return temp.stream().map(Arete::getPoids).mapToDouble(Double::doubleValue).sum();
	    return poids;
	}
	
	public Map<String, String> getParents(){
		
		return parents;	
	}
	
	 public String getChemin(Map<String, String> parents, String sommet2) {
		  System.out.print("Chemin : ");
		  String test = null;
			List<String> chemin = new ArrayList<String>();
			String sommet = sommet2;
			while (sommet != null) {
				chemin.add(0, sommet);
				//System.out.print(sommet + " -> ");
				String parent = parents.get(sommet);
				sommet = parent;
			}
			for(String element : chemin) {
			    	
				if(element == sommet2) System.out.println(element);
				else System.out.print(element + " -> ");
				test = element.toString();	
			}
			return test;
	 }

}
