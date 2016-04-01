import java.util.ArrayList;
import java.util.Arrays;

public class Rute {
	private boolean initialisert;
	private int verdi;
	private Boks boks;
	private Rad rad;
	private Kolonne kolonne;

	public Rute(int verdi, Rad rad) {
		this.verdi = verdi;
		this.rad = rad;
		initialisert = false;
	}

	public void settKolonne(Kolonne kolonne) {
		this.kolonne = kolonne;
		//TODO initialisert bitmap
	}

	public int[] finnAlleMuligeTall() {
		int[] tall = lovligeTall();

		for (Rute r : rad) {
			int v = r.hentVerdi();
			if (v != 0)
				tall[v-1] = 0;
		}

		for (Rute r : kolonne) {
			int v = r.hentVerdi();
			if (v != 0)
				tall[v-1] = 0;
		}

/* TODO
		for (Rute r : boks) {
			int v = r.hentVerdi();
			if (v != 0)
				tall[v-1] = 0;
		}
*/

		return fjernNuller(tall);
	}

	public int hentVerdi() {
		return verdi;
	}

	private int[] lovligeTall() {
		int[] tall = new int[Brett.hentLengde()];

		for (int i = 1; i <= Brett.hentLengde(); i++) {
			tall[i-1] = i;
		}

		return tall;
	}

	private int[] fjernNuller(int[] fra) {
		int[] til = new int[fra.length];

		int i, j;
		for (i = j = 0; i < fra.length; i++) {
			if (fra[i] != 0)
				til[j++] = fra[i];
		}

		return Arrays.copyOfRange(til, 0, j);
	}
}
