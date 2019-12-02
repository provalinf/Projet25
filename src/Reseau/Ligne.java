package Reseau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ligne {
	private String nomLigne;
	private int intervalPassage;
	private double horaireOn;
	private double horaireOff;
	private ArrayList<Trajet> trajets;

	public Ligne(String nomLigne) {
		this.nomLigne = nomLigne;
		this.trajets = new ArrayList<>();
	}

	public Ligne(String nomLigne, Trajet... trajets) {
		this(nomLigne);
		Collections.addAll(this.trajets, trajets);
	}

	public void addTrajet(Trajet trajet) {
		trajets.add(trajet);
	}
}
