import java.util.Stack;

public class SudokuBeholder {
	private int antallLosninger;
	private final int maxLosninger = 3500;
	private Stack<Brett> losninger;

	public void settInn(Brett b) {
		losninger.push(b);
	}

	public Brett taUt() {
		if (!losninger.empty())
			return losninger.pop();
		else
			return null;
	}

	public int hentAntallLosninger() {
		return antallLosninger;
	}

	public int hentMax() {
		return maxLosninger;
	}
}
