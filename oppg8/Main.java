public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main filnavn");
			return;
		}

		Filbehandler fb = new Filbehandler();
		Brett b = fb.lesFil(args[0]);
		b.printBrett();
	}
}
