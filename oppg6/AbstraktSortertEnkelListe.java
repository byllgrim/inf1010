package oppg6;

import java.util.Iterator;
import oppg4.Lik;

public interface AbstraktSortertEnkelListe<E extends Comparable<E> & Lik>
                                          extends Iterator {
	public void settInn(E element, String nokkel);
	public E hentElement(String nokkel);
}
