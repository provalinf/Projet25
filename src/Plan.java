import Reseau.Ligne;

import java.util.ArrayList;

public class Plan {
	private String nom;
	private ArrayList<Ligne> reseau;
	private int nbRemorqueDisponible;
	private int nbRemorqueUtilise;

	public Plan(String nom) {
		this.nom = nom;
		reseau = new ArrayList<>();
	}

	public ArrayList<Ligne> getReseau() {
		return reseau;
	}

	public void addLigne(Ligne ligne) {
		reseau.add(ligne);
	}

	public int getNbRemorqueDisponible() {
		return nbRemorqueDisponible;
	}

	public void setNbRemorqueDisponible(int nbRemorqueDisponible) {
		this.nbRemorqueDisponible = nbRemorqueDisponible;
	}

	public int getNbRemorqueUtilise() {
		return nbRemorqueUtilise;
	}

	public void setNbRemorqueUtilise(int nbRemorqueUtilise) {
		this.nbRemorqueUtilise = nbRemorqueUtilise;
	}
}
