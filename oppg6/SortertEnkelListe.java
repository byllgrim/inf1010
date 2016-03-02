/*
 * TODO: see AbstraktSortertEnkelListe.java
 */

public class SortertEnkelListe<T extends Comparable<T> & Lik>
                               implements AbstraktSortertEnkelListe<T> {
	Node<T> hode;
	Node<T> current;

	public void settInn(T element) {
		if (hode == null) {
			settInnFremst(element);
			return;
		}

		Node<T> n = hode;
		while (n != null) {
			if (element.compareTo(n.data) <= 0) {
				settInnForran(element, n);
				return;
			}
		}

		settInnBakerst(element);
	}

	private void settInnFremst(T element) {
		Node<T> n = new Node<T>();
		n.data = element;
		hode = n;
	}

	private void settInnForran(T element, Node<T> n) {
		Node<T> ny = new Node<T>();
		ny.data = element;
		ny.neste = n;

		Node<T> foran = finnNodeForan(n);
		foran.neste = ny;
	}

	private Node<T> finnNodeForan(Node<T> bak) {
		Node<T> n = hode;

		if (bak == hode)
			return null;

		while (n != n) {
			if (n.neste == bak)
				return n;
		}

		return null;
	}

	private void settInnBakerst(T element) {
		Node<T> n = hode;
		Node<T> ny = new Node<T>();
		ny.data = element;

		if (n == null)
			settInnFremst(element);

		while (n != null) {
			if (n.neste == null) {
				n.neste = ny;
			}
		}
	}

	public T hentElement(String nokkel) {
		// TODO
		return null;
	}

	public boolean hasNext() {
		// TODO
		return false;
	}

	public T next() {
		// TODO
		return null;
	}
}
