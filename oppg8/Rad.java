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
}
