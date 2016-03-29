package oppg7;

import oppg4.*;
import oppg6.*;
import java.io.*;
import java.util.Scanner;

public class Filleser {
	private Database database;
	private Scanner fs;

	public Filleser(Database database) {
		this.database = database;
	}

	public boolean lesFil(String filnavn) {
                System.out.println("Filleser lesFil(" + filnavn + ")");

		try {
			fs = new Scanner(new File(filnavn));
		} catch (FileNotFoundException e) {
			System.out.println("Fant ingen slik fil.");
			return false;
		} catch (Exception e) {
			//TODO: specific exception
			e.printStackTrace();
			return false;
		}

		lesPasienter();
		lesLegemidler();
		lesLeger();
		lesResepter();
		return true;
	}

	private void lesPasienter() {
		String[] args = getArgs();
		if (args == null)
			return;

		for (String s : args) System.out.println(s);
		//database.leggTilPasient(args[0], args[1], args[2], args[3]);
	}

	private void lesLegemidler() {
		if (noScanner()) return;
		//TODO
	}

	private void lesLeger() {
		if (noScanner()) return;
		//TODO
	}

	private void lesResepter() {
		if (noScanner()) return;
		//TODO
	}

	private boolean noScanner() {
		return (fs == null);
	}

	private String[] getArgs() {
		if (noScanner())
			return null;

		fs.nextLine(); //Fjern kommentaren

		//TODO
		return null;
	}
}
