//TODO Alle disse static metodene er for aa spare Rute for Brett-peker

public class Brett {
	private static Storrelse bs;
	private static Boks[] bokser;
	private static Rad[] rader;
	private static Kolonne[] kolonner;

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
		for (int i = 0; i < lengde; i++) { //Rader
			for (int j = 0; j < lengde; j++) { //Kolonner
				printChar(j, i);
			}

			System.out.println();
			printHorizontalRule(i);
		}
	}

	private static void printChar(int m, int n) {
		if (m != 0 && m%bs.bredde == 0)
			System.out.printf("|");

		int v = rader[n].hentRute(m).hentVerdi();

		if (v == 0)
			System.out.printf(" ");
		else
			System.out.printf("%d", v);
	}

	private static void printHorizontalRule(int n) {
		n++;
		if (n == 1 || n%bs.hoyde != 0 || n == lengde)
			return;

		for (int m = 0; m < lengde; m++) {
			if (m != 0 && m%bs.bredde == 0)
				System.out.printf("+");
			else
				System.out.printf("-");
		}

		System.out.println("-");
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

	public static Rute nesteRute(Rute r) {
		Rad rad = r.hentRad();

		if (r == sisteTommeRuteIBrett()) {
			System.out.println("Siste rute");
			return null; //Siste Rute
		} else if (r == rad.sisteTommeRute()) {
			return forsteINesteRad(rad);
		} else {
			return nesteISammeRad(r);
		}
	}

	private static Rute sisteTommeRuteIBrett() {
		for (int i = lengde-1; i >= 0; i--) {
			for (int j = lengde-1; j >= 0; j--) {
				Rute r = rader[i].hentRute(j);
				if (r.hentVerdi() == 0)
					return r;
			}
		}

		//TODO hva om alt er tomt?
		return null;
	}

	private static Rute forsteINesteRad(Rad r) {
		for (int i = 0; i < lengde-1; i++) {
			if (r == rader[i])
				return rader[i+1].forsteTommeRute();
		}

		return null; //TODO dette skal ikke skje
	}

	private static Rute nesteISammeRad(Rute r) {
		//TODO neste TOMME rute
		Rad rad = r.hentRad();

		for (int i = 0; i < lengde-1; i++) {
			if (r == rad.hentRute(i))
				return rad.hentRute(i+1);
		}

		return null; //TODO dette skal ikke skje
	}

	public static void printLosning() {
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

	public void losBrett() {
		rader[0].hentRute(0).fyllUtDenneRuteOgResten();
	}
}
