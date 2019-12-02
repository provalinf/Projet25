import Reseau.Ligne;
import Reseau.Station;
import Reseau.Trajet;

import java.util.ArrayList;

public class Exemple {
	public static void main(String[] args) {
		Plan besancon = new Plan("Besançon");
		besancon.addStation(new Station("Pole Temis"));
		besancon.addStation(new Station("U-Sport"));
		besancon.addStation(new Station("Campus Arago"));
		besancon.addStation(new Station("Crous"));
		besancon.addStation(new Station("Papin"));
		besancon.addStation(new Station("Beaux Arts"));
		besancon.addStation(new Station("Securite Sociale"));
		besancon.addStation(new Station("Lavoisier"));
		besancon.addStation(new Station("Gibelotte"));
		besancon.addStation(new Station("Voirin"));
		besancon.addStation(new Station("Siffert"));
		besancon.addStation(new Station("Leclerc"));
		besancon.addStation(new Station("Gare viotte"));
		besancon.addStation(new Station("Notre Dame"));
		besancon.addStation(new Station("Pole Sportif"));
		besancon.addStation(new Station("Notre Dame"));

		besancon.addLigne(new Ligne("L3",
				new Trajet(besancon.getStation("Pole Temis"), besancon.getStation("U-Sport"), 3, true),
				new Trajet(besancon.getStation("U-Sport"), besancon.getStation("Campus Arago"), 2, true),
				new Trajet(besancon.getStation("Campus Arago"), besancon.getStation("Crous"), 1, true),
				new Trajet(besancon.getStation("Crous"), besancon.getStation("Gibelotte"), 10, true),
				new Trajet(besancon.getStation("Gibelotte"), besancon.getStation("Voirin"), 1, true),
				new Trajet(besancon.getStation("Gare Viotte"), besancon.getStation("Voirin"), 5, true)
		));


		besancon.addLigne(new Ligne("L7",
				new Trajet(besancon.getStation("Notre Dame"), besancon.getStation("Pole Sportif"), 1, true),
				new Trajet(besancon.getStation("Pole Temis"), besancon.getStation("Pole Sportif"), 2, true),
				new Trajet(besancon.getStation("Pole Temis"), besancon.getStation("U-Sport"), 3, true),
				new Trajet(besancon.getStation("U-Sport"), besancon.getStation("Campus Arago"), 2, true),
				new Trajet(besancon.getStation("Campus Arago"), besancon.getStation("Crous"), 1, true),
				new Trajet(besancon.getStation("Crous"), besancon.getStation("Papin"), 5, true),
				new Trajet(besancon.getStation("Papin"), besancon.getStation("Beaux Arts"), 1, true),
				new Trajet(besancon.getStation("Securite Sociale"), besancon.getStation("Beaux Arts"), 1, true),
				new Trajet(besancon.getStation("Securite Sociale"), besancon.getStation("Lavoisier"), 8, true)
		));


		besancon.addLigne(new Ligne("L9",
				new Trajet(besancon.getStation("Leclerc"), besancon.getStation("Siffert"), 1, true),
				new Trajet(besancon.getStation("Leclerc"), besancon.getStation("Notre Dame"), 6, true),
				new Trajet(besancon.getStation("Securite Sociale"), besancon.getStation("Notre Dame"), 7, true),
				new Trajet(besancon.getStation("Papin"), besancon.getStation("Beaux Arts"), 1, true),
				new Trajet(besancon.getStation("Securite Sociale"), besancon.getStation("Beaux Arts"), 1, true)
		));


		besancon.addLigne(new Ligne("L6",
				new Trajet(besancon.getStation("Pole Temis"), besancon.getStation("Pole Sportif"), 2, true),
				new Trajet(besancon.getStation("Pole Sportif"), besancon.getStation("Leclerc"), 6, true)
		));


		besancon.addLigne(new Ligne("L10",
				new Trajet(besancon.getStation("Lavoisier"), besancon.getStation("Gibelotte"), 28, true),
				new Trajet(besancon.getStation("Voirin"), besancon.getStation("Gibelotte"), 1, true),
				new Trajet(besancon.getStation("Voirin"), besancon.getStation("Siffert"), 1, true)
		));


	}
}
