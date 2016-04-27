public class TestBrett {
	private static Brett brett;

	public static void main(String[] args) {
		try {
			Filbehandler f1 = new Filbehandler();
			brett = f1.lesFil("spill-1");

			testNesteRute();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private static void testNesteRute() {
		System.out.println("testNesteRute()");

		Rute r = brett.hentRute(0, 0);
		int lengde = brett.hentLengde();
		int[] verdier = new int[lengde*lengde];
		for (int i = 0; r != null; i++) {
			verdier[i] = r.hentVerdi();
			r = brett.nesteRute(r);
		}

		int[] fasit = {0, 0, 3, 6, 0, 0,
		               0, 2, 0, 0, 0, 4,
		               5, 0, 0, 0, 6, 0,
		               0, 3, 0, 0, 0, 5,
		               3, 0, 0, 0, 1, 0,
		               0, 0, 1, 4, 0, 0};
		for (int i = 0; i < verdier.length; i++) {
			if (verdier[i] != fasit[i]) {
				System.err.println("error");
				break;
			}
		}
	}
}
