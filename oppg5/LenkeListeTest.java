public class LenkeListeTest {
	public static void main(String[] args) {
		testLeggTilOgFjern();
		testErTom();
		testInneholder();
	}

	private static void testLeggTilOgFjern() {
		LenkeListe<String> l = new LenkeListe<>();

		l.leggTil("A");
		l.leggTil("C");
		l.leggTil("D");
		l.leggTil("B");
		l.leggTil("E");

		String output = l.fjernMinste() + l.fjernMinste()
		                + l.fjernMinste() + l.fjernMinste()
		                + l.fjernMinste();

		if (!output.equals("ABCDE"))
			System.err.println("error: testLeggTilOgFjern: "
			                   + "ulikhet");
	}

	private static void testErTom() {
		LenkeListe<String> l = new LenkeListe<>();

		if (!l.erTom())
			System.err.println("error: testErTom: ikketom");

		l.leggTil("A");
		if (l.erTom())
			System.err.println("error: testErTom: tom");
	}

	private static void testInneholder() {
		LenkeListe<String> l = new LenkeListe<>();

		l.leggTil("A");
		if (!l.inneholder("A"))
			System.err.println("error: testErTom: mangler A");

		l.fjernMinste();
		if (l.inneholder("A"))
			System.err.println("error: testErTom: A for mye");
	}
}
