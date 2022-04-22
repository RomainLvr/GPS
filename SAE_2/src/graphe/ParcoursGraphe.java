package graphe;

import sae2_2.Graphe;

public abstract class ParcoursGraphe implements Graphe{

	public ParcoursGraphe(Graphe arg0) {
		
	}
	
	public abstract boolean existeChemin(String arg0, String arg1);
	
	public abstract Double plusCourtChemin(String arg0, String arg1);
	
	public Graphe getGraphe() {
		
		return null;
	}
}
