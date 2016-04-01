import java.util.Iterator;

public class Boks implements Iterable<Rute> {
	private Rute[] ruter;

	public Iterator<Rute> iterator() {
		return new ArrayIterator<Rute>(ruter);
	}
}
