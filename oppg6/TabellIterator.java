package oppg6;

import java.util.Iterator;

public class TabellIterator<T> implements Iterator<T> {
	private T[] elementer;
	private int currentIndex = 0;

	public TabellIterator(T[] elementer) {
		this.elementer = elementer;
	}

	public boolean hasNext() {
		//TODO handter tomme plasser i arrayet
		while (currentIndex < elementer.length) {
			if (elementer[currentIndex] != null)
				return true;

			currentIndex++;
		}

		return false;
	}

	public T next() {
		if (!hasNext()) //TODO hasNext er scopet overs sitt ansvar
			return null; //TODO exception

		//TODO handter tomme plasser i arrayet
		return elementer[currentIndex++];
	}
}
