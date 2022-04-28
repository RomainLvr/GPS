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
	
	Comparator<Arete> areteComparator = new Comparator<Arete>() {
	
		@Override
		public int compare(Arete arg0, Arete arg1) {
	
			return Double.compare(arg0.getPoids(), arg1.getPoids());
		}
	};
    
	Map<String, String> parents = new HashMap<String, String>();
	Set<String> visited = new HashSet<String>();
	PriorityQueue<Arete> temp = new PriorityQueue<Arete>(areteComparator);
	
	
	public ParcoursDijkstra(Graphe graphe) {
		super(graphe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existeChemin(String sommet1, String sommet2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double plusCourtChemin(String sommet1, String sommet2) {
		
		Double poids = null;
	    Arete start = new Arete(sommet1, null, 0);
	    temp.add(start);

	    while (temp.size() > 0) {
	    	Arete currentPathNode = temp.remove();
	    	System.out.println("currentPathNode : " + currentPathNode);
	      if (!visited.contains(currentPathNode.getU())) {
	        Collection<Voisin> currentNode = graphe.getVoisins(currentPathNode.getU());
	        parents.put(currentPathNode.getU(), currentPathNode.getV());
	        visited.add(currentPathNode.getU());

//	        return the shortest path if end node is reached
	        if (currentPathNode.getU().equals(sommet2)) {
	        	System.out.println("Chemin : " + getPath(parents, sommet2));
	  	      	//System.out.println("Poids : " + currentNode.getPoids());
	        	//poids = currentNode.getPoids();
	  	      	break;
	        }

	        Collection<Voisin> neighbors = graphe.getVoisins(currentPathNode.getU());
	        for (Voisin voisin : neighbors) {
	        	Voisin neighbor = voisin;

// à continuer	          Double distance2root = currentPathNode.getPoids() + currentNode.iterator().next().getPoids();
	          System.out.println(distance2root);
	          // PriorityQueue ensure that the node with shortest distance to the root is put at the
	          // head of the queue
	          temp.add(new Arete(neighbor.getEtiquette(), currentPathNode.getU(), distance2root));
	        }

	        //System.out.println("current node: " + currentPathNode.getU());
	        System.out.println("PriorityQueue: " + temp);
	        System.out.println("Parents: " + parents);
	        System.out.println("Visited: " + visited);
	        System.out.println("");
	      }
	      
	    }
	    //System.out.println("Distance entre " + sommet1 + " et " + sommet2 + " : " + temp.stream().map(Arete::getPoids).mapToDouble(Double::doubleValue).sum());
	    //System.out.println(currentNode.getPoids());
	    //return temp.stream().map(Arete::getPoids).mapToDouble(Double::doubleValue).sum();
	    System.out.println(poids);
	    return poids;
	}
	
	
	 private List<String> getPath(Map<String, String> parents, String sommet2) {
		    List<String> chemin = new ArrayList<String>();
		    String sommet = sommet2;
		    while (sommet != null) {
		    	chemin.add(0, sommet);
		      String parent = parents.get(sommet);
		      sommet = parent;
		    }
		    return chemin;
		  }

}
