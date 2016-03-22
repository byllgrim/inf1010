package oppg7;

import oppg6.Tabell;
import oppg6.SortertEnkelListe;
import oppg4.*;

public class Database {
	private Tabell<Legemiddel> legemidler;
	private int lmPos = 0; //TODO: Dette er ikke bra.
	private SortertEnkelListe<Lege> leger;
	private Tabell<Pasient> pasienter;

	public Database() {
		legemidler = new Tabell<Legemiddel>(100);
		leger = new SortertEnkelListe();
		pasienter = new Tabell<Pasient>(100);
	}

	public void lesFil(String filnavn) {
		System.out.println("TODO les '" + filnavn + "'");
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
	}

	public void leggTilLege(String navn, String nokkel) {
		Lege l = new Lege(navn);
		leger.settInn(l, nokkel);
		//TODO: Nokkel duplikat?
	}

	public void leggTilPasient(String navn, String fnr,
	                           String adr, String postnr)
	{
		Pasient p = new Pasient(navn, fnr, adr, postnr);

		pasienter.settInn(p);
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
		//TODO: Mer informasjon?
		//TODO: Bruk toString()?
		for (Pasient p : pasienter) {
			System.out.println(p.hentNavn());
		}
	}

	public void listLeger() {
		//TODO: Mer informasjon?
		//TODO: Bruk toString()?
		for (Lege l : leger) {
			System.out.println(l.hentNavn());
		}
	}

	public void listLegemidler() {
		//TODO: List all informasjon?
		//TODO: Bruk toString()?
		for (Legemiddel l : legemidler) {
			System.out.println(l.hentNavn());
		}
	}
}
