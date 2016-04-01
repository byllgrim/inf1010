import java.util.Arrays;

public class TestRute {
	private static Brett brett;

	public static void main(String[] args) {
		Filbehandler fb = new Filbehandler();
		brett = fb.lesFil("spill-1");

		testLosningRute00();
		testLosningRute41();
		testLosningRute33();
		testLosningRute52();
	}

	private static void testLosningRute00() {
		System.out.println("testLosningRute00()");
		Rute r = brett.hentRute(0, 0);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {1, 4};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void testLosningRute41() {
		System.out.println("testLosningRute41()");
		Rute r = brett.hentRute(4, 1);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {3, 5};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void testLosningRute33() {
		System.out.println("testLosningRute33()");
		Rute r = brett.hentRute(3, 3);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {1, 2};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void testLosningRute52() {
		System.out.println("testLosningRute52()");
		Rute r = brett.hentRute(5, 2);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {1, 2, 3};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}
}
