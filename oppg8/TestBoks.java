public class TestBoks {
	private static Brett brett;

	public static void main(String[] args) {
		Filbehandler fb = new Filbehandler();
		brett = fb.lesFil("spill-1");

		testBoksRute00();
		testBoksRute32();
		testBoksRute24();
		testBoksRute35();
	}

	private static void testBoksRute00() {
		System.out.println("testBoksRute00()");
		Rute r = brett.hentRute(0, 0);
		Boks b = brett.hentBoks(0);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void testBoksRute32() {
		System.out.println("testBoksRute32()");
		Rute r = brett.hentRute(3, 2);
		Boks b = brett.hentBoks(3);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void testBoksRute24() {
		System.out.println("testBoksRute24()");
		Rute r = brett.hentRute(2, 4);
		Boks b = brett.hentBoks(4);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void testBoksRute35() {
		System.out.println("testBoksRute35()");
		Rute r = brett.hentRute(3, 5);
		Boks b = brett.hentBoks(5);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}
}
