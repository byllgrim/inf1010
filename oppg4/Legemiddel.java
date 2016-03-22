package oppg4;

abstract public class Legemiddel {
	protected static long teller = 0; //TODO: vurder private

	protected String preparatnavn;
	protected double pris;
	protected double totalVirkestoffImg; //TODO: rename
	protected long nummer;

	public Legemiddel(String navn, double pris, double virkestoff) {
		preparatnavn = navn;
		this.pris = pris;
		totalVirkestoffImg = virkestoff;
		nummer = teller++;
	}

	public void settPris(double pris) {
		this.pris = pris;
	}

	public String hentNavn() {
		return preparatnavn;
	}
}
