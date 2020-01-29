package Lancement;

import Algorithme.AlgorithmeDijkstra;
import Reseau.Ligne;
import Reseau.Station;
import Reseau.Plan;

import java.util.Scanner;

public class Exemple {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creation des stations */
		Station poleTemis = new Station("Pole Temis");
		Station uSport = new Station("U-Sport");
		Station campusArago = new Station("Campus Arago");
		Station crous = new Station("Crous");
		Station papin = new Station("Papin");
		Station beauxArts = new Station("Beaux Arts");
		Station securiteSociale = new Station("Securite Sociale");
		Station lavoisier = new Station("Lavoisier");
		Station gibelotte = new Station("Gibelotte");
		Station voirin = new Station("Voirin");
		Station siffert = new Station("Siffert");
		Station leclerc = new Station("Leclerc");
		Station gareViotte = new Station("Gare Viotte");
		Station notreDame = new Station("Notre Dame");
		Station poleSportif = new Station("Pole Sportif");

		/* Ajout des voisins et de leur distance */
		poleTemis.addStationDest(uSport,3);
		poleTemis.addStationDest(poleSportif,2);
		uSport.addStationDest(campusArago,2);
		uSport.addStationDest(poleTemis,3);
		campusArago.addStationDest(uSport,2);
		campusArago.addStationDest(crous,1);
		crous.addStationDest(campusArago,1);
		crous.addStationDest(papin,5);
		crous.addStationDest(gibelotte,10);
		papin.addStationDest(crous,5);
		papin.addStationDest(beauxArts,1);
		beauxArts.addStationDest(papin,1);
		beauxArts.addStationDest(securiteSociale,1);
		securiteSociale.addStationDest(beauxArts,1);
		securiteSociale.addStationDest(lavoisier,8);
		securiteSociale.addStationDest(notreDame,7);
		lavoisier.addStationDest(securiteSociale,8);
		lavoisier.addStationDest(gibelotte,28);
		gibelotte.addStationDest(lavoisier,28);
		gibelotte.addStationDest(crous,10);
		gibelotte.addStationDest(voirin,1);
		voirin.addStationDest(gibelotte,1);
		voirin.addStationDest(siffert,1);
		voirin.addStationDest(gareViotte,5);
		siffert.addStationDest(voirin,1);
		siffert.addStationDest(leclerc,1);
		gareViotte.addStationDest(voirin,5);
		leclerc.addStationDest(siffert,1);
		leclerc.addStationDest(poleSportif,6);
		leclerc.addStationDest(notreDame,6);
		notreDame.addStationDest(leclerc,6);
		notreDame.addStationDest(securiteSociale,7);
		notreDame.addStationDest(poleSportif,1);
		poleSportif.addStationDest(notreDame,1);
		poleSportif.addStationDest(poleTemis,2);
		poleSportif.addStationDest(leclerc,6);

		/* Creation des lignes */
		Ligne l3 = new Ligne("L3", poleTemis, uSport, campusArago, crous, gibelotte, voirin, gareViotte);
		Ligne l6 = new Ligne("L6", poleTemis, poleSportif, leclerc);
		Ligne l7 = new Ligne("L7", notreDame, poleSportif, poleTemis, uSport, campusArago, crous, papin, beauxArts, securiteSociale, lavoisier);
		Ligne l9 = new Ligne("L9", siffert, leclerc, notreDame, securiteSociale, beauxArts, papin);
		Ligne l10 = new Ligne("L10", lavoisier, gibelotte, voirin, siffert);

		/* Creation du plan */
		Plan besancon = new Plan("Besançon");
		besancon.addStation(poleTemis);
		besancon.addStation(uSport);
		besancon.addStation(campusArago);
		besancon.addStation(crous);
		besancon.addStation(papin);
		besancon.addStation(beauxArts);
		besancon.addStation(securiteSociale);
		besancon.addStation(lavoisier);
		besancon.addStation(gibelotte);
		besancon.addStation(voirin);
		besancon.addStation(siffert);
		besancon.addStation(leclerc);
		besancon.addStation(gareViotte);
		besancon.addStation(notreDame);
		besancon.addStation(poleSportif);

