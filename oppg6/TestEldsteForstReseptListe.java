package oppg6;

import oppg4.Resept;

public class TestEldsteForstReseptListe {
	public static void kjorTester() {
		testFinnResept(); // NB! maa kjoeres foerst pga Resept counter
		testErTom();
		// testNext();
		// TODO
	}

	private static void testErTom() {
		EldsteForstReseptListe liste = new EldsteForstReseptListe();

		if (!liste.erTom())
			System.err.println("error: EldsteForstReseptListe: "
			                   + "skulle være tom");

		Resept r = new Resept(null, "legeperson", 0, 3);
		liste.settInn(r);
		if (liste.erTom())
			System.err.println("error: EldsteForstReseptListe: "
			                   + "skulle ikke være tom");
	}

	/*
	private static void testNext() {
		EldsteForstReseptListe liste = new EldsteForstReseptListe();

		Resept r1 = new Resept(null, "lege1", "pasient1", 6);
		Resept r2 = new Resept(null, "lege2", "pasient2", 6);
		Resept r3 = new Resept(null, "lege3", "pasient3", 6);
		liste.settInn(r1);
		liste.settInn(r2);
		liste.settInn(r3);

		String hentetLege = liste.next().hentLege();
		if (!hentetLege.equals("lege1"))
			System.err.println("error: EldsteForstReseptListe:"
			                   + "skulle faa den eldste lege");
	} */

	private static void testFinnResept() {
		EldsteForstReseptListe liste = new EldsteForstReseptListe();

		Resept r1 = new Resept(null, "lege1", 1, 6);
		Resept r2 = new Resept(null, "lege2", 2, 6);
		Resept r3 = new Resept(null, "lege3", 3, 6);
		liste.settInn(r1);
		liste.settInn(r2);
		liste.settInn(r3);

		try {
			liste.finnResept(1);
		} catch (Exception e) {
			System.err.println("error: TestEldsteForstReseptListe "
			                   + "finnResept failet");
			e.printStackTrace();
		}
	}
}
