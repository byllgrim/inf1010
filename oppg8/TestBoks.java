public class TestBoks {
	private static Brett brett;

	public static void main(String[] args) {
		try {
			Filbehandler f1 = new Filbehandler();
			brett = f1.lesFil("spill-1");

			test1BoksRute00();
			test1BoksRute32();
			test1BoksRute24();
			test1BoksRute35();

			Filbehandler f2 = new Filbehandler();
			brett = f2.lesFil("spill-2");

			test2BoksRute00();
			test2BoksRute88();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private static void test1BoksRute00() {
		System.out.println("test1BoksRute00()");
		Rute r = brett.hentRute(0, 0);
		Boks b = brett.hentBoks(0);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void test1BoksRute32() {
		System.out.println("test1BoksRute32()");
		Rute r = brett.hentRute(3, 2);
		Boks b = brett.hentBoks(3);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void test1BoksRute24() {
		System.out.println("test1BoksRute24()");
		Rute r = brett.hentRute(2, 4);
		Boks b = brett.hentBoks(4);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void test1BoksRute35() {
		System.out.println("test1BoksRute35()");
		Rute r = brett.hentRute(3, 5);
		Boks b = brett.hentBoks(5);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void test2BoksRute00() {
		System.out.println("test2BoksRute00()");
		Rute r = brett.hentRute(0, 0);
		Boks b = brett.hentBoks(0);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}

	private static void test2BoksRute88() {
		System.out.println("test2BoksRute88()");
		Rute r = brett.hentRute(8, 8);
		Boks b = brett.hentBoks(8);

		if (r.hentBoks() != b) {
			System.err.println("Mismatch mellom rute og boks.");
		}
	}
}
