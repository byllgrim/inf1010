abstract public class TypeB extends Legemiddel {
	protected int vanedannelse;

	public TypeB(String navn, double pris, double virkestoff,
	             int vanedannelse) {
		super(navn, pris, virkestoff);
		this.vanedannelse = vanedannelse;
	}

	public int hentVanedannelse() {
		return vanedannelse;
	}
}
