public class Pasient {
	protected static long teller = 0; //TODO: vurder private

	protected String navn;
	protected int foedselsnummer; //TODO: vurder String
	protected String adresse;
	protected int postnummer;
	protected long pasientnummer;

	public Pasient(String navn, int foedselsnummer,
	               String adresse, int postnummer)
	{
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		this.adresse = adresse;
		this.postnummer = settPostnummer(postnummer);
		pasientnummer = teller++;
	}

	private int settPostnummer(int num) {
		if (num > 0 && num < 10000) {
			return num;
		} else {
			return -1;
		}
	}
}
