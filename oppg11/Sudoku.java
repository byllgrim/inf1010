public class Sudoku {
	public static void main(String[] args) {
		try {
			Filbehandler fb = new Filbehandler();
			Brett b = fb.lesFil(args[0]);
			b.printBrett();

			SudokuBeholder sb = new SudokuBeholder(b);
			b.losBrett(sb);
			fb.skrivFil(sb, args[1]);

			Losningsviser.settBeholder(sb);
			Losningsviser.launch(Losningsviser.class);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("usage: Sudoku spillfil løsningfil");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: Catch various exceptions
		}
	}
}
