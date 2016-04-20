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
			int v = VerdiKonverterer.tallVerdi(linje[j]);
			rad.settInn(v, j);
		}

		return rad;
	}
}
