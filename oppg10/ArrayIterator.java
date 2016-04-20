import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
	T[] elementer;
	int index;

	public ArrayIterator(T[] elementer) {
		this.elementer = elementer;
		this.index = 0;
	}

	public boolean hasNext() {
		return (index < elementer.length);
	}

	public T next() {
		return elementer[index++];
	}
}
