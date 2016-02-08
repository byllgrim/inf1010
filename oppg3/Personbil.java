public class Personbil extends Fossilbil {
	protected int seter;

	public Personbil(String regNum, double utslipp, int seter) {
		super(regNum, utslipp);
		this.seter = seter;
	}
}
