package Reseau;

public class Trajet {
	private Station stationA;
	private Station stationB;
	private int distance;
	private boolean deuxSens;

	public Trajet(Station stationA, Station stationB, int distance, boolean deuxSens) {
		this.stationA = stationA;
		this.stationB = stationB;
		this.distance = distance;
		this.deuxSens = deuxSens;
	}
}
