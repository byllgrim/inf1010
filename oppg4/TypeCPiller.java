package oppg4;

public class TypeCPiller extends Legemiddel implements Piller {
	private int antall;
	private double virkestoffPerPille;

	public TypeCPiller(String navn, double pris, double virkestoff,
	                   int antall, double virkestoffPerPille) {
		super(navn, pris, virkestoff);
		this.antall = antall;
		this.virkestoffPerPille = virkestoffPerPille;
	}

	public int hentAntall() {
		return antall;
	}

	public double hentVirkestoffPerPille() {
		return virkestoffPerPille;
	}
}
