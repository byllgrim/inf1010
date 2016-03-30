public class Kolonne {
	private Rute[] ruter;

	public Kolonne(int lengde) {
		ruter = new Rute[lengde];
	}

	public void settInn(Rute rute, int index) {
		ruter[index] = rute;
	}

	public Rute hentRute(int index) {
		return ruter[index];
	}
}
