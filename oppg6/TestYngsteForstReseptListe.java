package oppg6;

import oppg4.Resept;

public class TestYngsteForstReseptListe {
	public static void kjorTester() {
		//testNext();
		testForEach();
	}

	/*
	private static void testNext() {
		YngsteForstReseptListe liste = new YngsteForstReseptListe();

		Resept r1 = new Resept(null, "lege1", 1, 6);
		Resept r2 = new Resept(null, "lege2", 2, 6);
		Resept r3 = new Resept(null, "lege3", 3, 6);
		liste.settInn(r1);
		liste.settInn(r2);
		liste.settInn(r3);

		String hentetLege = liste.next().hentLege();
		if (!hentetLege.equals("lege3"))
			System.err.println("error: YngsteForstReseptListe:"
			                   + "skulle faa den yngste lege");
	} */

	private static void testForEach() {
		YngsteForstReseptListe l = new YngsteForstReseptListe();

		Resept r1 = new Resept(null, "lege1", 1, 6);
		Resept r2 = new Resept(null, "lege2", 2, 6);
		Resept r3 = new Resept(null, "lege3", 3, 6);
		l.settInn(r1);
		l.settInn(r2);
		l.settInn(r3);

		for (Resept r : l) {
			l.erTom();
		}
	}
}
