import Reseau.Ligne;
import Reseau.Station;

public class Exemple {
	public static void main(String[] args) {
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
		Ligne l7 = new Ligne("L7", notreDame, poleSportif, poleTemis, uSport, campusArago, crous, papin, beauxArts, securiteSociale, lavoisier);
		Ligne l9 = new Ligne("L9", siffert, leclerc, notreDame, securiteSociale, beauxArts, papin);
		Ligne l6 = new Ligne("L6", poleTemis, poleSportif, leclerc);
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
		besancon.addLigne(l7);
		besancon.addLigne(l9);
		besancon.addLigne(l6);
		besancon.addLigne(l10);

		/* Appel de l'algorithme de Dijkstra */
		AlgorithmeDijkstra algoDijkstra = new AlgorithmeDijkstra();
		algoDijkstra.dijkstra(besancon, poleTemis);

		/* Visualiser le plus court chemin entre un noeud et la source */
		gibelotte.afficheCheminDijkstra();
		crous.afficheCheminDijkstra();
		gareViotte.afficheCheminDijkstra();
		securiteSociale.afficheCheminDijkstra();
		siffert.afficheCheminDijkstra();
	}
}
