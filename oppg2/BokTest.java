public class BokTest {
	public static void main(String[] args) {
		BokTest bokTest = new BokTest();

		bokTest.testTittel();
		bokTest.testUtlaan();
		bokTest.laanIgjen();
	}

	private void testTittel() {
		Bok moby = new Bok("Moby Dick", "Herman Melville");
		if (!moby.hentTittel().equals("Moby Dick")) {
			System.err.println("Bug in Bok.hentTittel()");
		}
	}

	private void testUtlaan() {
		Bok mice = new Bok("Of Mice and Men", "John Steinbeck");
		if (!mice.laanUtTil("Alfons Aberg")) {
			System.err.println("Bok.laanUtTil() ga ingenting");
		} else if (mice.laanUtTil("Mick Jagger")) {
			System.err.println("Bok.laanUtTil() for mye");
		}
	}

	private void laanIgjen() {
		Bok hp = new Bok("Happy Rotter", "J. K. Rafting");
		hp.laanUtTil("gfm");
		hp.leverTilbake();

		if (!hp.laanUtTil("Porry Hatter")) {
			System.err.println("Bok.leverTilbake failet");
		}
	}
}
