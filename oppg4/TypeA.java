package oppg4;

abstract public class TypeA extends Legemiddel {
	protected int narkoseGrad;

	public TypeA(String navn, double pris, double virkestoff,
	             int narkoseGrad) {
		super(navn, pris, virkestoff);
		this.narkoseGrad = narkoseGrad;
	}

	public int hentNarkoseGrad() {
		return narkoseGrad;
	}
}
