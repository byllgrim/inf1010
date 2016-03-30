package oppg7;

import oppg4.*;
import oppg6.*;

public class Database {
	private Tabell<Pasient> pasienter;
	private Tabell<Legemiddel> legemidler;
	private int lmPos = 0; //TODO: Dette er ikke bra.
	private SortertEnkelListe<Lege> leger;
	private EnkelReseptListe resepter;

	private Filbehandler filbehandler;

	//Kan ikke lese fil hvis du har lagt til legemidler etc manuelt
	private boolean touched = false;

	public Database() {
		legemidler = new Tabell<Legemiddel>(100);
		leger = new SortertEnkelListe();
		pasienter = new Tabell<Pasient>(100);
		resepter = new EldsteForstReseptListe();
		filbehandler = new Filbehandler(this);
	}

	private void touch() {
		touched = true;
	}

	public void skrivFil(String filnavn) {
		if (!touched) {
			System.out.println("Ingen endringer a skrive.");
			return;
		}

		filbehandler.skrivFil(filnavn);
	}

	public void lesFil(String filnavn) {
		if (touched) {
			System.out.println("Kan ikke lese fil. Du har tukla.");
			return;
		}

		if (filbehandler.lesFil(filnavn))
			touch();
	}

	public void leggTilLegemiddel(String navn,
	                              String form, String type,
	                              String pris, String mengde,
	                              String virkestoff, String styrke)
	{
		//Verdens lengste ja***a funksjon. Jeg har gitt opp.
		double n, p, m ,v;
		int s;
		LegemiddelTypeForm tf;

		try {
			tf = typeForm(type, form);
			p = Double.parseDouble(pris);
			m = Double.parseDouble(mengde);
			v = Double.parseDouble(virkestoff);
			s = Integer.parseInt(styrke);
		} catch (Exception e) {
			System.err.println("error: Database.leggTilLegemiddel: "
			                   + "conversion error.");
			return;
		}

		Legemiddel l = null; //TODO not null
		switch (tf) {
		case A_MIKSTUR:
			l = new TypeAMikstur(navn, p, s, m, v);
			break;
		case A_PILLE:
			l = new TypeAPiller(navn, p, s, (int)m, v);
			break;
		case B_MIKSTUR:
			l = new TypeBMikstur(navn, p, s, m, v);
			break;
		case B_PILLE:
			l = new TypeBPiller(navn, p, s, (int)m, v);
			break;
		case C_MIKSTUR:
			l = new TypeCMikstur(navn, p, m, v);
			break;
		case C_PILLE:
			l = new TypeCPiller(navn, p, (int)m, v);
			break;
		default:
			System.err.println("error: Database.leggTilLegemiddel: "
			                   + "ukjent type/form");
			//TODO: Exception?
			return;
		}

		legemidler.settInn(l);
		touch(); //TODO: ensure execution
	}

	public void leggTilLege(String navn, String nokkel) {
		Lege l = new Lege(navn);
		leger.settInn(l, nokkel);
		//TODO: Nokkel duplikat?
		//TODO: Fastlege med nummer 0

		touch();
	}

	public void leggTilPasient(String navn, String fnr,
	                           String adr, String postnr)
	{
		Pasient p = new Pasient(navn, fnr, adr, postnr);
		pasienter.settInn(p);

		touch();
	}

	public void leggTilResept(String frg, String pasientNr, String lege,
	                          String legemiddelNr, String reit)
	{
		int psnr = Integer.parseInt(pasientNr);
		//Pasient pasient = pasienter.hentElement(psnr);
		int lmnr = Integer.parseInt(legemiddelNr);
		Legemiddel lm = legemidler.hentElement(lmnr);
		int reitnr = Integer.parseInt(reit);

		/*String pasientnavn;
		try {
			pasientnavn = pasient.hentNavn();
		} catch (Exception e) {
			System.err.println("error: Database: null pasient");
			return;
		}*/

		//TODO: Should be handled with custom exceptions
		if (lm == null) {
			System.err.println("error: Database: null legemiddel");
			return;
		}

		Resept r;
		if (frg.equals("hvit")) {
			r = new ReseptHvit(lm, lege, psnr, reitnr);
		} else if (frg.equals("blå") || frg.equals("blaa")) {
			r = new ReseptBlaa(lm, lege, psnr, reitnr);
			//Er denne if nodvendig for riktig instanceof?
		} else {
			System.err.println("error: Database: leggTilResept");
			return;
		}

		resepter.settInn(r);

		//Hva med pasienten?
		Pasient pasient = pasienter.hentElement(psnr);
		pasient.hentResepter().settInn(r);
	}

