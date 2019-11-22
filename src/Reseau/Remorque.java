package Reseau;

import Marchandise.Marchandise;

import java.util.ArrayList;
import java.util.Map;

public class Remorque {
	private int idRemorque;
	private Map<Marchandise, Integer> capacite;
	private ArrayList<Marchandise> enTransport;

	public Remorque(int idRemorque, Map<Marchandise, Integer> capacite, ArrayList<Marchandise> enTransport) {
		this.idRemorque = idRemorque;
		this.capacite = capacite;
		this.enTransport = enTransport;
	}


	@Override
	public String toString() {
		return "Remorque{" +
				"idRemorque=" + idRemorque +
				", capacite=" + capacite +
				", enTransport=" + enTransport +
				'}';
	}
}