		besancon.addLigne(l3);
		besancon.addLigne(l6);
		besancon.addLigne(l7);
		besancon.addLigne(l9);
		besancon.addLigne(l10);

		boolean fin = false;
		System.out.println("Bienvenue dans le simulateur d'optimisateur de livraison de marchandise sur le réseau de bus de Besançon");
		while(!fin){
			System.out.println("\nMenu principal :");
			System.out.println("1 - Lancer la simulation");
			System.out.println("2 - Voir la liste des stations");
			System.out.println("3 - Voir la liste des lignes");
			System.out.println("4 - Quitter");
			int choix = scan.nextInt();
			while(choix < 1 || choix > 4){
				System.out.println("Erreur de saisi !");
				System.out.println("\nMenu principal :");
				System.out.println("1 - Lancer la simulation");
				System.out.println("2 - Voir la liste des stations");
				System.out.println("3 - Voir la liste des lignes");
				System.out.println("4 - Quitter");
				choix = scan.nextInt();
			}
			if(choix == 4){
				fin = true;
			}else if(choix == 3) {
				for (Ligne l : besancon.getLignes()) {
					System.out.println("- "+l.getNomLigne());
					String c = "\t";
					for (Station s: l.getStations()) {
						c += s.getNomStation()+"   ";
					}
					System.out.println(c);
				}
			}else if(choix == 2) {
				for (Station s : besancon.getStations()) {
					System.out.println("- "+s.getNomStation());
				}
			}else if(choix == 1){
				scan.reset();
				System.out.println("Veuillez saisir une station de départ :");
				Station source;
				scan.nextLine();
				do{
					String saisi = scan.nextLine();
					//Mis en majuscule de la premiere lettre de chaque mot, gestion espace et tiret
					if(saisi.contains(" ")){
						saisi = saisi.substring(0,saisi.indexOf(" ")+1)+(saisi.substring(saisi.indexOf(" ")+1,saisi.indexOf(" ")+2)).toUpperCase()+saisi.substring(saisi.indexOf(" ")+2);
					}
					if(saisi.contains("-")){
						saisi = saisi.substring(0,saisi.indexOf("-")+1)+(saisi.substring(saisi.indexOf("-")+1,saisi.indexOf("-")+2)).toUpperCase()+saisi.substring(saisi.indexOf("-")+2);
					}
					saisi = saisi.substring(0,1).toUpperCase()+saisi.substring(1);
					String s = saisi;
					source = besancon.getStations().stream().filter(station -> s.equals(station.getNomStation())).findAny().orElse(null);
					if(source == null){
						System.out.println("Erreur cette station n'existe pas !");
						System.out.println("Veuillez saisir une station de départ :");
					}
				}while(source == null);
				scan.reset();
				System.out.println("Veuillez saisir une station d'arrivée :");
				Station destination;
				do{
					String saisi = scan.nextLine();
					//Mis en majuscule de la premiere lettre de chaque mot
					if(saisi.contains(" ")){
						saisi = saisi.substring(0,saisi.indexOf(" ")+1)+(saisi.substring(saisi.indexOf(" ")+1,saisi.indexOf(" ")+2)).toUpperCase()+saisi.substring(saisi.indexOf(" ")+2);
					}
					if(saisi.contains("-")){
						saisi = saisi.substring(0,saisi.indexOf("-")+1)+(saisi.substring(saisi.indexOf("-")+1,saisi.indexOf("-")+2)).toUpperCase()+saisi.substring(saisi.indexOf("-")+2);
					}
					saisi = saisi.substring(0,1).toUpperCase()+saisi.substring(1);
					String s = saisi;
					destination = besancon.getStations().stream().filter(station -> s.equals(station.getNomStation())).findAny().orElse(null);
					if(destination == null){
						System.out.println("Erreur cette station n'existe pas !");
						System.out.println("Veuillez saisir une station d'arrivée :");
					}
				}while(destination == null);

				System.out.println("Calcul du plus court chemin entre "+source.getNomStation()+" et "+destination.getNomStation()+" en cours ...\n");
				/* Appel de l'algorithme de Dijkstra */
				AlgorithmeDijkstra algoDijkstra = new AlgorithmeDijkstra();
				algoDijkstra.dijkstra(besancon, source, destination);
			}
		}
	}
}