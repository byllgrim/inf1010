public class Hylle<T> implements GenHylle<T> {
	private T[] plasser;
	private int bruktePlasser;

	public Hylle(int n) {
		plasser = (T[]) new Object[n];
		bruktePlasser = 0;
	}

	public int storrelse() {
		return plasser.length;
	}

	public boolean settInn(T e, int i) {
		if (plassFinnes(i) && erLedig(i)) { /* rekkefolge viktig */
			plasser[i] = e;
			bruktePlasser++;
			return true;
		} else {
			return false;
		}
	}

	public boolean erLedig(int i) {
		if (plassFinnes(i) && plasser[i] == null) {
			return true;
		} else {
			return false;
		}
	}

	public T taUt(int i) {
		if (plassFinnes(i) && plasser[i] != null) {
			T tmp = plasser[i];
			plasser[i] = null;
			bruktePlasser--;
			return tmp;
		} else {
			return null;
		}
	}

	public int hentBruktePlasser() {
		return bruktePlasser;
	}

	private boolean plassFinnes(int i) {
		if (i < 0) {
			return false;
		} else if (i > storrelse()) {
			return false;
		} else {
			return true;
		}
	}
}
