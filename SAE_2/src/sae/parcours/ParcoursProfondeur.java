package sae.parcours;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import sae2_2.Graphe;
import sae2_2.Voisin;

public class ParcoursProfondeur extends ParcoursGraphe{

	public ParcoursProfondeur(Graphe graphe) {
		
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
		List<Voisin> unchecked = new LinkedList<>();
		
			unchecked.add(new Voisin(sommet1, 0));
		
		while(unchecked.isEmpty() == false) {
			
			Voisin voisin = unchecked.remove(0);
			
			List<Voisin> newCheck = this.graphe.getVoisins(voisin.getEtiquette()).stream()
									.filter(v -> checked.stream().noneMatch(v2 -> v.getEtiquette().equals(v2.getEtiquette())))
									.collect(Collectors.toList());
			checked.add(voisin);
			unchecked.addAll(0, newCheck);
			
			System.out.println(checked.stream().map(Voisin::getEtiquette).anyMatch(s -> s.equals(sommet2)));
			if(checked.stream().map(Voisin::getEtiquette).anyMatch(s -> s.equals(sommet2))) {
				System.out.println(checked.size());
				System.out.println("Taille : " + checked.stream().map(Voisin::getPoids).mapToDouble(Double::doubleValue).sum());
				return checked.stream().map(Voisin::getPoids).mapToDouble(Double::doubleValue).sum();
			}
		}
		
		return -1.0;
	}

}
