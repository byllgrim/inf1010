package oppg7;

public class Main {
	private static boolean running = true;

	private Main() {}
	//TODO: hva er dette?

	public static void main(String[] args) {
		Database database = new Database();
		KommandoParser kommandoParser = new KommandoParser(database);

		velkomstMelding();
		while (running) {
			kommandoParser.behandleNesteKommando();
		}
	}

	private static void velkomstMelding() {
		System.out.println("Velkommen til en farmasoeytisk verden");
		System.out.println("Skriv h for hjelp");
	}

	public static void avslutt() {
		running = false;
	}
}
