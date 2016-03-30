public class Rad {
	private Rute[] ruter; //TODO: public?

	public Rad(int lengde) {
		ruter = new Rute[lengde];
	}

	public void settInn(int verdi, int index) {
		Rute rute = new Rute(verdi, this);
		ruter[index] = rute;
	}

	public Rute hentRute(int index) {
		return ruter[index];
	}
}
