public class Brett {
	private Storrelse bs;
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
		initKolonner();
		initBokser();
	}

	private void initKolonner() {
		kolonner = new Kolonne[lengde];

		for (int i = 0; i < lengde; i++) {
			kolonner[i] = new Kolonne(lengde);
		}

		for (int i = 0; i < lengde; i++) {
			for (int j = 0; j < lengde; j++) {
				Rute rute = rader[i].hentRute(j);
				kolonner[j].settInn(rute, i);
				rute.settKolonne(kolonner[j]);
			}
		}
	}

	private void initBokser() {
		bokser = new Boks[lengde];

		for (int i = 0; i < lengde; i++) {
			bokser[i] = new Boks(lengde);
		}

		for (int i = 0; i < lengde; i++) { //Rader
			for (int j = 0; j < lengde; j++) { //Kolonner
				initBoksRute(i, j);
				//Første multiple av m og første av n
			}
		}
	}

	private void initBoksRute(int n, int m) {
		int xmult = m/bs.bredde;
		int ymult = (n/bs.hoyde)*bs.hoyde;

		Boks b = bokser[xmult + ymult];
		Rute r = rader[n].hentRute(m);
		r.settBoks(b);
		b.settInn(r);
	}

	public void printBrett() {
		//TODO: pen utskrift av brett
	}

	public static int hentLengde() {
		return lengde;
	}

	public Rute hentRute(int m, int n) {
		return rader[n].hentRute(m);
	}

	public Boks hentBoks(int i) {
		return bokser[i];
	}
}
