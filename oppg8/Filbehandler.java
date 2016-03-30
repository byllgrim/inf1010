import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//TODO: Bryter SRP med lesing av fil og tolking av rader, storrelser osv.
public class Filbehandler {
	private Scanner stdin = new Scanner(System.in);
	private Scanner fs;

	public Brett lesFil() {
		Brett b;

		try {
			File f = new File(hentFilnavn());
			fs = new Scanner(f);
			b = lesBrett();
		} catch (FileNotFoundException e) {
			System.out.println("Angitt filnavn eksisterer ikke");
			b = null;
		} catch (Exception e) {
			System.out.println("Ukjent feil");
			e.printStackTrace();
			b = null;
		}

		return b;
	}

	private String hentFilnavn() {
		System.out.printf("Filnavn: ");
		return stdin.nextLine();
		//TODO: gis fra cmd?
	}

	private Brett lesBrett() throws Exception { //TODO type of exception
		Storrelse bs = lesStorrelse();
		Rad[] r = lesRader(bs.bredde * bs.hoyde);
		return new Brett(bs, r);
	}

	private Storrelse lesStorrelse() throws Exception {
		Storrelse bs = new Storrelse();
		bs.hoyde = Integer.parseInt(fs.nextLine());
		bs.bredde = Integer.parseInt(fs.nextLine());
		//TODO: tallVerdi()?
		return bs;
	}

	private Rad[] lesRader(int lengde) throws Exception {
		Rad[] rader = new Rad[lengde];

		for (int i = 0; i < lengde; i++) {
			rader[i] = lesRad(lengde);
		}

		//TODO: "For stort brett"
		return rader;
	}

	private Rad lesRad(int lengde) throws Exception {
		Rad rad = new Rad(lengde);

		char[] linje = fs.nextLine().toCharArray();
		//TODO: "Antall tegn stemmer ikke"
		for (int j = 0; j < lengde; j++) {
			int v = tallVerdi(linje[j]);
			rad.settInn(v, j);
		}

		return rad;
	}

	private int tallVerdi(char c) throws Exception {
		int v = -1;

		switch (c) {
		case '#':
			v = 37;
		case '&':
			v = 38;
		case '.':
			v = 0;
		case '@':
			v = 36;
		}

		if (48 < c && c < 58)     /* 1-9 */
			v = (c - 48);
		if (64 < c && c < 91)     /* A-Z */
			v = (c - 55);
		if (98 < c && c < 123)    /* a-z */
			v = (c - 58);

		if (v == -1)
			throw new Exception("TODO: Ugyldig tegn i filen");
		if (!lovligIntervall(v))
			throw new Exception("TODO: Utenfor lovlig intervall");
		else
			return v;
	}

	private boolean lovligIntervall(int i) {
		return ((i >= 0 && i <= 64) || i == 0);
	}
}
