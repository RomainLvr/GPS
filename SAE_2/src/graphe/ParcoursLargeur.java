package graphe;

import java.util.Collection;

import sae2_2.Arete;
import sae2_2.Graphe;
import sae2_2.Voisin;

public class ParcoursLargeur extends ParcoursGraphe{

	public ParcoursLargeur(Graphe arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existeChemin(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double plusCourtChemin(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouteArete(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouteSommet(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerGraphe(Collection<Arete> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Arete> getAretes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getSommets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Voisin> getVoisins(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sontVoisins(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
