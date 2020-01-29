package Algorithme;

import Reseau.Ligne;
import Reseau.Plan;
import Reseau.Station;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class AlgorithmeDijkstra {

    /* Calcul le plus court chemin entre chaque noeud et la source */

    public void dijkstra(Plan plan, Station source, Station destination){
        init(plan);
        //Distance source a 0
        source.setDistanceDijkstra(0);
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Station> stationsAVisitees = new ArrayList<>();

        stationsAVisitees.add(source);

        //Tant qu'il reste des stations non visitees
        while(stationsAVisitees.size() != 0){
            Station stationCourante = getDistanceStation(stationsAVisitees);
            stationsAVisitees.remove(stationCourante);
            for(Map.Entry<Station,Integer> stationPair: stationCourante.getStationsAdjacentes().entrySet()){
                Station stationAdjacente = stationPair.getKey();
                Integer lignePoids = stationPair.getValue();
                if(!stations.contains(stationAdjacente)) {
                    calculDistanceMinimale(stationAdjacente, lignePoids, stationCourante);
                    //Ajout des stations adjacentes
                    stationsAVisitees.add(stationAdjacente);
                }
            }
            stations.add(stationCourante);
        }
        afficheResultat(plan, source, destination);
    }

    private void init(Plan plan) {
        for(Station s : plan.getStations()){
            s.setDistanceDijkstra(2000000000);
            s.setPlusCourtCheminDijkstra(new LinkedList<>());
        }
    }

    //Retourne la plus petite distance parmi toutes les stations pour recommencer une itération
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

    //Comparaison de la distance actuelle et de la nouvelle et mise a jour si besoin
    private void calculDistanceMinimale(Station stationAdjacente, Integer lignePoids, Station stationCourante){
        Integer distanceSource = stationCourante.getDistanceDijkstra();
        if(distanceSource + lignePoids < stationAdjacente.getDistanceDijkstra()){
            stationAdjacente.setDistanceDijkstra(distanceSource + lignePoids);
            LinkedList<Station> plusCourtChemin = new LinkedList<>(stationCourante.getPlusCourtCheminDijkstra());
            plusCourtChemin.add(stationCourante);
            stationAdjacente.setPlusCourtCheminDijkstra(plusCourtChemin);
        }
    }

    //Mise en forme du résultat
    private void afficheResultat(Plan plan, Station source, Station destination){
        ArrayList<Station> stations = destination.cheminDijkstra();
        ArrayList<Ligne> lignes = Ligne.ligneUtilisees(plan, stations);
        String c = "";
        for(int i = 0; i < stations.size(); i++){
            c += stations.get(i).getNomStation()+" ";
            if(i < lignes.size()){
                c += lignes.get(i).getNomLigne()+" ";
            }
        }
        System.out.println(c+"-> avec une distance totale de "+destination.getDistanceDijkstra());
    }
}
