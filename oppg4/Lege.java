package oppg4;

import oppg6.EldsteForstReseptListe;

public class Lege implements Comparable<Lege>,Lik {
	protected String navn;
	protected EldsteForstReseptListe resepter;

	public Lege(String navn) {
		this.navn = navn; //TODO: unikt!
		// TODO: resepter
	}

	public boolean samme(String navn) {
		return this.navn.equals(navn);
	}

	public int compareTo(Lege other) {
		String n1 = this.navn;
		String n2 = other.navn;
		return n1.compareTo(n2);
	}

	public String hentNavn() {
		return navn;
	}
}
