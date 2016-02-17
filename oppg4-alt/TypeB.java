public class TypeB extends Legemiddel {
	private int vanedannelse;

	public TypeB(String navn, double pris, int vanedannelse) {
		super(navn, pris);
		this.vanedannelse = vanedannelse;
	}

	public int hentVanedannelse() {
		return vanedannelse;
	}
}
