public class Pasient {
	private static int teller = 0;

	private String navn;
	private String foedselsnummer; //TODO: vurder int
	private String adresse;
	private int postnummer;
	private int ID;

	public Pasient(String navn, String foedselsnummer,
	               String adresse, int postnummer) {
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		this.adresse = adresse;
		this.postnummer = postnummer;
		ID = teller++;
	}
}
