package Transport;

import Reseau.Ligne;

public abstract class Transport {
	protected String idTransport;
	protected Ligne affecteLigne;
	protected int nbCapacitePersonne;
	protected int nbPersonne;

	public Transport(String idTransport, Ligne affecteLigne) {
		this.idTransport = idTransport;
		this.affecteLigne = affecteLigne;
	}
}
