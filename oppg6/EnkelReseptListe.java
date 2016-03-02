import java.util.Iterator;

public abstract class EnkelReseptListe implements Iterator<Resept> {
	Node<Resept> hode = new Node<Resept>();
	Node<Resept> hale = hode;
	Node<Resept> current = hode;

	public void settInn(Resept resept) {
		Node<Resept> ny = new Node<Resept>();
		ny.data = resept;

		if (erTom()) {
			hode = hale = ny;
			return;
		}

		ny.neste = hode;
		hode = ny;
	}

	public boolean erTom() {
		return (hode.data == null);
	}

	public Resept finnResept(long nr) throws Exception {
		Node<Resept> n = hode;

		while (n != null) {
			if (n.data.nummer == nr)
				return n.data;
		}

		throw new Exception("Ikke-eksisterende Reseptnummer");
	}

	public boolean hasNext() {
		if (erTom())
			return false;

		return (current != null);
	}

	@SuppressWarnings("unchecked")
	public Resept next() {
		if (hasNext()) {
			Resept resept = current.data;
			current = current.neste;
			return resept;
		} else {
			return null;
		}
	}
}
