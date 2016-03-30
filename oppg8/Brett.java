public class Brett {
	private Storrelse bs; //TODO public?
	private Boks[] bokser;
	private Rad[] rader;
	private Kolonne[] kolonner;

	public Brett(Storrelse boksStorrelse, Rad[] rader) {
		this.bs = boksStorrelse;
		this.rader = rader;
		opprettDatastruktur();
	}

	private void opprettDatastruktur() {
		int lengde = (bs.bredde * bs.hoyde);
		bokser = new Boks[lengde];
		kolonner = new Kolonne[lengde];

		//TODO
	}
}
