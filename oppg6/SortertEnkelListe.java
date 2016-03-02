public class SortertEnkelListe<T extends Comparable<T> & Lik>
                               implements AbstraktSortertEnkelListe<T> {
	Node<T> hode = new Node<T>();
	Node<T> current = hode;

	public void settInn(T element, String nokkel) {
		if (erTom()) {
			settInnFremst(element, nokkel);
			return;
		}

		Node<T> n = hode;
		while (n != null) {
			if (element.compareTo(n.data) <= 0) {
				settInnForranNode(element, nokkel, n);
				return;
			}
		}

		settInnBakerst(element, nokkel);
	}

	public boolean erTom() {
		return (hode.data == null);
	}

	private void settInnFremst(T element, String nokkel) {
		Node<T> n = new Node<T>();
		n.data = element;
		n.nokkel = nokkel;
		hode = n;
	}

	private void settInnForranNode(T element, String nokkel, Node<T> n) {
		Node<T> ny = new Node<T>();
		ny.data = element;
		n.nokkel = nokkel;
		ny.neste = n;

		Node<T> foran = finnNodeForan(n);
		foran.neste = ny;
	}

	private Node<T> finnNodeForan(Node<T> bak) {
		Node<T> n = hode;

		if (bak == hode)
			return null;

		while (n != null) {
			if (n.neste == bak)
				return n;
		}

		return null;
	}

	private void settInnBakerst(T element, String nokkel) {
		Node<T> n = hode;
		Node<T> ny = new Node<T>();
		ny.data = element;
		ny.nokkel = nokkel;

		if (erTom())
			settInnFremst(element, nokkel);

		while (n != null) {
			if (n.neste == null) {
				n.neste = ny;
			}
		}
	}

	public T hentElement(String nokkel) {
		Node<T> n = hode;

		while (n != null) {
			if (n.nokkel.compareTo(nokkel) == 0)
				return n.data;
		}

		return null;
	}

	public boolean hasNext() {
		return (current == null);
	}

	public T next() {
		if (hasNext())
			return current.data;
		else
			return null;
	}
}
