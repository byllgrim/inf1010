import java.util.Iterator;
import java.util.Stack;

public class SudokuBeholder implements Iterable<String>{
	private final int maxLosninger = 3500;
	private int total;
	private Stack<String> losninger;
	private int hoyde;
	private int bredde;

	public SudokuBeholder(Brett brett) {
		this.hoyde = brett.hentHoyde();
		this.bredde = brett.hentBredde();
		losninger = new Stack<String>();
	}

	public void settInn(String losning) {
		total++;

		if (losninger.size() < maxLosninger)
			losninger.push(losning);
	}

	public String taUtString() {
		if (!losninger.empty())
			return losninger.pop();
		else
			return null;
	}

	public int[][] taUtInt() {
		String brett = taUtString();
		return (brett == null ? null : losningTilInt(brett));
	}

	private int[][] losningTilInt(String brett) {
		int lengde = hoyde*bredde;
		int[][] ruter = new int[lengde][lengde];
		int pos = 0;

		for (int i = 0; i < lengde; i++) {
			for (int j = 0; j < lengde; j++) {
				char c = brett.charAt(pos++);
				ruter[j][i] = VerdiKonverterer.tallVerdi(c);
			}
			pos += 2;
		}

		return ruter;
	}

	public int hentAntallLosninger() {
		return total;
	}

	public int hentMax() {
		return maxLosninger;
	}

	public int hentHoyde() {
		return hoyde;
	}

	public int hentBredde() {
		return bredde;
	}

	public int hentLengde() {
		return hoyde*bredde;
	}

	public Iterator<String> iterator() {
		return losninger.iterator();
	}
}
