import java.util.Iterator;

public class Kolonne implements Iterable<Rute> {
	private Rute[] ruter;

	public Kolonne(int lengde) {
		ruter = new Rute[lengde];
	}

	public Iterator<Rute> iterator() {
		return new ArrayIterator<Rute>(ruter);
	}

	public void settInn(Rute rute, int index) {
		ruter[index] = rute;
	}

	public Rute hentRute(int index) {
		return ruter[index];
	}
}
