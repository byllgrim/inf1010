public class Elbil extends Bil {
	protected int kapasitet; //kWh?

	public Elbil(String regNum, int kapasitet) {
		super(regNum);
		this.kapasitet = kapasitet;
	}

	public void printInfo() {
		System.out.printf("EL %s %d\n", regNum, kapasitet);
	}
}
