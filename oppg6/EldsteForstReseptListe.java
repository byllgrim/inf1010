package oppg6;

import oppg4.Resept;

public class EldsteForstReseptListe extends EnkelReseptListe {
	public void settInn(Resept resept) {
		Node<Resept> ny = new Node<Resept>();
		ny.data = resept;

		if (erTom()) {
			hode = hale = ny;
			return;
		}

		hale.neste = ny;
		hale = ny;
	}
}
