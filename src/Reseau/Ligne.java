package Reseau;

import java.util.ArrayList;

public class Ligne {
	private String nomLigne;
	private ArrayList<Ligne> ligne;
	private int intervalPassage;
	private double horaireOn;
	private double horaireOff;
	private ArrayList<Trajet> trajets;

	public Ligne(String nomLigne) {
		this.nomLigne = nomLigne;
		this.ligne = new ArrayList<>();
		this.trajets = new ArrayList<>();
	}

	public void addTrajet(Trajet trajet) {
		trajets.add(trajet);
	}
}