	private LegemiddelTypeForm typeForm(String type, String form)
	                                   throws Exception {
		char t = type.charAt(0);
		char f = form.charAt(0);

		if (t == 'a') {
			if (f == 'm') {
				return LegemiddelTypeForm.A_MIKSTUR;
			} else if (f == 'p') {
				return LegemiddelTypeForm.A_PILLE;
			}
		} else if (type.equals("b")) {
			if (f == 'm') {
				return LegemiddelTypeForm.B_MIKSTUR;
			} else if (f == 'p') {
				return LegemiddelTypeForm.B_PILLE;
			}
		} else if (type.equals("c")) {
			if (f == 'm') {
				return LegemiddelTypeForm.C_MIKSTUR;
			} else if (f == 'p') {
				return LegemiddelTypeForm.C_PILLE;
			}
		}
		throw new Exception();
	}

	public void listPasienter() {
		System.out.println("# Personer (nr, navn, "
		                   + "fnr, adresse, postnr)");

		for (Pasient p : pasienter) {
			System.out.println(p.info());
		}
	}

	public void listLeger() {
		System.out.println("# Leger (navn, avtalenr / 0"
		                   + " hvis ingen avtale)");

		for (Lege l : leger) {
			System.out.println(l.info());
			//TODO: consider arraylist.sort()
		}
	}

	public void listLegemidler() {
		System.out.println("# Legemidler (nr, navn, form, type, pris,"
		                   + " antall/mengde, virkestoff [, styrke])");

		for (Legemiddel l : legemidler) {
			System.out.println(l.info());
		}
	}

	public void listResepter() {
		System.out.println("# Resepter (nr, hvit/blå, persNummer, "
		                   + "legeNavn, legemiddelNummer, reit)");

		for (Resept r : resepter) {
			System.out.println(r.info());
		}
	}

	public Tabell<Pasient> hentPasienter() {
		return pasienter;
	}

	public Tabell<Legemiddel> hentLegemidler() {
		return legemidler;
	}

	public SortertEnkelListe<Lege> hentLeger() {
		return leger;
	}

	public EnkelReseptListe hentResepter() {
		return resepter;
	}

	public void printLmTilResept(String resNr) {
		try {
			long nr = Long.parseLong(resNr);
			Legemiddel l = resepter.finnResept(nr).hentLegemiddel();
			System.out.println(l.info());
		} catch (Exception e) {
			System.out.println("Feil i soek av resept.");
		}
	}

	public void printVanedannendeOslo() {
	System.out.println("Vanedann");
		int tot = 0;
		int oslo = 0;

		for (Resept r : resepter) {
			Legemiddel lm = r.hentLegemiddel();

			if (lm instanceof TypeB) {
				tot++;
			} else {
				continue;
			}

			int pasNr = (int)r.hentPasientNr();
			String postNr =
				pasienter.hentElement(pasNr).hentPostnummer();
			if (postNr.compareTo("1300") < 0)
				oslo++;
		}

		System.out.println("Totalt vanedannende: " + tot);
		System.out.println("Hvorav i oslo: " + oslo);
	}

	public void printPasientsBlaa(String pasientNr) {
		int psnr = Integer.parseInt(pasientNr);
		Pasient p = pasienter.hentElement(psnr);

		for (Resept r : p.hentResepter()) {
			if (r instanceof ReseptBlaa)
				System.out.println(r.info());
		}
	}
}
