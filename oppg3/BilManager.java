import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class BilManager {
	ArrayList<Bil> biler = new ArrayList<Bil>();

	public void settInnBil(Bil bil) {
		biler.add(bil);
	}

	public void lesFraFil(String filnavn) {
		try {
			Scanner scanner = new Scanner(new File(filnavn));

			while (scanner.hasNextLine()) {
				tolkOgSettInn(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printPersonbil() {
		for (Bil b : biler) {
			if (b instanceof Personbil) {
				b.printInfo();
			}
		}
	}

	private void tolkOgSettInn(String s) {
		String[] words = s.split(" ");
		/* Jeg antar ' ' som skille istedenfor blankspace */

		if (s == null) System.exit(1);

		if (words[0].equals("BIL")) {
			lagBil(words);
			return;
		} else if (words[0].equals("EL")) {
			lagElbil(words);
			return;
		} else if (words[0].equals("FOSSIL")) {
			lagFossilbil(words);
			return;
		} else if (words[0].equals("PERSONFOSSILBIL")) {
			lagPersonbil(words);
			return;
		} else if (words[0].equals("LASTEBIL")) {
			lagLastebil(words);
			return;
		}
	}

	private void lagBil(String[] w) {
		String regNum = w[1];

		biler.add(new Bil(regNum));
	}

	private void lagElbil(String[] w) {
		String regNum = w[1];
		int kapasitet = Integer.parseInt(w[2]);

		biler.add(new Elbil(regNum, kapasitet));
	}

	private void lagFossilbil(String[] w) {
		String regNum = w[1];
		double utslipp = Double.parseDouble(w[2]);

		biler.add(new Fossilbil(regNum, utslipp));
	}

	private void lagPersonbil(String[] w) {
		String regNum = w[1];
		double utslipp = Double.parseDouble(w[2]);
		int seter = Integer.parseInt(w[3]);

		biler.add(new Personbil(regNum, utslipp, seter));
	}

	private void lagLastebil(String[] w) {
		String regNum = w[1];
		double utslipp = Double.parseDouble(w[2]);
		double nyttevekt = Double.parseDouble(w[3]);

		biler.add(new Lastebil(regNum, utslipp, nyttevekt));
	}
}
