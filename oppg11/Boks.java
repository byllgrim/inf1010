import java.util.Iterator;

public class Boks implements Iterable<Rute> {
	private Rute[] ruter;
	int settInnIndex = 0;

	public Boks(int lengde) {
		ruter = new Rute[lengde];
	}

	public Iterator<Rute> iterator() {
		return new ArrayIterator<Rute>(ruter);
	}

	public void settInn(Rute rute) {
		ruter[settInnIndex++] = rute;
	}
}
