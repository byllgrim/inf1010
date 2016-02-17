public class TypeAMikstur extends TypeA implements Mikstur {
	private double volumICm3;
	private double virkestoffPerCm3;

	public TypeAMikstur(String navn, double pris, double virkestoff,
	                    int narkosegrad, double volumICm3,
	                    double virkestoffPerCm3) {
		super(navn, pris, virkestoff, narkosegrad);
		this.volumICm3 = volumICm3;
		this.virkestoffPerCm3 = virkestoffPerCm3;
	}

	public double hentVolumICm3() {
		return volumICm3;
	}

	public double hentVirkestoffPerCm3() {
		return virkestoffPerCm3;
	}
}
