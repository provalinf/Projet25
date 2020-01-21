package Reseau;

import java.lang.reflect.Array;
import java.util.*;

import Reseau.Plan;

public class Ligne {
	public String getNomLigne() {
		return nomLigne;
	}

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

	//Renvoie la liste des lignes utilisees pour parcourir l'ensemble des stations
	public static ArrayList<Ligne> ligneUtilisees(Plan plan, ArrayList<Station> stationsResultat) {
		/* stationsResultat : ensemble des stations du chemin Dijkstra
		   lignesResultats : ensemble des lignes du chemin Dijkstra
		   plan : plan de recherche du chemin
		   stations : ensemble des stations existantes dans le plan
		   lignes : ensemble des lignes existantes dans le plan
		*/
		ArrayList<Ligne> lignes = plan.getLignes();
		ArrayList<Ligne> lignesPossibles = new ArrayList<>();
		ArrayList<Ligne> lignesResultats = new ArrayList<>();
		int nbLignes = plan.getLignes().size();
		int nbStations = stationsResultat.size();

		Boolean[][] lignesContinues = new Boolean[nbLignes][nbStations];
		for(int i=0; i<nbLignes; i++){
			for(int j =0; j < nbStations; j++){
				lignesContinues[i][j] = false;
			}
		}

		// Récupération des lignes possibles pour une station
		for(Station s: stationsResultat){
			if(stationsResultat.indexOf(s) < stationsResultat.size()-1){
				lignesPossibles = correspondanceLigne(plan, s, stationsResultat.get(stationsResultat.indexOf(s)+1));
				for (Ligne l: lignesPossibles) {
					lignesContinues[lignes.indexOf(l)][stationsResultat.indexOf(s)] = true;
				}
			}

		}

		//Calcul du meilleur chemin pour réduire les changements de ligne inutiles
		ArrayList<Integer> calculTemp = new ArrayList<>();
		int max = 0;
		int compt;
		int comptTrue = 0;
		int indice = 0;
		int m = 0;
		do {
			compt = 0;
			for (Boolean[] l : lignesContinues) {
				for (m = indice; m < l.length; m++) {
					if (l[m]) {
						comptTrue++;
					}
					if(!l[m] || m == (l.length-1)){
						calculTemp.add(compt, comptTrue);
						comptTrue = 0;
						break;
					}
				}
				compt++;
			}
			max = Collections.max(calculTemp);
			for (int g = 0; g < max; g++) {
				lignesResultats.add(lignes.get(calculTemp.indexOf(max)));
			}
			indice += max;
			calculTemp.clear();
		}while(indice < nbStations-1);

		return lignesResultats;
	}

	//Gestion par couple de station et verification que les deux stations sont bien consécutives sur la ligne
	private static ArrayList<Ligne> correspondanceLigne(Plan plan, Station s1, Station s2) {
		ArrayList<Ligne> lignes = new ArrayList<>();
		for(Ligne l: plan.getLignes()){
			if(l.stations.contains(s1) && l.stations.contains(s2)) {
				if(l.stations.indexOf(s1) == (l.stations.indexOf(s2)+1) || l.stations.indexOf(s1) == (l.stations.indexOf(s2)-1)){
					lignes.add(l);
				}
			}
		}
		return lignes;
	}

	public void addStation(Station station) {
		stations.add(station);
	}
}