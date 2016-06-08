public class Beholder {
	private Node hode;
	private Node henteNode;

	class Node {
		private Object obj;
		private Node neste;

		public Node(Object obj) {
			this.obj = obj;
		}

		public Node hentNeste() {
			return neste;
		}

		public void settNeste(Node n) {
			neste = n;
		}

		public Object hentObject() {
			return obj;
		}
	}

	public Beholder() {
		hode = new Node(null); /* dummy */
		henteNode = hode;
	}

	public void fjern(Object o) {
		Node prev = hode, n = hode.hentNeste();

		for (; n != null; prev = n, n = n.hentNeste()) {
			if (n.hentObject().equals(o)) {
				prev.settNeste(n.hentNeste());
				henteNode = hode;
			}
		}
	}

	/*
	public void fjern(Object o) {
		Node n = hode;

		for (; n.hentNeste() != null; n = n.hentNeste()) {
			if (n.hentNeste().hentObject().equals(o)) {
				n.settNeste(n.hentNeste().hentNeste());
				henteNode = hode;
			}
		}
	}
	*/

	public void settInn(Object o) {
		if (o == null)
			return;

		Node n = hode;
		for (; n.hentNeste() != null; n = n.hentNeste()) {
			if (n.hentNeste().hentObject().equals(o))
				return;
		}

		n.settNeste(new Node(o));
		henteNode = hode;
	}

	public Object hent() {
		if (henteNode.hentNeste() == null)
			return null;

		henteNode = henteNode.hentNeste();
		return henteNode.hentObject();
	}

	public void ovfAlleFraBeholder(Beholder b) {
		Object o = b.hent();

		for (; o != null; o = b.hent()) {
			this.settInn(o);
			b.fjern(o);
		}
	}
}
