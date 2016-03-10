package oppg6;

import java.util.Iterator;

public class Tabell<E> implements AbstraktTabell<E> {
	private E[] elementer;
	private int currentIndex = 0;

	@SuppressWarnings("unchecked")
	public Tabell(int lengde) {
		elementer = (E[])new Object[lengde];
	}

	public boolean settInn(E element, int index) {
		// TODO: hva med out of bounds?
		// TODO: Array fullt
		if (elementer[index] == null) {
			elementer[index] = element;
			return true;
		} else {
			return false;
		}
	}

	public boolean settInn(E element) {
		for (int i = 0; i < elementer.length; i++) {
			if (elementer[i] == null) {
				elementer[i] = element;
				return true;
			}
		}
		return false;
	}

	public E hentElement(int index) {
		return elementer[index];
	}

	public Iterator<E> iterator() {
		return new TabellIterator<E>(elementer);
	}
}
