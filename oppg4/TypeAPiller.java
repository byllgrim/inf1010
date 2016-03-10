package oppg4;

public class TypeAPiller extends TypeA implements Piller {
	private int antall;
	private double virkestoffPerPille;

	public TypeAPiller(String navn, double pris,
	                   int narkosegrad, int antall,
	                   double virkestoffPerPille) {
		super(navn, pris, antall*virkestoffPerPille, narkosegrad);
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
