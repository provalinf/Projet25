package Algorithme;

/**
 * Created by Valentin.
 */
public class Horaire {
	private int heure, minute;

	public Horaire(int heure, int minute) {
		this.heure = heure;
		this.minute = minute;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	/*
	 * Limitation : Ne pas donner de minute supérieur à 59
	 */
	public Horaire getHoraireWithAddMinute(int min) {
		int h, m;
		h = getHeure();
		m = getMinute();

		if (minute + min > 59) {
			m = (minute + min) - 60;
			if (heure + 1 > 23) {
				h = 0;
			} else {
				h = heure + 1;
			}
		} else {
			m = minute + min;
		}
		return new Horaire(h, m);
	}

	public Horaire getHoraireWithRemMinute(int min) {
		int h, m;
		h = getHeure();
		m = getMinute();

		if (minute - min < 0) {
			m = 60 + (minute - min);
			if (heure - 1 < 0) {
				h = 23;
			} else {
				h = heure + 1;
			}
		} else {
			m = minute - min;
		}
		return new Horaire(h, m);
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(heure + "" + minute);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Horaire)) return false;
		return ((Horaire) obj).heure == heure && ((Horaire) obj).minute == minute;
	}

	@Override
	public String toString() {
		return "Horaire{" +
				"heure=" + heure +
				", minute=" + minute +
				'}';
	}
}
