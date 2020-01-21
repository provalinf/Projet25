package Reseau;

import Reseau.Ligne;
import Reseau.Station;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Plan {
	private String nom;
	private ArrayList<Ligne> lignes;
	private int nbRemorqueDisponible;
	private int nbRemorqueUtilise;
	private ArrayList<Station> stations;

	public Plan(String nom) {
		this.nom = nom;
		lignes = new ArrayList<>();
		stations = new ArrayList<>();
	}

	public ArrayList<Ligne> getLignes() {
		return lignes;
	}

	public void addLigne(Ligne ligne) {
		lignes.add(ligne);
	}

	public void addStation(Station station) {
		stations.add(station);
	}

	public Station getStation(final String nomStation) {
		return stations.stream().filter(s1 -> s1.getNomStation().equals(nomStation)).findFirst().get();
	}

	public ArrayList<Station> getStations() {
		return stations;
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
