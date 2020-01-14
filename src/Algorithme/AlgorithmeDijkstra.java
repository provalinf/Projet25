package Algorithme;

import Reseau.Ligne;
import Reseau.Plan;
import Reseau.Station;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlgorithmeDijkstra {

    /* Calcul le plus court chemin entre chaque noeud et la source */

    public void dijkstra(Plan plan, Station source, Station destination){
        source.setDistanceDijkstra(0);
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Station> stationsAVisitees = new ArrayList<>();

        stationsAVisitees.add(source);

        while(stationsAVisitees.size() != 0){
            Station stationCourante = getDistanceStation(stationsAVisitees);
            stationsAVisitees.remove(stationCourante);
            for(Map.Entry<Station,Integer> stationPair: stationCourante.getStationsAdjacentes().entrySet()){
                Station stationAdjacente = stationPair.getKey();
                Integer lignePoids = stationPair.getValue();
                if(!stations.contains(stationAdjacente)) {
                    calculDistanceMinimale(stationAdjacente, lignePoids, stationCourante);
                    stationsAVisitees.add(stationAdjacente);
                }
            }
            stations.add(stationCourante);
        }
        afficheResultat(plan, source, destination);
    }

    private Station getDistanceStation(ArrayList<Station> station){
        Station stationPlusCourteDistance = null;
        int plusCourteDistance = 2000000000;
        for(Station s: station){
            int distance = s.getDistanceDijkstra();
            if(distance < plusCourteDistance){
                plusCourteDistance = distance;
                stationPlusCourteDistance = s;
            }
        }
        return stationPlusCourteDistance;
    }

    private void calculDistanceMinimale(Station stationAdjacente, Integer lignePoids, Station stationCourante){
        Integer distanceSource = stationCourante.getDistanceDijkstra();
        if(distanceSource + lignePoids < stationAdjacente.getDistanceDijkstra()){
            stationAdjacente.setDistanceDijkstra(distanceSource + lignePoids);
            LinkedList<Station> plusCourtChemin = new LinkedList<>(stationCourante.getPlusCourtCheminDijkstra());
            plusCourtChemin.add(stationCourante);
            stationAdjacente.setPlusCourtCheminDijkstra(plusCourtChemin);
        }
    }

    private void afficheResultat(Plan plan, Station source, Station destination){
        ArrayList<String> stations = destination.cheminDijkstra();
        ArrayList<String> lignes = Ligne.ligneUtilisees(plan, stations);
        for(String ligne: lignes){
            System.out.println(ligne);
        }
        System.out.println("Distance totale : "+destination.getDistanceDijkstra());
    }
}
