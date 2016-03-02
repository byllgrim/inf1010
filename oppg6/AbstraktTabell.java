package oppg6;

import java.util.Iterator;

public interface AbstraktTabell<E> extends Iterator<E>{
	public boolean settInn(E element, int index);
	public E hentElement(int index);
}
