public class Pasient {
	protected static long teller = 0; //TODO: vurder private

	protected String navn;
	protected String foedselsnummer;
	protected String adresse;
	protected String postnummer;
	protected long pasientnummer;

	public Pasient(String navn, String foedselsnummer,
	               String adresse, String postnummer)
	{
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		this.adresse = adresse;
		this.postnummer = settPostnummer(postnummer);
		pasientnummer = teller++;
	}

	private String settPostnummer(String num) {
		if (num.length() == 4) {
			return num;
		} else {
			return null;
		}
	}
}
