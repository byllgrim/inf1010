import java.util.ArrayList;

public class OrdBuffer {
	private int maxord = 10;
	private ArrayList<String> ordliste;

	public OrdBuffer() {
		ordliste = new ArrayList<String>();
	}
	
	public synchronized String taUt() {
		if (ordliste.size() == 0)
			pause(0);

		String ret = ordliste.remove(0);
		notifyAll();
		return ret;
	}

	public synchronized void settInn(String s) {
		if (ordliste.size() == 10)
			pause(10);

		ordliste.add(s);
		notifyAll();
	}

	public synchronized void pause(int t) {
		while (ordliste.size() == t) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
