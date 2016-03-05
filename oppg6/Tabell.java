package oppg6;

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

	public E hentElement(int index) {
		return elementer[index];
	}

	public boolean hasNext() {
		while (currentIndex < elementer.length) {
			if (elementer[currentIndex] != null)
				return true;

			currentIndex++;
		}

		return false;
	}

	public E next() {
		if (!hasNext())
			return null;

		return elementer[currentIndex++];
	}
}
