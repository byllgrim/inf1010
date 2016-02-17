public class TypeBPiller extends TypeB implements Piller {
	private int antall;
	private double virkestoffPerPille;

	public TypeBPiller(String navn, double pris, double virkestoff,
	                   int vanedannelse, int antall,
	                   double virkestoffPerPille) {
		super(navn, pris, virkestoff, vanedannelse);
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
