package oppg6;

import oppg4.Lik;

public class SortertEnkelListe<T extends Comparable<T> & Lik>
                               implements AbstraktSortertEnkelListe<T> {
	Node<T> hode = new Node<T>();
	Node<T> current;

	@SuppressWarnings("unchecked")
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
			n = n.neste;
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
		hode = current = n;
	}

	private void settInnForranNode(T element, String nokkel, Node<T> n) {
		Node<T> ny = new Node<T>();
		ny.data = element;
		n.nokkel = nokkel;
		ny.neste = n;

		Node<T> foran = finnNodeForan(n);
		foran.neste = ny;
	}

	@SuppressWarnings("unchecked")
	private Node<T> finnNodeForan(Node<T> bak) {
		Node<T> n = hode;

		if (bak == hode)
			return null;

		while (n != null) {
			if (n.neste == bak)
				return n;

			n = n.neste;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
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
				return;
			}
			n = n.neste;
		}
	}

	@SuppressWarnings("unchecked")
	public T hentElement(String nokkel) {
		Node<T> n = hode;

		while (n != null) {
			if (n.nokkel.compareTo(nokkel) == 0)
				return n.data;

			n = n.neste;
		}

		return null;
	}

	public boolean hasNext() {
		if (erTom())
			return false;

		return (current != null);
	}

	@SuppressWarnings("unchecked")
	public T next() {
		if (hasNext()) {
			T r = current.data;
			current = current.neste;
			return r;
		} else {
			return null;
		}
	}
}
