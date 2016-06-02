public class Samleband {
	private static int N;
	private static String innfil;
	private static String utfil;
	private static OrdBuffer curInbuf; /* current */
	private static OrdBuffer curUtbuf;

	private Samleband() {
		//
	}

	public static void main(String[] args) {
		try {
			N = Integer.parseInt(args[0]);
			innfil = args[1];
			utfil = args[2];
		} catch (Exception e) {
			System.out.println("usage: Samleband N innfil utfil");
			System.exit(1);
		}

		curUtbuf = new OrdBuffer();
		new ForsteArbeider(innfil, curUtbuf).start();

		int i;
		for (i = 1; i < (N-1); i++) {
			curInbuf = curUtbuf;
			curUtbuf = new OrdBuffer();
			new IndreArbeider(i, curInbuf, curUtbuf);
		}

		curInbuf = curUtbuf;
		new SisteArbeider(++i, curInbuf, utfil).start();
	}
}
