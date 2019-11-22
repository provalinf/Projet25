package Reseau;


import Marchandise.Marchandise;
import Marchandise.SacCourrier;
import Marchandise.ConteneurVerre;

import java.util.ArrayList;
import java.util.HashMap;

public class Station {
	private String nomStation;
	private HashMap<Marchandise, Integer> stockageMax;
	private ArrayList<Marchandise> stockage;

	public Station(String nomStation, HashMap<Marchandise, Integer> stockageMax, ArrayList<Marchandise> stockage) {
		this.nomStation = nomStation;
		this.stockageMax = stockageMax;
		this.stockage = stockage;
	}

	public Station(String nomStation) {
		this(nomStation, new HashMap<Marchandise, Integer>(), new ArrayList<Marchandise>());
		initExemple();
	}

	private void initExemple() {
		stockageMax.put(new SacCourrier(), 20);
		stockageMax.put(new ConteneurVerre(), 2);
	}
}
