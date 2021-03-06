package oppg7;

import java.util.Scanner;

public class KommandoParser {
	private static Scanner stdin = new Scanner(System.in);
	private Database database;
	private String filnavn;

	public KommandoParser(Database db) {
		database = db;
	}

	public void behandleNesteKommando() {
		String input = lowercaseInput(">> ");
		if (input.length() != 1)
			input = "0";

		utfoerKommando(input.charAt(0));
	}

	private String hentInput(String prompt) {
		System.out.printf(prompt);
		return stdin.nextLine();
	}

	private String lowercaseInput(String prompt) {
		return hentInput(prompt).toLowerCase();
	}

	private void utfoerKommando(char cmd) {
		String lege, pasient;

		switch (cmd) {
		case 'r':
			lesFil();
			break;
		case 'w':
			skrivFil();
			break;
		case 'p':
			database.listPasienter();
			break;
		case 'l':
			database.listLeger();
			break;
		case 'm':
			database.listLegemidler();
			break;
		case 's':
			database.listResepter();
			break;
		case 'x':
			leggTilLegemiddel();
			break;
		case 'y':
			leggTilLege();
			break;
		case 'z':
			leggTilPasient();
			break;
		case 'u':
			leggTilResept();
			break;
		case 'a':
			database.printLmTilResept(hentInput("ReseptNr: "));
			break;
		case 'b':
			database.printVanedannendeOslo();
			break;
		case 'c':
			String psnr = lowercaseInput("pasientNr: ");
			database.printPasientsBlaa(psnr);
			break;
		case 'd':
			lege = hentInput("Leges navn: ");
			database.printLegesMiksturer(lege);
			break;
		case 'e':
			lege = hentInput("Leges navn: ");
			database.printLegesVirkestoff(lege);
			break;
		case 'f':
			lege = hentInput("Leges navn: ");
			database.printLegesNarkotiske(lege);
			break;
		case 'g':
			pasient = hentInput("Pasients navn: ");
			database.printPasientsNarkotiske(pasient);
			break;
		case 'h':
			printKommandoer();
			break;
		case 'q':
			Main.avslutt();
			break;
		default:
			System.out.println("Skriv h for hjelp");
		}
	}

	private void lesFil() {
		filnavn = hentInput("Filnavn: ");
		database.lesFil(filnavn);
	}

	private void skrivFil() {
		String tmp;

		if (filnavn == null || filnavn.equals("")) {
			filnavn = hentInput("Filnavn: ");
		} else {
			tmp = hentInput("Filnavn[" + filnavn + "]: ");
			if (!tmp.equals(""))
				filnavn = tmp;
		}

		database.skrivFil(filnavn);
	}

	private void leggTilLegemiddel() {
		System.out.println("[Type C? Styrke skal være 0]");

		String navn = lowercaseInput("Navn: ");
		String form = lowercaseInput("Pille/Mikstur: ");
		String type = lowercaseInput("A, B, C: ");
		String pris = lowercaseInput("Pris: ");
		String mengde = lowercaseInput("Mengde: ");
		String stoff = lowercaseInput("Virkestoff: ");
		String styrke = lowercaseInput("Styrke: ");

		database.leggTilLegemiddel(navn, form, type, pris,
		                           mengde, stoff, styrke);
	}

	private void leggTilLege() {
		//TODO: fastlege?
		String navn = lowercaseInput("Navn: ");
		String nokkel = lowercaseInput("Nokkel: ");

		database.leggTilLege(navn, nokkel);
	}

	private void leggTilPasient() {
		String navn = lowercaseInput("Navn: ");
		String fnr = lowercaseInput("Foedselsnummer: ");
		String adr = lowercaseInput("Addresse: ");
		String postnr = lowercaseInput("Postnummer: ");

		database.leggTilPasient(navn, fnr, adr, postnr);
	}

	private void leggTilResept() {
		String farge = lowercaseInput("Hvit/Blå: ");
		String prsnr = lowercaseInput("PasientNummer: ");
		String lege = lowercaseInput("LegeNavn: ");
		String lmnr = lowercaseInput("LegemiddelNummer: ");
		String reit = lowercaseInput("Reit: ");

		database.leggTilResept(farge, prsnr, lege, lmnr, reit);
	}

	private void printKommandoer() {
		System.out.printf(
			"  DATAFIL\n"
			+"   r   Les fra fil\n"
			+"   w   Skriv til fil\n"
			+"\n"
			+"  LIST\n"
			+"   p   List alle pasienter\n"
			+"   l   List alle leger (sortert etter navn)\n"
			+"   m   List alle legemidler\n"
			+"   s   List alle resepter\n"
			+"\n"
			+"  LEGG TIL\n"
			+"   x   Legg til legemiddel\n"
			+"   y   Legg til lege\n"
			+"   z   Legg til pasient\n"
			+"   u   Legg til resept\n"
			+"\n"
			+"  STATISTIKK\n"
			+"   a   Hent legemiddel til resept\n"
			+"   b   Totalt antall vanedannende resepter i Oslo\n"
			+"   c   Pasients blå resepter\n"
			+"   d   Leges mikstur-resepter\n"
			+"   e   Leges resepters totale virkestoff\n"
			+"   f   Antall narkotiske per lege\n"
			+"   g   Antall gyldige narkotiske per pasient\n"
			+"\n"
			+"  MISC\n"
			+"   h   Print denne menyen\n"
			+"   q   Lukk programmet\n"
		);
	}
}
