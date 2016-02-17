public class Lege implements Lik, Kommuneavtale {
	private String navn;
	private int avtalenummer = -1;

	public Lege(String navn) {
		this.navn = navn;
	}

	public boolean samme(String navn) {
		return this.navn.equals(navn);
	}

	public void settAvtalenummer(int num) {
		avtalenummer = num;
	}

	public int hentAvtalenummer() {
		return avtalenummer;
	}
}
