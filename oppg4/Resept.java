package oppg4;

// TODO: consider abstract
public class Resept {
	protected static long teller = 0; //TODO: vurder private

	protected Legemiddel legemiddel;
	protected String lege;
	protected String pasient;
	protected int reit;
	protected long nummer; //TODO: unikt!

	public Resept(Legemiddel legemiddel, String lege,
	              String pasient, int reit)
	{
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.pasient = pasient;
		this.reit = reit;
		nummer = teller++;
	}

	public long hentNummer() {
		return nummer;
	}

	public String hentLege() {
		return lege;
	}

	public String hentPasient() {
		return pasient;
	}

	public String info() {
		Long lmnr = legemiddel.hentNummer();

		String frg;
		if (this instanceof ReseptBlaa)
			frg = "blaa";
		else
			frg = "hvit";

		return String.format("%d, %s, %s, %s, %d, %s",
		                     nummer, frg, "TODO",
		                     lege, lmnr, reit);
		//TODO: im an idiot for converting int to string!
	}

	public Legemiddel hentLegemiddel() {
		return legemiddel;
	}
}
