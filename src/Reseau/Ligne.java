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
		boolean out = false;
		for(ArrayList<String> stationTemp: lignesPossibles) {
			ArrayList<String> stationTempBis;
			if (lignesPossibles.indexOf(stationTemp) <= (lignesPossibles.size()-2)) {
				stationTempBis = lignesPossibles.get(lignesPossibles.indexOf(stationTemp)+1);
				System.out.println("Pre");
				for (String l1 : stationTemp) {
					System.out.println(l1);
				}
				System.out.println("");
				for (String l1 : stationTempBis) {
					System.out.println(l1);
				}
				System.out.println("Post");

				for (String l1 : stationTemp) {
					out = false;
					for (String l2 : stationTempBis) {
						if (l1.equals(l2)) {
							lignes.add(l1);
							out = true;
							break;
						}
					}
					if (out) {
						break;
					}
				}
			}
		}
		return lignes;
	}

	private static ArrayList<String> correspondanceLigne(Plan plan, String s) {
		ArrayList<String> lignes = new ArrayList<>();
		for(Ligne l: plan.getReseau()){
			for(Station station: l.stations){
				if(station.getNomStation().equals(s)) {
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
