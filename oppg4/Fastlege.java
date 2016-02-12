public class Fastlege extends Lege implements HarKommuneAvtale {
	private int avtalenummer;

	public Fastlege(String navn, int avtalenummer) {
		super(navn);
		this.avtalenummer = avtalenummer;
	}

	public int HentAvtalenummer() {
		return avtalenummer; 
	}
}
