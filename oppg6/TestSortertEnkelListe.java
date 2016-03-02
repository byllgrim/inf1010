package oppg6;

import oppg4.Lege;

public class TestSortertEnkelListe {
	public static void kjorTester() {
		testErTom();
		// TODO
	}

	private static void testErTom() {
		SortertEnkelListe<Lege> liste;
		liste = new SortertEnkelListe<>();

		if (!liste.erTom())
			System.err.println("error: SortertEnkelListe: "
				+ "listen skulle vaere tom");

		Lege ingvar = new Lege("Ingvar");
		//liste.settInn(new Lege("Ingvar"), "ing");
	}
}
