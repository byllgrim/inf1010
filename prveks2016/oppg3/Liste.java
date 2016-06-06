class Liste <T extends Comparable<T>> {
	private Node foran;

	private class ListeEnde extends Node {
		ListeEnde(T nyttObjekt) {
			super(nyttObjekt);
		}

		void settInn(Node ny) {
			if (ny.sammenlign(this) < 0) {
				T tmpval = t;
				t = ny.t;
				ny.t = tmpval;

				Node tmpnode = neste;
				neste = ny;
				ny.neste = tmpnode;
			} else {
				if (neste == null)
					neste = ny;
				else
					super.settInn(ny);
			}
		}
	}

	private class Node {
		protected T t;
		protected Node neste;

		Node(T nyttObjekt) {
			t = nyttObjekt;
		}

		int sammenlign(Node k) {
			return t.compareTo(k.t);
		}

		void settInn(Node ny) {
			if (sammenlign(ny) < 0 && neste.sammenlign(ny) >= 0) {
				Node tmp = neste;
				neste = ny;
				ny.neste = tmp;
			} else {
				neste.settInn(ny);
			}
		}

		void skriv() {
			System.out.println(t);
			neste.skriv();
		}
	}

	Liste() {
		foran = new ListeEnde(null);
		foran.settInn(new ListeEnde(null));
	}

	public void settInn(T t) {
		Node nyNode = new Node(t);
		foran.settInn(nyNode);
	}

	public void skrivAlle() {
		System.out.println("Alle i lista:\n--------");
		foran.skriv();
		System.out.println("--SLUTT--");
	}
}
