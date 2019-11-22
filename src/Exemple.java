import Reseau.Ligne;
import Reseau.Station;
import Reseau.Trajet;

import java.util.ArrayList;

public class Exemple {
	public static void main(String[] args) {
		Plan besancon = new Plan("Besançon");
		Trajet trajets[] = new Trajet[10];
		Ligne lignes[] = new Ligne[20];
		trajets[0] = new Trajet(new Station("S0"), new Station("S1"),1);
		trajets[1] = new Trajet(new Station("S0"), new Station("S2"),1);
		trajets[2] = new Trajet(new Station("S2"), new Station("S1"),1);
		lignes[0] = new Ligne("L1");
		lignes[0].addTrajet(trajets[0]);
		besancon.addLigne(lignes[0]);
	}
}
