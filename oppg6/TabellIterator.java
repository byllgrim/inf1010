package oppg6;

import java.util.Iterator;

public class TabellIterator<T> implements Iterator<T> {
	private T[] elementer;
	private int currentIndex = 0;

	public TabellIterator(T[] elementer) {
		this.elementer = elementer;
	}

	public boolean hasNext() {
		while (currentIndex < elementer.length) {
			if (elementer[currentIndex] != null)
				return true;

			currentIndex++;
		}

		return false;
	}

	public T next() {
		if (!hasNext())
			return null;

		return elementer[currentIndex++];
	}
}
