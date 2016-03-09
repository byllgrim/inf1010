package oppg6;

// TODO: Vurder Tabell med noe annet enn String

public class TestTabell {
	public static void kjorTester() {
		testSettInnOgHent();
		// testHasNext();
		// testNext();
		testForEach();
	}

	private static void testSettInnOgHent() {
		Tabell<String> tabell = new Tabell<String>(20);

		String s1 = "Hey ho!";
		String s2 = "stringedy";
		String s3 = "Ett, to...";

		tabell.settInn(s1, 0);
		tabell.settInn(s2, 1);
		tabell.settInn(s3, 2);

		if (tabell.hentElement(0) == null)
			System.err.println(	
				"error: Tabell: hentElement gir null");

		if (tabell.hentElement(2).compareTo(s3) != 0)
			System.err.println("error: Tabell: "
				+ "hentElement gir feil element");
	}

/*
	private static void testHasNext() {
		Tabell<String> tabell = new Tabell<String>(20);

		tabell.settInn("Test string", 10);
		if (!tabell.hasNext())
			System.err.println("error: Tabell: "
				+ "hasNext skulle gi true");
	}

	private static void testNext() {
		Tabell<String> tabell = new Tabell<String>(20);

		String s1 = "Tiddely bom";
		String s2 = "hvaskjerabagera";
		tabell.settInn(s1, 10);
		tabell.settInn(s2, 16);

		if (tabell.next().compareTo(s1) != 0)
			System.err.println("error: Tabell: "
				+ "next() fant feil element");

		if (tabell.next().compareTo(s2) != 0)
			System.err.println("error: Tabell: "
				+ "next() fant feil element");
	}
*/

	private static void testForEach() {
		Tabell<String> t = new Tabell<String>(10);

		String s1 = "Hey ho!";
		String s2 = "stringedy";
		String s3 = "Ett, to...";

		t.settInn(s1, 0);
		t.settInn(s2, 1);
		t.settInn(s3, 2);

		for (String s : t) {
			t.hentElement(0);
		}
	}
}
