import java.util.Scanner;
import java.io.File;

public class Filbehandler {
	private Scanner stdin = new Scanner(System.in);
	private Scanner fs;

	public Brett lesFil() throws Exception {
		File f = new File(hentFilnavn());
		fs = new Scanner(f);

		return lesBrett();
	}

	private String hentFilnavn() {
		System.out.printf("Filnavn: ");
		return stdin.nextLine();
	}

	private Brett lesBrett() throws Exception { //TODO type of exception
		Storrelse bs = lesStorrelse();
		Rad[] r = lesRader();
		return new Brett(bs, r);
	}

	private Storrelse lesStorrelse() throws Exception { //TODO IOException?
		try {
			Storrelse bs = new Storrelse();
			bs.hoyde = Integer.parseInt(fs.next());
			bs.bredde = Integer.parseInt(fs.next());
			return bs;
		} catch (Exception e) {
			throw e;
		}
	}

	private Rad[] lesRader() throws Exception {
		//

		return null; //TODO
	}
}
