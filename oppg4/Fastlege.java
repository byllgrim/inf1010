package oppg4;

public class Fastlege extends Lege implements HarKommuneAvtale {
	private int avtalenummer;

	public Fastlege(String navn, int avtalenummer) {
		super(navn);
		this.avtalenummer = avtalenummer;
	}

	public int hentAvtalenummer() {
		return avtalenummer; 
	}
}
