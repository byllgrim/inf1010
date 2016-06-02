public class Arbeider extends Thread {
	private OrdBuffer inbuf;
	private OrdBuffer utbuf;
	private String minste;
	private String tmp;
	private int nr;

	public Arbeider(int nr, OrdBuffer inbuf, OrdBuffer utbuf) {
		this.nr = nr;
		this.inbuf = inbuf;
		this.utbuf = utbuf;
	}

	public void run() {
		for (tmp = hentOrd(); tmp != null; tmp = hentOrd())
			finnMinste();

		printResultat();
	}

	public String hentOrd() {
		return inbuf.taUt();
	}

	public void finnMinste() {
		if (minste == null)
			minste = tmp;

		if (minste.compareTo(tmp) <= 0) {
			leverOrd(tmp);
		} else {
			leverOrd(minste);
			minste = tmp;
		}
	}

	public void leverOrd(String s) {
		utbuf.settInn(s);
	}

	public void printResultat() {
		System.out.println("Traad #" + nr + " fant '" + minste + "'");
	}
}
