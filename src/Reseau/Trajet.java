package Reseau;

public class Trajet {
	private Station stationA;
	private Station stationB;
	private int distance;

	public Trajet(Station stationA, Station stationB, int distance) {
		this.stationA = stationA;
		this.stationB = stationB;
		this.distance = distance;
	}
}
