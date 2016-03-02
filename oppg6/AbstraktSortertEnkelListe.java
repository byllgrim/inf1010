import java.util.Iterator;

public interface AbstraktSortertEnkelListe<E extends Comparable<E> & Lik>
                                          extends Iterator {
	public void settInn(E element);
	public E hentElement(String nokkel);
}
