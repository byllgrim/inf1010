public class Fossilbil extends Bil {
	protected double utslipp; // CO2

	public Fossilbil(String regNum, double utslipp) {
		super(regNum);
		this.utslipp = utslipp;
	}

	public void printInfo() {
		System.out.printf("FOSSIL %s %f\n", regNum, utslipp);
	}
}
