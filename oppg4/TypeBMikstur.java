package oppg4;

public class TypeBMikstur extends TypeB implements Mikstur {
	private double volumICm3;
	private double virkestoffPerCm3;

	public TypeBMikstur(String navn, double pris, double virkestoff,
	                    int vanedannelse, double volumICm3,
	                    double virkestoffPerCm3) {
		super(navn, pris, virkestoff, vanedannelse);
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
