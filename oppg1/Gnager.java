public class Gnager {
	protected String navn;
	protected Tilstand tilstand;

	public String hentNavn() {
		return navn;
	}

	public boolean erDod() {
		if (tilstand == Tilstand.DOD) {
			return true;
		} else {
			return false;
		}
	}
}
