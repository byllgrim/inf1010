public class Mus extends Gnager {
	public Mus(String navn) {
		this.navn = navn;
		tilstand = Tilstand.LEVENDE;
	}

	public String hentNavn() {
		return navn;
	}

	public void bliAngrepet() {
		if (tilstand == Tilstand.LEVENDE) {
			tilstand = Tilstand.DOD;
			System.out.printf("Musa %s gikk fra LEVENDE til DOD\n", navn);
		}
	}
}
