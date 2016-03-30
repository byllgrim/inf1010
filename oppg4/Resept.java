package oppg4;

// TODO: consider abstract
public class Resept {
	protected static long teller = 0; //TODO: vurder private

	protected Legemiddel legemiddel;
	protected String lege;
	protected long pasientNr;
	protected int reit;
	protected long nummer; //TODO: unikt!

	public Resept(Legemiddel legemiddel, String lege,
	              long pasientNr, int reit)
	{
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.pasientNr = pasientNr;
		this.reit = reit;
		nummer = teller++;
	}

	public long hentNummer() {
		return nummer;
	}

	public String hentLege() {
		return lege;
	}

	public long hentPasientNr() {
		return pasientNr;
	}

	public String info() {
		Long lmnr = legemiddel.hentNummer();

		String frg;
		if (this instanceof ReseptBlaa)
			frg = "blaa";
		else
			frg = "hvit";

		return String.format("%d, %s, %d, %s, %d, %s",
		                     nummer, frg, pasientNr,
		                     lege, lmnr, reit);
		//TODO: im an idiot for converting int to string!
	}

	public Legemiddel hentLegemiddel() {
		return legemiddel;
	}
}
