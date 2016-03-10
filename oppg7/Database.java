package oppg7;

import oppg6.Tabell;
import oppg6.SortertEnkelListe;
import oppg4.*;

public class Database {
	private Tabell<Legemiddel> legemidler;
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

	public void leggTilLegemiddel(String navn, String nummer,
	                              String form, String type,
	                              String pris, String mengde,
	                              String virkestoff, String styrke)
	{
		System.out.println("TODO legg til legemiddel");
		//Verdens lengste ja***a funksjon. Jeg har gitt opp.
		double n, p, m ,v;
		int s;
		LegemiddelTypeForm tf;

		try {
			tf = typeForm(type, form);
			n = Double.parseDouble(nummer);
			p = Double.parseDouble(pris);
			m = Double.parseDouble(mengde);
			v = Double.parseDouble(virkestoff);
			s = Integer.parseInt(styrke);
		} catch (Exception e) {
			System.err.println("?");
			return;
		}

		Legemiddel l = null; //TODO not null
		switch (tf) {
		case A_MIKSTUR:
			l = new TypeAMikstur(navn, p, s, m, v);
			break;
		case A_PILLE:
			l = new TypeAPille(navn, p, s, m, v); //int mengde
			break;
		case B_MIKSTUR:
			l = new TypeBMikstur(navn, p, s, m, v);
			break;
		case B_PILLE:
			break;
		case C_MIKSTUR:
			break;
		case C_PILLE:
			break;
		default:
			return;
		}

		legemidler.settInn(l);
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
}
