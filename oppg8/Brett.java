public class Brett {
	private Storrelse bs; //TODO public?
	private Boks[] bokser;
	private Rad[] rader;
	private Kolonne[] kolonner;

	private static int lengde;

	public Brett(Storrelse boksStorrelse, Rad[] rader) {
		this.bs = boksStorrelse;
		this.lengde = (bs.bredde * bs.hoyde);
		this.rader = rader;
		opprettDatastruktur();
	}

	private void opprettDatastruktur() {
		initBokser();
		bokser = new Boks[lengde];

		//TODO
	}

	private void initBokser() {
		kolonner = new Kolonne[lengde];

		for (int i = 0; i < lengde; i++) {
			kolonner[i] = new Kolonne(lengde);
		}

		for (int i = 0; i < lengde; i++) {
			for (int j = 0; j < lengde; j++) {
				Rute rute = rader[i].hentRute(j);
				kolonner[j].settInn(rute, i);
			}
		}
	}

	public void printBrett() {
		//TODO
	}

	public static int hentLengde() {
		return lengde;
	}
}