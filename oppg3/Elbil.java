public class Elbil extends Bil {
	protected int kapasitet; //kWh?

	public Elbil(String regNum, int kapasitet) {
		super(regNum);
		this.kapasitet = kapasitet;
	}
}
