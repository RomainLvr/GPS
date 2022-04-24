package sae.parcours;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		List<Voisin> checked = new LinkedList<>();
		List<Voisin> unchecked = Arrays.asList(new Voisin(sommet1, 0));
		
		while(unchecked.isEmpty() == false) {
			List<Voisin> newCheck = unchecked.stream().map(Voisin::getEtiquette).map(this.graphe::getVoisins)
									.flatMap(Collection::stream)
									.filter(voisin -> checked.stream().noneMatch(v -> v.getEtiquette().equals(voisin.getEtiquette())))
									.collect(Collectors.toList());
			checked.addAll(unchecked);
			unchecked = newCheck;
			
			if(checked.stream().map(Voisin::getEtiquette).anyMatch(s -> s.equals(sommet2))) {
				
				return checked.stream().map(Voisin::getPoids).mapToDouble(Double::doubleValue).sum();
			}
		}
		
		return -1.0;
	}

}
