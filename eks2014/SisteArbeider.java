import java.io.File;
import java.io.FileWriter;

public class SisteArbeider extends Arbeider {
	private FileWriter utfil;

	public SisteArbeider(int nr, OrdBuffer inbuf, String filnavn) {
		super(nr, inbuf, null);
		try {
			utfil = new FileWriter(new File(filnavn));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void leverOrd(String s) {
		try {
			utfil.write(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
