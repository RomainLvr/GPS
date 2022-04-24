package sae.parcours;

import sae2_2.Graphe;

public abstract class ParcoursGraphe{
	
	protected Graphe graphe;

	public ParcoursGraphe(Graphe graphe) {
		
		this.graphe = graphe;
	}
	
	public abstract boolean existeChemin(String sommet1, String sommet2);
	
	public abstract Double plusCourtChemin(String sommet1, String sommet2);
	
	public Graphe getGraphe() {
		
		return graphe;
	}
}
