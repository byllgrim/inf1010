import java.util.Stack;

public class SudokuBeholder {
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

	public String taUt() {
		if (!losninger.empty())
			return losninger.pop();
		else
			return null;
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
}
