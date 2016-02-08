public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Need filename");
			System.exit(1);
		}

		BilManager manager = new BilManager();
		manager.lesFraFil(args[0]);
		manager.printFossil();
	}
}
