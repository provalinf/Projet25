package Marchandise;

import Reseau.Station;

public abstract class Marchandise {

	private String nomMarchandise;
	private double poids;
	private Station destination;

	public Marchandise(String nomMarchandise) {
		this.nomMarchandise = nomMarchandise;
	}

	public String getNomMarchandise() {
		return nomMarchandise;
	}
}
