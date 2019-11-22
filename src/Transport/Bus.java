package Transport;

import Reseau.Ligne;

public class Bus extends Transport {
	public Bus(String idTransport, Ligne affecteLigne) {
		super(idTransport, affecteLigne);
	}

	@Override
	public String toString() {
		return "Bus_" + idTransport;
	}
}
