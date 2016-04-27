import java.util.ArrayList;
import java.util.Arrays;

public class Rute {
	private int verdi;
	private Rad rad;
	private Boks boks;
	private Kolonne kolonne;
	private Brett brett;
	private boolean konstant; //gitt fra fil

	public Rute(int verdi, Rad rad) {
		this.verdi = verdi;
		this.rad = rad;

		if (verdi == 0)
			konstant = false;
		else
			konstant = true;
	}

	public void fyllUtDenneRuteOgResten() {
		int[] muligeTall = finnAlleMuligeTall();

		Rute neste = brett.nesteRute(this);
		for (int i = 0; i < muligeTall.length; i++ ) {
			verdi = muligeTall[i];
 
			if (neste == null) { //Siste rute
				brett.leverTilBeholder();
				brett.printLosning(); //TODO ALLE losninger
			} else {
				neste.fyllUtDenneRuteOgResten();
			}
		}

		//TODO before return reset value to 0
		if (!konstant) verdi = 0;
	}

	public void settKolonne(Kolonne kolonne) {
		this.kolonne = kolonne;
	}

	public void settBoks(Boks boks) {
		this.boks = boks;
	}

	public int[] finnAlleMuligeTall() {
		if (verdi != 0) {
			int[] ar = new int[1];
			ar[0] = verdi;
			return ar;
		}

		int[] tall = lovligeTall();

		for (Rute r : rad) {
			//TODO: DRY
			int v = r.hentVerdi();
			if (v != 0)
				tall[v-1] = 0;
		}

		for (Rute r : kolonne) {
			int v = r.hentVerdi();
			if (v != 0)
				tall[v-1] = 0;
		}

		for (Rute r : boks) {
			int v = r.hentVerdi();
			if (v != 0)
				tall[v-1] = 0;
		}

		return fjernNuller(tall);
	}

	public int hentVerdi() {
		return verdi;
	}

	public Boks hentBoks() {
		return boks;
	}

	public Rad hentRad() {
		return rad;
	}

	private int[] lovligeTall() {
		int[] tall = new int[brett.hentLengde()];

		for (int i = 1; i <= brett.hentLengde(); i++) {
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

	public void settBrett(Brett brett) {
		if (this.brett == null)
			this.brett = brett;
	}
}
