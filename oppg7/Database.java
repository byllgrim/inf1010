package oppg7;

import oppg6.Tabell;
import oppg6.SortertEnkelListe;
import oppg4.Lege;
import oppg4.Legemiddel;
import oppg4.Pasient;

public class Database {
	private Tabell<Legemiddel> legemidler;
	private SortertEnkelListe<Lege> leger;
	private Tabell<Pasient> pasienter;

	public Database() {
		legemidler = new Tabell<Legemiddel>(100);
		leger = new SortertEnkelListe();
		pasienter = new Tabell<Pasient>(100);
	}
}
