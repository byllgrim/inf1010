import java.util.Arrays;
import java.io.File;

public class TestRute {
	private static Brett brett;

	public static void main(String[] args) {
		try {
			Filbehandler fb1 = new Filbehandler();
			brett = fb1.lesFil(new File("spill-1"));

			test1LosningRute00();
			test1LosningRute41();
			test1LosningRute33();
			test1LosningRute52();

			Filbehandler fb2 = new Filbehandler();
			brett = fb2.lesFil(new File("spill-2"));

			test2LosningRute00();
			test2LosningRute58();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private static void test1LosningRute00() {
		System.out.println("test1LosningRute00()");
		Rute r = brett.hentRute(0, 0);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {1, 4};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void test1LosningRute41() {
		System.out.println("test1LosningRute41()");
		Rute r = brett.hentRute(4, 1);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {3, 5};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void test1LosningRute33() {
		System.out.println("test1LosningRute33()");
		Rute r = brett.hentRute(3, 3);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {1, 2};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void test1LosningRute52() {
		System.out.println("test1LosningRute52()");
		Rute r = brett.hentRute(5, 2);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {1, 2, 3};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void test2LosningRute00() {
		System.out.println("test2LosningRute00()");
		Rute r = brett.hentRute(0, 0);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {2, 3, 4, 7, 8, 9};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}

	private static void test2LosningRute58() {
		System.out.println("test2LosningRute58()");
		Rute r = brett.hentRute(5, 8);
		int[] svar = r.finnAlleMuligeTall();
		int[] fasit = {2, 3, 4, 5, 8};
		if (!Arrays.equals(svar, fasit)) {
			System.out.println("Error");
		}
	}
}
