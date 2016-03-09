package oppg6;

import java.util.Iterator;

public interface AbstraktTabell<E> extends Iterable{
	public boolean settInn(E element, int index);
	public E hentElement(int index);
}
