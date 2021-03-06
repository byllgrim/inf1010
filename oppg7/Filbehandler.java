package oppg7;

import oppg4.*;
import oppg6.*;
import java.io.*;
import java.util.Scanner;

public class Filbehandler {
	//TODO: could have enum for state. safety of lesXXX
	private Database database;
	private Scanner fs;
	private BufferedWriter bw;

	public Filbehandler(Database database) {
		this.database = database;
	}

	public void skrivFil(String filnavn) {
		try {
			File file = new File(filnavn);
			if (!file.exists())
				file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO
		}

		try {
			skrivPasienter();
			skrivLegemidler();
			skrivLeger();
			skrivResepter();
			bw.write("# Slutt");
			bw.close();
		} catch (Exception e) {
			System.out.println("Kunne ikke skrive til fil.");
		}
	}

	private void skrivPasienter() throws Exception {
		if (noWriter()) throw new NoWriterException();

		bw.write("# Personer (nr, navn, fnr, adresse, postnr)\n");
		for (Pasient p : database.hentPasienter()) {
			bw.write(p.info());
			bw.write("\n");
		}

		bw.write("\n");
	}

	private void skrivLegemidler() throws Exception {
		if (noWriter()) throw new NoWriterException();

		bw.write("# Legemidler (nr, navn, form, type, pris, "
		         + "antall/mengde, virkestoff [, styrke])\n");
		for (Legemiddel lm : database.hentLegemidler()) {
			bw.write(lm.info());
			bw.write("\n");
		}

		bw.write("\n");
	}

	private void skrivLeger() throws Exception {
		if (noWriter()) throw new NoWriterException();

		bw.write("# Leger (navn, avtalenr / 0 hvis ingen avtale)\n");
		for (Lege l : database.hentLeger()) {
			bw.write(l.info());
			bw.write("\n");
		}

		bw.write("\n");
	}

	private void skrivResepter() throws Exception {
		if (noWriter()) throw new NoWriterException();

		bw.write("# Resepter (nr, hvit/blå, persNummer, legeNavn, "
		         + "legemiddelNummer, reit)\n");
		for (Resept r : database.hentResepter()) {
			bw.write(r.info());
			bw.write("\n");
		}

		bw.write("\n");
	}

	private boolean noWriter() {
		return (bw == null);
	}


	public boolean lesFil(String filnavn) {
		try {
			fs = new Scanner(new File(filnavn));
		} catch (FileNotFoundException e) {
			System.err.println("Fant ingen slik fil.");
			return false;
		} catch (Exception e) {
			//TODO: specific exception
			return false;
		}

		try {
			lesPasienter();
			lesLegemidler();
			lesLeger();
			lesResepter();
		} catch (NoScannerException e) {
			System.err.println("Scanner er uinitialisert");
			return false;
		} catch (Exception e) {
			System.err.println("Kunne ikke lese fil.");
			e.printStackTrace();
			return false;
		} finally {
			fs.close();
			//fs = null?
			return true;
		}
	}

	private void lesPasienter() throws Exception {
		String[] args = getArgs();

		for (; !args[0].equals(""); args = getArgs()) {
			if (args[0].contains("#")) continue;
			database.leggTilPasient(args[1], args[2],
			                        args[3], args[4]);
		}
	}

	private void lesLegemidler() throws Exception {
		String[] args = getArgs();

		for (; !args[0].equals(""); args = getArgs()) {
			if (args[0].contains("#")) continue;
			if (args.length < 8)
				database.leggTilLegemiddel(args[1], args[2],
				                           args[3], args[4],
				                           args[5], args[6],
				                           "0");
			else
				database.leggTilLegemiddel(args[1], args[2],
				                           args[3], args[4],
				                           args[5], args[6],
			                                   args[7]);
			//TODO: this is stupid
		}
	}

	private void lesLeger() throws Exception {
		String[] args = getArgs();

		for (; !args[0].equals(""); args = getArgs()) {
			if (args[0].contains("#")) continue;
			String key = (args[0]+args[1]);
			Integer ikey = new Integer(key.hashCode());
			database.leggTilLege(args[0], ikey.toString());
		}
	}

	private void lesResepter() throws Exception {
		String[] args = getArgs();

		for (; !args[0].equals(""); args = getArgs()) {
			if (args[0].contains("#")) continue;
			database.leggTilResept(args[1], args[2],
			                       args[3], args[4], args[5]);
		}
	}

	private boolean noScanner() {
		return (fs == null);
	}

	private String[] getArgs() throws NoScannerException {
		if (noScanner()) throw new NoScannerException("Ingen Scanner");

		String line = fs.nextLine();
		return line.split(", ");
	}
}

class NoScannerException extends IOException {
	NoScannerException(String s) {
		super(s);
	}
}

class NoWriterException extends IOException {
	NoWriterException() {
		super("NoWriter");
	}

	NoWriterException(String s) {
		super(s);
	}
}
