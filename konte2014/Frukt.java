public abstract class Frukt {
	protected String sort;

	public String id() {
		return sort;
	}

	public boolean equals(Object o) {
		return (o instanceof Frukt
		        && sort.compareTo(((Frukt)o).id()) == 0);
	}

	public String toString() {
		return sort;
	}
}
