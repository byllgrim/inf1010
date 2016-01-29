public class Bok implements TilUtLaan {
	private String tittel;
	private String forfatter;
	private String laaner;

	public Bok(String tittel, String forfatter) {
		laaner = null;
		this.tittel = tittel;
		this.forfatter = forfatter;
	}

	public boolean laanUtTil(String laaner) {
		if (this.laaner == null) {
			this.laaner = laaner;
			return true;
		} else {
			return false;
		}
	}

	public void leverTilbake() {
		laaner = null;
	}

	public String hentTittel() {
		return tittel;
	}

	public String hentForfatter() {
		return forfatter;
	}
}
