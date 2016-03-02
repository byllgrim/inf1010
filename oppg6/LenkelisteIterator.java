package oppg6;

public abstract class LenkelisteIterator<T> {
	Node<T> hode = new Node<T>();
	Node<T> current;

	public boolean erTom() {
		return (hode.data == null);
	}

	public boolean hasNext() {
		if (erTom())
			return false;

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
