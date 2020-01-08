package Reseau;


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

	public void addStationDest(Station station, int distance){
		stationsAdjacentes.put(station,distance);
	}

	public void afficheCheminDijkstra(){
		String c = "";
		for(Station s: plusCourtCheminDijkstra){
			c += s.getNomStation();
			c += ", ";
		}
		c += nomStation+" : "+distanceDijkstra;
		System.out.println(c);
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
}
