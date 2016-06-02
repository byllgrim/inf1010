import java.io.File;
import java.util.Scanner;

public class ForsteArbeider extends Arbeider {
	private Scanner infil;

	public ForsteArbeider(String filnavn, OrdBuffer utbuf) {
		super(0, null, utbuf);

		try {
			infil = new Scanner(new File(filnavn));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String hentOrd() {
		return infil.next();
	}
}
