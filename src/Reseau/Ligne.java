package Reseau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ligne {
	private String nomLigne;
	private int intervalPassage;
	private double horaireOn;
	private double horaireOff;
	private ArrayList<Station> stations;

	public Ligne(String nomLigne) {
		this.nomLigne = nomLigne;
		this.stations = new ArrayList<>();
	}

	public Ligne(String nomLigne, Station... stations) {
		this(nomLigne);
		Collections.addAll(this.stations, stations);
	}

	public void addStation(Station station) {
		stations.add(station);
	}
}
