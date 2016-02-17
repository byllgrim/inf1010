public class TypeA extends Legemiddel {
	private int narkotiskEffekt;

	public TypeA(String navn, double pris, int narkotiskEffekt) {
		super(navn, pris);
		this.narkotiskEffekt = narkotiskEffekt;
	}

	public int hentNarkotiskEffekt() {
		return narkotiskEffekt;
	}
}
