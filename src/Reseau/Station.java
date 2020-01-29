package Reseau;


import Algorithme.Horaire;
import Marchandise.Marchandise;
import Marchandise.SacCourrier;
import Marchandise.ConteneurVerre;

import java.util.*;

public class Station {
	private String nomStation;
	private List<Station> plusCourtCheminDijkstra = new LinkedList<>();
	private Integer distanceDijkstra = 2000000000;
	private Map<Station,Integer> stationsAdjacentes = new HashMap<>();
	private HashMap<Marchandise, Integer> stockageMax;
	private ArrayList<Marchandise> stockage;

	private HashMap<Horaire, Integer> charge;

	public Station(String nomStation, HashMap<Marchandise, Integer> stockageMax, ArrayList<Marchandise> stockage) {
		this.nomStation = nomStation;
		this.stockageMax = stockageMax;
		this.stockage = stockage;
		charge = new HashMap<>();
	}

	public Station(String nomStation) {
		this(nomStation, new HashMap<Marchandise, Integer>(), new ArrayList<Marchandise>());
		initExemple();
	}

	private void initExemple() {
		stockageMax.put(new SacCourrier(), 20);
		stockageMax.put(new ConteneurVerre(), 2);
	}

	public void addStationDest(Station station, int distance){
		stationsAdjacentes.put(station,distance);
	}

	public ArrayList<Station> cheminDijkstra(){
		ArrayList<Station> stations = new ArrayList<>();
		for(Station s: plusCourtCheminDijkstra){
			stations.add(s);
		}
		stations.add(this);
		return stations;
	}

	public String getNomStation() {
		return nomStation;
	}

	public List<Station> getPlusCourtCheminDijkstra() {
		return plusCourtCheminDijkstra;
	}

	public void setPlusCourtCheminDijkstra(List<Station> plusCourtCheminDijkstra) {
		this.plusCourtCheminDijkstra = plusCourtCheminDijkstra;
	}

	public Integer getDistanceDijkstra() {
		return distanceDijkstra;
	}

	public void setDistanceDijkstra(Integer distanceDijkstra) {
		this.distanceDijkstra = distanceDijkstra;
	}

	public Map<Station, Integer> getStationsAdjacentes() {
		return stationsAdjacentes;
	}

	public HashMap<Marchandise, Integer> getStockageMax() {
		return stockageMax;
	}

	public ArrayList<Marchandise> getStockage() {
		return stockage;
	}

	public void addCharge(int pointDeCharge, int heure, int minute) {
		charge.put(new Horaire(heure, minute), pointDeCharge);
	}

	public int getCharge(Horaire horaire) {
		int ch = 0;
		if (charge.containsKey(horaire)) {
			return charge.get(horaire);
		} else {
			// charge proportionnelle dans les +10 minutes
			for (int i = 1; i < 10; i++) {
				if (charge.containsKey(horaire.getHoraireWithAddMinute(i))) {
					ch += (int) (charge.get(horaire.getHoraireWithAddMinute(i))*((10-i)*0.1));
					break;
				}
			}
			// charge proportionnelle dans les -10 minutes
			for (int i = 1; i < 10; i++) {
				if (charge.containsKey(horaire.getHoraireWithRemMinute(i))) {
					ch += (int) (charge.get(horaire.getHoraireWithRemMinute(i))*((10-i)*0.1));
					break;
				}
			}
			return ch;
		}
	}
}
