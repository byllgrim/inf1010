public class LenkeListe<E extends Comparable<E>> {
	private Node foersteNode = null;

	private class Node {
		E data = null;
		Node neste = null;
		Node forrige = null;
	}

	public boolean tom() {
		return foersteNode == null;
	}

	public void leggTil(E e) {
		Node tmp = new Node();
		tmp.data = e;
		tmp.neste = foersteNode;

		if (foersteNode != null)
			tmp.neste.forrige = tmp;

		tmp.forrige = null;
		foersteNode = tmp;
	}

	public E fjernMinste() {
		Node minste, n;
		minste = n = foersteNode;

		if (n == null)
			return null;

		while (n != null) {
			minste = minsteNode(n, minste);
			n = n.neste;
		}

		E e = minste.data;
		fjernNode(minste);
		return e;
	}

	private Node minsteNode(Node n1, Node n2) {
		E d1 = n1.data;
		E d2 = n2.data;
		return (d1.compareTo(d2) <= 0) ? n1 : n2;
	}

	private void fjernNode(Node n) {
		if (n.forrige != null)
			n.forrige.neste = n.neste;

		if (n.neste != null)
			n.neste.forrige = n.forrige;

		if (n == foersteNode)
			foersteNode = n.neste;
	}

	public boolean inneholder(E e) {
		Node n = foersteNode;

		while (n != null) {
			if (e.compareTo(n.data) == 0)
				return true;

			n = n.neste;
		}

		return false; 
	}
}
