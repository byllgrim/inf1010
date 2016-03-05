package oppg6;

import java.util.Iterator;
import oppg4.Resept;

public abstract class EnkelReseptListe extends LenkelisteIterator<Resept>
                                       implements Iterator<Resept> {
	protected Node<Resept> hale = hode;

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

	@SuppressWarnings("unchecked")
	public Resept finnResept(long nr) throws Exception {
		Node<Resept> n = hode;

		while (n != null) {
			if (n.data.hentNummer() == nr)
				return n.data;
			n = n.neste;
		}

		throw new Exception("Ikke-eksisterende Reseptnummer");
	}
}
