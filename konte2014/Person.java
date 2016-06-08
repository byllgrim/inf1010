public class Person {
	protected String navn;

	public Person(String navn) {
		this.navn = navn;
	}

	public String id() {
		return navn;
	}

	public boolean equals(Object o) {
		return (o instanceof Person
		        && navn.compareTo(((Person)o).id()) == 0);
	}
}
