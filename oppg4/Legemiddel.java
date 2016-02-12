public class Legemiddel {
	protected static long teller = 0; //TODO: vurder private

	protected String preparatnavn;
	protected double pris;
	protected double totalVirkestoffImg;
	protected long referansenummer; //TODO: unikt!

	public Legemiddel(String navn, double pris, double virkestoff) {
		preparatnavn = navn;
		this.pris = pris;
		totalVirkestoffImg = virkestoff;
		referansenummer = teller++;
	}

	public void settPris(double pris) {
		this.pris = pris;
	}
}
