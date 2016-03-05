package oppg6;

import java.util.Iterator;

public abstract class LenkelisteIterator<T> implements Iterator<T> {
	Node<T> hode = new Node<T>();
	Node<T> current;
	boolean firstIteration = true;

	public boolean erTom() {
		return (hode.data == null);
	}

	public boolean hasNext() {
		if (erTom())
			return false;

		if (firstIteration) {
			firstIteration = false;
			current = hode;
		}

		return (current != null);
	}

	@SuppressWarnings("unchecked")
	public T next() {
		if (hasNext()) {
			T r = current.data;
			current = current.neste;
			return r;
		} else {
			return null;
		}
	}

}
