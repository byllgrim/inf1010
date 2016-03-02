public class Tabell<E> implements AbstraktTabell<E> {
	private E[] elementer;
	private int currentIndex = 0;

	@SuppressWarnings("unchecked")
	public Tabell(int lengde) {
		elementer = (E[])new Object[lengde];
	}

	public boolean settInn(E element, int index) {
		if (elementer[index] != null) {
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
		if (currentIndex == elementer.length)
			return false;

		if (elementer[currentIndex] != null)
			return true;
		else
			return false;
	}

	public E next() {
		if (!hasNext())
			return null;

		return elementer[currentIndex++];
	}
}
