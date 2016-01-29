public class HylleTest {
	public static void main(String[] args) {
		HylleTest hylletest = new HylleTest();

		hylletest.testLedig();
		hylletest.testFeilplassering();
		hylletest.testStorrelse();
		hylletest.testBrukte();
	}

	/*
	 * Jeg valgte aa lage nye bokhyller i hver metode
	 * for aa vaere sikker pa at ingenting 'henger igjen'
	 * og forstyrrer logikken. Det er for enkel forstaaelse.
	 */
	public void testLedig() {
		Hylle<Bok> bokhylle = new Hylle<>(100);
		Bok kalk = new Bok("Kalkulus", "T. Lindstrom");

		if (!bokhylle.erLedig(0)) {
			System.err.println("testLedig: ny hylle ikke-tom");
		}

		bokhylle.settInn(kalk, 0);
		if (bokhylle.erLedig(0)) {
			System.err.println("testLedig: bok tar ikke plass");
		}

		bokhylle.taUt(0);
		if (!bokhylle.erLedig(0)) {
			System.err.println("testLedig: bok ikke fjernet");
		}
	}

	public void testFeilplassering() {
		Hylle<Bok> bokhylle = new Hylle<>(100);
		Bok sicp = new Bok("Structure and Interpretation of"
		                   + "Computer Programs", "Wizards");

		if (bokhylle.settInn(sicp, 105)) {
			System.err.println("testFeilplassering: "
			                   + "skulle ikke ha tilgang");
		}
	}

	public void testStorrelse() {
		Hylle<Bok> bokhylle = new Hylle<>(100);

		if (bokhylle.storrelse() != 100) {
			System.err.println("testStorrelse: feil storrelse");
		}
	}

	public void testBrukte() {
		Hylle<Bok> bokhylle = new Hylle<>(100);
		Bok C = new Bok("The C Programming Language", "K&R");
		Bok bible = new Bok("The Holy Bible", "Sweet Potato");

		bokhylle.settInn(C, 0);
		bokhylle.settInn(bible, 1);

		if (bokhylle.hentBruktePlasser() != 2) {
			System.err.println("hentBruktePlasser: "
			                   + "settInn adder ikke opp.");
		}

		bokhylle.taUt(0);
		if (bokhylle.hentBruktePlasser() != 1) {
			System.err.println("HentBruktePlasser: "
			                   + "taUt fjerner ikke.");
		}
	}
}
