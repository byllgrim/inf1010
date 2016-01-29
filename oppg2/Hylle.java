public class Hylle<T> implements GenHylle<T> {
	private T[] plasser;

	public Hylle(int n) {
		plasser = (T[]) new Object[n];
	}

	public int storrelse() {
		return 0;
	}

	public void settInn(T e, int i) {
	}

	public boolean erLedig(int i) {
		return false;
	}

	public T taUt(int i) {
		return null;
	}
}
