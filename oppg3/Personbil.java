public class Personbil extends Fossilbil {
	protected int seter;

	public Personbil(String regNum, double utslipp, int seter) {
		super(regNum, utslipp);
		this.seter = seter;
	}

	public void printInfo() {
		System.out.printf("PERSONFOSSILBIL %s %f %d\n",
		                   regNum, utslipp, seter);
	}
}
