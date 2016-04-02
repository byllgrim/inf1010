public class Main {
	public static void main(String[] args) {
		try {
			Filbehandler fb = new Filbehandler();
			Brett b = fb.lesFil(args[0]);
			b.printBrett();
		} catch (Exception e) {
			//TODO: Catch various exceptions
		}
	}
}
