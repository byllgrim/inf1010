package oppg6;

import oppg4.Lege;

public class TestSortertEnkelListe {
	public static void kjorTester() {
		testErTom();
		testSettInn();
		testHentElement();
		// testHasNext();
		// testNext();
	}

	private static void testErTom() {
		SortertEnkelListe<Lege> liste;
		liste = new SortertEnkelListe<>();

		if (!liste.erTom())
			System.err.println("error: SortertEnkelListe: "
				+ "listen skulle vaere tom");

		Lege ingvar = new Lege("Ingvar");
		liste.settInn(ingvar, "ing");
		if (liste.erTom())
			System.err.println("error: SortertEnkelListe: "
				+ "Listen skulle ikke være tom");
	}

	private static void testSettInn() {
		SortertEnkelListe<Lege> liste;
		liste = new SortertEnkelListe<>();

		liste.settInn(new Lege("Asbjoern"), "asb");
		liste.settInn(new Lege("Bjarnmoen"), "bjm");
		liste.settInn(new Lege("Cholesterola"), "chl");
		liste.settInn(new Lege("Farenwatt"), "frw");
		liste.settInn(new Lege("Elfenslange"), "elf");
		liste.settInn(new Lege("De Meyer"), "dmy");
	}

	private static void testHentElement() {
		SortertEnkelListe<Lege> liste;
		liste = new SortertEnkelListe<>();

		liste.settInn(new Lege("Bjarnmoen"), "bjm");
		liste.settInn(new Lege("Cholesterola"), "chl");
		liste.settInn(new Lege("Farenwatt"), "frw");

		Lege hentet = liste.hentElement("chl");
		if (!hentet.samme("Cholesterola"))
			System.err.println("error: SortertEnkelListe: "
				+ "hentElement fant feil Lege");

		hentet = liste.hentElement("bjm");
		if (!hentet.samme("Bjarnmoen"))
			System.err.println("error: SortertEnkelListe: "
				+ "hentElement fant feil Lege");

		hentet = liste.hentElement("frw");
		if (!hentet.samme("Farenwatt"))
			System.err.println("error: SortertEnkelListe: "
				+ "hentElement fant feil Lege");
	}

	/* private static void testHasNext() {
		SortertEnkelListe<Lege> liste;
		liste = new SortertEnkelListe<>();

		if (liste.hasNext())
			System.err.println("error: SortertEnkelListe: "
				+ "hasNext() skulle vaere false");

		liste.settInn(new Lege("Bjarnmoen"), "bjm");
		liste.settInn(new Lege("Cholesterola"), "chl");
		liste.settInn(new Lege("Farenwatt"), "frw");

		if (!liste.hasNext())
			System.err.println("error: SortertEnkelListe: "
				+ "hasNext() skulle vaere true");
	}

	private static void testNext() {
		SortertEnkelListe<Lege> liste;
		liste = new SortertEnkelListe<>();

		if (liste.next() != null)
			System.err.println("error: SortertEnkelListe: "
				+ "next() skulle gi null");

		liste.settInn(new Lege("A"), "a");
		liste.settInn(new Lege("C"), "c");
		liste.settInn(new Lege("B"), "b");

		liste.next();
		liste.next();
		if (!liste.next().samme("C"))
			System.err.println("error: SortertEnkelListe: "
				+ "next() skulle gi laveste element");
	} */
}
