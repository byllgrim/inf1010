package oppg6;

import oppg4.Lik;

public interface AbstraktSortertEnkelListe<E extends Comparable<E> & Lik> {
	public void settInn(E element, String nokkel);
	public E hentElement(String nokkel);
}
