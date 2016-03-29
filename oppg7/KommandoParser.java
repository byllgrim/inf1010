package oppg7;

import java.util.Scanner;

public class KommandoParser {
	private static Scanner stdin = new Scanner(System.in);
	private Database database;

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
		switch (cmd) {
		case 'r':
			lesFil();
			break;
		case 'w':
			System.out.println("skriv fil");
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
			System.out.println("hent legemiddel til resept");
			break;
		case 'b':
			System.out.println("antall vanedannende");
			break;
		case 'c':
			System.out.println("pasients blaa");
			break;
		case 'd':
			System.out.println("leges miksturer");
			break;
		case 'e':
			System.out.println("leges totale virkestoff");
			break;
		case 'f':
			System.out.println("antall narkotiske per lege");
			break;
		case 'g':
			System.out.println("gyldige narkotiske per pasient");
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
		String filnavn = hentInput("Filnavn: ");
		database.lesFil(filnavn);
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
