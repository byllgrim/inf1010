package oppg4;

public class TypeAMikstur extends TypeA implements Mikstur {
	private double volumICm3;
	private double virkestoffPerCm3;

	public TypeAMikstur(String navn, double pris,
	                    int narkosegrad, double volumICm3,
	                    double virkestoffPerCm3) {
		            //TODO: siste argument = totalVirkestoff?
		super(navn, pris, volumICm3*virkestoffPerCm3, narkosegrad);
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
