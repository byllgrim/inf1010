/*
 * TODO: Hvis denne bounded type parameter skal implementere
 * baade Comparable OG Lik betyr det at Lik MAA implementere Comparable.
 * Man kan ikke skrive <E implements Comparable,Lik>
 */

public interface AbstraktSortertEnkelListe<E extends Comparable<E>> {
	public void settInn(E element);
	public E hentElement(String nokkel);
	// TODO iterator
}
