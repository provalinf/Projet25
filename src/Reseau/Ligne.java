package Reseau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import Reseau.Plan;

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

	public static ArrayList<String> ligneUtilisees(Plan plan, ArrayList<String> stations) {
		ArrayList<String> lignes = new ArrayList<>();
		ArrayList<ArrayList<String>> lignesPossibles = new ArrayList<ArrayList<String>>();
		// Récupération des lignes possibles pour une station
		for(String s: stations){
			lignesPossibles.add(correspondanceLigne(plan, s));
		}
		/*int ind = 0;
		for(ArrayList<String> stationTemp: lignesPossibles){
			for(String ligneTemp: stationTemp){
				//Premiere station
				if(ind == 0){

				}
			}
		}*/
		//Optimisation des lignes utilisees pour réduire le nombre de changement de ligne
		//Choix aleatoire de la ligne a modifier !!!
		for(ArrayList<String> stationTemp: lignesPossibles){
			lignes.add(stationTemp.get(0));
		}
		return lignes;
	}

	private static ArrayList<String> correspondanceLigne(Plan plan, String s) {
		ArrayList<String> lignes = new ArrayList<>();
		for(Ligne l: plan.getReseau()){
			for(Station station: l.stations){
				System.out.println(station.getNomStation());
				if(station.getNomStation().equals(s)) {
					System.out.println("ajout : "+l.nomLigne);
					lignes.add(l.nomLigne);
				}
			}
		}
		return lignes;
	}

	public void addStation(Station station) {
		stations.add(station);
	}
}
