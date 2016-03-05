package oppg6;

public class TestOppg6 {
	public static void main(String[] args) {
		TestTabell.kjorTester();
		TestSortertEnkelListe.kjorTester();
		TestEldsteForstReseptListe.kjorTester();
		/*
		 * NB! kjoer Eldste foer Yngste pga Resept counter.
		 * Alternativt: Ha egen main i hver enhetstest.
		 */
		TestYngsteForstReseptListe.kjorTester(); // TODO
	}
}
