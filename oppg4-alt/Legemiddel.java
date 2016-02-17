abstract public class Legemiddel implements Piller, Mikstur{
	protected static int teller = 0;

	protected String navn;
	protected double pris;
	protected int nummer;

	private int antallPiller = 0;
	private double volum = 0;
	private double virkestoffPerPille = 0;
	private double virkestoffPerVolum = 0;

	public Legemiddel(String navn, double pris) {
		this.navn = navn;
		this.pris = pris;
		this.nummer = teller++;
	}

	public void settVolum(double volum) {
		this.volum = volum;
	}

	public double hentVolum() {
		return volum;
	}

	public void settVirkestoffPerVolum(double virkestoff) {
		virkestoffPerVolum = virkestoff;
	}

	public double hentVirkestoffPerVolum() {
		return virkestoffPerVolum;
	}

	public void settAntallPiller(int antall) {
		antallPiller = antall;
	}

	public int hentAntallPiller() {
		return antallPiller;
	}

	public void settVirkestoffPerPille(double virkestoff) {
		virkestoffPerPille = virkestoff;
	}

	public double hentVirkestoffPerPille() {
		return virkestoffPerPille;
	}
}
