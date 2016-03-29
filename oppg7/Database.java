package oppg7;

import oppg4.*;
import oppg6.*;

public class Database {
	private Tabell<Pasient> pasienter;
	private Tabell<Legemiddel> legemidler;
	private int lmPos = 0; //TODO: Dette er ikke bra.
	private SortertEnkelListe<Lege> leger;
	private EnkelReseptListe resepter;

	private Filleser filleser;

	//Kan ikke lese fil hvis du har lagt til legemidler etc manuelt
	private boolean touched = false;

	public Database() {
		legemidler = new Tabell<Legemiddel>(100);
		leger = new SortertEnkelListe();
		pasienter = new Tabell<Pasient>(100);
		resepter = new EldsteForstReseptListe();
		filleser = new Filleser(this);
	}

	private void touch() {
		touched = true;
	}

	public void lesFil(String filnavn) {
		if (touched) return;
		if(filleser.lesFil(filnavn))
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
		Pasient pasient = pasienter.hentElement(psnr);
		int lmnr = Integer.parseInt(legemiddelNr);
		Legemiddel lm = legemidler.hentElement(lmnr);
		int reitnr = Integer.parseInt(reit);

		String pasientnavn;
		try {
			pasientnavn = pasient.hentNavn();
		} catch (Exception e) {
			System.err.println("error: Database: null pasient");
			return;
		}

		//TODO: Should be handled with custom exceptions
		if (lm == null) {
			System.err.println("error: Database: null legemiddel");
			return;
		}

		Resept r;
		if (frg.equals("hvit")) {
			r = new ReseptHvit(lm, lege, pasientnavn, reitnr);
		} else if (frg.equals("blå") || frg.equals("blaa")) {
			r = new ReseptBlaa(lm, lege, pasientnavn, reitnr);
			//Er denne if nodvendig for riktig instanceof?
		} else {
			System.err.println("error: Database: leggTilResept");
			return;
		}

		resepter.settInn(r);
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
}
