public class Tabell<E> implements AbstraktTabell<E> {
	private E[] elementer;

	public Tabell(int lengde) {
		elementer = (E[])new Object[lengde];
	}

	public boolean settInn(E element, int index) {
		// TODO
		return false;
	}

	public E hentElement(int index) {
		// TODO
		return null;
	}
}
