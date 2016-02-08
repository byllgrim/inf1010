public class Lastebil extends Fossilbil {
	protected double nyttevekt;

	public Lastebil(String regNum, double utslipp, double nyttevekt) {
		super(regNum, utslipp);
		this.nyttevekt = nyttevekt;
	}

	public void printInfo() {
		System.out.printf("LASTEBIL %s %f %f\n",
		                   regNum, utslipp, nyttevekt);
	}
}
