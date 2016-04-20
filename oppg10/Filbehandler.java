import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//NB: Bryter SRP med lesing av fil og tolking av rader, storrelser osv.
public class Filbehandler {
	private Scanner fs;

	public Brett lesFil(String filnavn) throws RuntimeException,
	                                           FileNotFoundException
	                                           //TODO: consider custom
	{
		Brett b;

		File f = new File(filnavn);
		fs = new Scanner(f);
		return lesBrett();
	}

	private Brett lesBrett() throws RuntimeException {
		Storrelse bs = lesStorrelse();
		Rad[] r = lesRader(bs.bredde * bs.hoyde);
		return new Brett(bs, r);
	}

	private Storrelse lesStorrelse() throws RuntimeException {
		Storrelse bs = new Storrelse();
		bs.hoyde = Integer.parseInt(fs.nextLine());
		bs.bredde = Integer.parseInt(fs.nextLine());
		return bs;
	}

	private Rad[] lesRader(int lengde) throws RuntimeException {
		Rad[] rader = new Rad[lengde];

		for (int i = 0; i < lengde; i++) {
			rader[i] = lesRad(lengde);
		}

		if (fs.hasNext()) //TODO: consider hasNextLine
			throw new RuntimeException("For stort brett");

		return rader;
	}

	private Rad lesRad(int lengde) throws RuntimeException {
		Rad rad = new Rad(lengde);

		char[] linje = fs.nextLine().toCharArray();

		if (linje.length != lengde)
			throw new RuntimeException("Feil antall tegn i linje");

		for (int j = 0; j < lengde; j++) {
			int v = tallVerdi(linje[j]);
			rad.settInn(v, j);
		}

		return rad;
	}

	private int tallVerdi(char c) throws RuntimeException {
		int v = -1;

		switch (c) {
		case '#':
			v = 37;
			break;
		case '&':
			v = 38;
			break;
		case '.':
			v = 0;
			break;
		case '@':
			v = 36;
		}

		if (48 < c && c < 58)     /* 1-9 */
			v = (c - 48);
		if (64 < c && c < 91)     /* A-Z */
			v = (c - 55);
		if (96 < c && c < 123)    /* a-z */
			v = (c - 58);

		if (v == -1)
			throw new RuntimeException("Ugyldig tegn");
		if (!lovligIntervall(v))
			throw new RuntimeException("Ulovlig intervall");
		else
			return v;
	}

	private boolean lovligIntervall(int i) {
		return ((i >= 0 && i <= 64) || i == 0);
	}
}

/*
class UlovligIntervallException extends RuntimeException {
	Trengs ikke fordi den ikke gjor noe spesielt
}
*/
