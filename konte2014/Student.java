public class Student extends Person {
	private int nr;

	public Student(String navn, int nr) {
		super(navn);
		this.nr = nr;
	}

	public int hentNr() {
		return nr;
	}

	public boolean equals(Object o) {
		if (o instanceof Student)
		        return nr == ((Student)o).hentNr();
		else
			return super.equals(o);
	}
}
