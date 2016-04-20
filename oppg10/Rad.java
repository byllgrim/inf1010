import java.util.Iterator;

public class Rad implements Iterable<Rute> {
	private Rute[] ruter;

	public Rad(int lengde) {
		ruter = new Rute[lengde];
	}

	public Iterator<Rute> iterator() {
		return new ArrayIterator<Rute>(ruter);
	}

	public void settInn(int verdi, int index) {
		Rute rute = new Rute(verdi, this);
		ruter[index] = rute;
	}

	public Rute hentRute(int index) {
		return ruter[index];
	}

	public int hentLengde() {
		return ruter.length;
	}

	public Rute sisteTommeRute() {
		int sisteIndex = Brett.hentLengde() - 1;
		for (int i = sisteIndex; i >= 0; i--) {
			if (ruter[i].hentVerdi() == 0)
				return ruter[i];
		}

		//TODO hva om alle er tomme?
		return null;
	}

	public Rute forsteTommeRute() {
		int sisteIndex = ruter.length - 1;
		for (int i = 0; i < sisteIndex; i++) {
			if (ruter[i].hentVerdi() == 0)
				return ruter[i];
		}

		//TODO hva om alle er tomme?
		return null;
	}

	public int ruteIndex(Rute r) {
		for (int i = 0; i < ruter.length; i++) {
			if (r == ruter[i])
				return i;
		}

		return -1; //fant ikke ruten
	}
}
