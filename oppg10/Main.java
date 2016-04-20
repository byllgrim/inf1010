public class Main {
	public static void main(String[] args) {
		try {
			Filbehandler fb = new Filbehandler();
			Brett b = fb.lesFil(args[0]);
			b.printBrett();
			b.losBrett();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Forste argument er filnavn.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: Catch various exceptions
		}
	}
}
