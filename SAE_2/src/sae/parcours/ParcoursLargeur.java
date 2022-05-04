package sae.parcours;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import sae2_2.Graphe;
import sae2_2.Voisin;

public class ParcoursLargeur extends ParcoursGraphe{

	public ParcoursLargeur(Graphe graphe) {
		
		super(graphe);
	}

	@Override
	public boolean existeChemin(String sommet1, String sommet2) {

		Boolean state = false;
		if(plusCourtChemin(sommet1, sommet2) >= 0) {
			
			state  = true;
			System.out.println("Un chemin existe entre " + sommet1 + " et " + sommet2);
		}
		else {
			
			System.out.println("Aucun chemin n'existe entre " + sommet1 + " et " + sommet2);
		}

		
		return state;
		
	}

	@Override
	public Double plusCourtChemin(String sommet1, String sommet2) {
		

		ArrayDeque<Voisin> file = new ArrayDeque<Voisin>();
	    ArrayDeque<Voisin> temp = new ArrayDeque<Voisin>();
	    Set<String> visited = new HashSet<String>();

	    
	    temp.add(new Voisin(sommet1, 0));
	    visited.add(sommet1);

	    while (temp.size() > 0) {
	    	Voisin currentVoisin = temp.pollFirst();
	    	
	    	Collection<Voisin> voisins = graphe.getVoisins(currentVoisin.getEtiquette());

	    	for (Voisin voisin : voisins) {
	    		Voisin newVoisin = voisin;

		// a node can only be visited once if it has more than one parents 
	    		if (visited.contains(newVoisin.getEtiquette())) {
	    			continue;
	    		} else {
	    			temp.add(newVoisin);
	    			visited.add(newVoisin.getEtiquette());
	    			
	    		}
	    	}
	    	
	    	
	    	
	    	temp.removeFirst();
	    	file.add(currentVoisin);
	    	
	    	if(file.stream().map(Voisin::getEtiquette).anyMatch(s -> s.equals(sommet2))) {
	    		break;
	    	}
	    }
	    return file.stream().map(Voisin::getPoids).mapToDouble(Double::doubleValue).sum();
	}

}
