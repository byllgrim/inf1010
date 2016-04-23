public class Brett {
	private Storrelse bs; //BoksStorrelse
	private Boks[] bokser;
	private Rad[] rader;
	private Kolonne[] kolonner;
	private int lengde;
	private SudokuBeholder sb;

	public Brett(Storrelse boksStorrelse, Rad[] rader) {
		this.bs = boksStorrelse;
		this.lengde = (bs.bredde * bs.hoyde);
		this.rader = rader;
		opprettDatastruktur();
	}

	private void opprettDatastruktur() {
		initKolonner();
		initBokser();
		giRuterBrett();
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

	private void giRuterBrett() {
		for (int i = 0; i < rader.length; i++) {
			for (Rute r : rader[i]) {
				r.settBrett(this);
			}
		}
	}

	public void printBrett() {
		for (int i = 0; i < lengde; i++) { //Rader
			for (int j = 0; j < lengde; j++) { //Kolonner
				printChar(j, i);
			}

			System.out.println();
			printHorizontalRule(i);
		}
	}

	private void printChar(int m, int n) {
		if (m != 0 && m%bs.bredde == 0)
			System.out.printf("|");

		int v = rader[n].hentRute(m).hentVerdi();

		if (v == 0)
			System.out.printf(" ");
		else
			System.out.printf("%c", VerdiKonverterer.tilSymbol(v));
	}

	private void printHorizontalRule(int n) {
		n++;
		if (n == 1 || n%bs.hoyde != 0 || n == lengde)
			return;

		for (int m = 0; m < lengde; m++) {
			if (m != 0 && m%bs.bredde == 0)
				System.out.printf("+-");
			else
				System.out.printf("-");
		}

		System.out.println();
	}

	public int hentLengde() {
		return lengde;
	}

	public Rute hentRute(int m, int n) {
		return rader[n].hentRute(m);
	}

	public Boks hentBoks(int i) {
		return bokser[i];
	}

	public Rute nesteRute(Rute r) {
		Rad rad = r.hentRad();

		if (r == sisteRuteIBrett())
			return null;
		else if (r == rad.hentRute(lengde-1)) //siste i rad
			return forsteINesteRad(rad);
		else
			return nesteISammeRad(r);
	}

	private Rute sisteRuteIBrett() {
		return rader[lengde-1].hentRute(lengde-1);
	}

	private Rute forsteINesteRad(Rad r) {
		for (int i = 0; i < lengde-1; i++) {
			if (r == rader[i]) {
				return rader[i+1].hentRute(0);
			}
		}

		System.out.println("forsteINesteRad failet");
		return null; //TODO dette skal ikke skje
	}

	private Rute nesteISammeRad(Rute r) {
		Rad rad = r.hentRad();

		for (int i = 0; i < lengde-1; i++) {
			if (r == rad.hentRute(i))
				return rad.hentRute(i+1);
		}

		System.out.println("nesteISammeRad failet");
		return null; //TODO dette skal ikke skje
	}

	public void printLosning() {
		System.out.println();
		//TODO dette duplikerer printBrett()
		for (int i = 0; i < lengde; i++) { //Rader
			for (int j = 0; j < lengde; j++) { //Kolonner
				printChar(j, i);
			}

			System.out.println();
			printHorizontalRule(i);
		}
	}

	public void losBrett(SudokuBeholder sb) {
		this.sb = sb;
		rader[0].hentRute(0).fyllUtDenneRuteOgResten();
		//TODO dette er side effects deluxe
	}

	public int hentBredde() {
		return bs.bredde;
	}

	public int hentHoyde() {
		return bs.hoyde;
	}

	public Rad[] hentRader() {
		return rader;
	}

	public String toString() {
		String str = "";

		for (int i = 0; i < lengde; i++) {
			for (Rute r : rader[i]) {
				int v = r.hentVerdi();
				str += VerdiKonverterer.tilSymbol(v);
			}
			str += "//";
		}

		return str;
	}

	public void leverTilBeholder() {
		sb.settInn(this.toString());
	}

}
