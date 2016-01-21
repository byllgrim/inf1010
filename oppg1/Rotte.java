public class Rotte extends Gnager {
	public Rotte(String navn) {
		this.navn = navn;
		tilstand = Tilstand.LEVENDE;
	}

	public void bliAngrepet() {
		switch (tilstand) {
		case LEVENDE:
			System.out.printf("Rotta %s gikk fra LEVENDE til SKADET.\n", navn);
			tilstand = Tilstand.SKADET;
			break;
		case SKADET:
			System.out.printf("Rotta %s gikk fra SKADET til DOD.\n", navn);
			break;
		default:
			System.out.printf("Error: Gnager: bliAngrepet: Rotta er dod\n");
		}
	}
}
