public class Mus extends Gnager {
	public Mus(String navn) {
		super(navn);
	}

	public void bliAngrepet() {
		if (tilstand == Tilstand.LEVENDE) {
			tilstand = Tilstand.DOD;
			System.out.printf("Musa %s gikk fra LEVENDE til DOD.\n", navn);
		}
	}
}
