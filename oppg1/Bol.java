public class Bol<T> {
	private T dyr = null;

	public boolean erTomt() {
		if (dyr == null) {
			return true;
		} else {
			return false;
		}
	}

	public void leggTilDyr(T dyr) {
		if (erTomt()) {
			this.dyr = dyr;
		} else {
			System.out.println("Ingen plass i herberget.");
		}
	}

	public T hentDyr() {
		return dyr;
	}
}
