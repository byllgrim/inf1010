import java.util.ArrayList;

public class Rute {
	private int verdi; //public?
	private Boks boks;
	private Rad rad;
	private Kolonne kolonne;
	private boolean initialisert;

	public Rute(int verdi, Rad rad) {
		this.verdi = verdi;
		this.rad = rad;
		initialisert = false;
	}

	public int[] finnAlleMuligeTall() {
		//TODO: start med 0 til n. fjern if fins i kolonne, rad, boks
		ArrayList<Integer> tall = lovligeTall();

		return null;
	}

	private ArrayList<Integer> lovligeTall() {
		ArrayList<Integer> tall = new ArrayList<>();

		for (int i = 1; i <= Brett.hentLengde(); i++) {
			tall.add(i);
		}

		return tall;
	}

	public int hentVerdi() {
		return verdi;
	}
}
