public class Main {
	public static void main(String[] args) {
		Banan b = new Banan();
		Eple e = new Eple();
		Kiwi k = new Kiwi();
		Person h = new Person("Harald");
		Person s = new Person("Sonja");
		Student g1 = new Student("Gosnar", 321);
		Student g2 = new Student("Gosnar", 321);
		Student r = new Student("Ragnhild", 123);

		Beholder beholder = new Beholder();
		beholder.settInn(b);
		beholder.settInn(e);
		beholder.settInn(k);
		beholder.settInn(h);
		beholder.settInn(s);
		beholder.settInn(g1);
		beholder.settInn(g2);
		beholder.settInn(r);
		/* her er tegning av datastruktur */

		Object o = beholder.hent();
		for (int i = 1; o != null; o = beholder.hent(), i++) {
			System.out.println(i + ": " + o.toString());
		}
	}
}
