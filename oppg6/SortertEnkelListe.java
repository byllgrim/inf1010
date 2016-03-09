package oppg6;

import java.util.Iterator;
import oppg4.Lik;

public class SortertEnkelListe<T extends Comparable<T> & Lik>
                               implements AbstraktSortertEnkelListe<T>
{
	Node<T> hode = new Node<T>();

	@SuppressWarnings("unchecked")
	public void settInn(T element, String nokkel) {
		if (erTom()) {
			settInnFremst(element, nokkel);
			return;
		}

		//Sammenlign med forste node
		Node<T> n = hode;
		if (element.compareTo(n.data)<=0) {
			settInnFremst(element, nokkel);
			return;
		}

		//Er det kun en node?
		if (n.neste == null) {
			settInnEtterNode(element, nokkel, n);
			return;
		}

		n = hode.neste;
		Node<T> nprev = hode;
		while (n != null) {
			if (element.compareTo(n.data) <= 0) {
				settInnEtterNode(element, nokkel, nprev);
				return;
			}
			nprev = n;
			n = n.neste;
		}

		settInnEtterNode(element, nokkel, nprev);
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

	private void settInnEtterNode(T element, String nokkel, Node<T> n) {
		Node<T> ny = new Node<T>();
		ny.data = element;
		ny.nokkel = nokkel;
		ny.neste = n.neste;
		n.neste = ny;
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

	public Iterator<T> iterator() {
		return new LenkelisteIterator<T>(hode);
	}
}
