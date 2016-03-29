package oppg4;

import oppg6.YngsteForstReseptListe;

public class Pasient {
	protected static long teller = 0; //TODO: vurder private

	protected String navn;
	protected String foedselsnummer;
	protected String adresse;
	protected String postnummer;
	protected long pasientnummer;
	protected YngsteForstReseptListe resepter;

	public Pasient(String navn, String foedselsnummer,
	               String adresse, String postnummer)
	{
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		this.adresse = adresse;
		this.postnummer = settPostnummer(postnummer);
		pasientnummer = teller++;
		// TODO: resepter
	}

	private String settPostnummer(String num) {
		if (num.length() == 4) {
			return num;
		} else {
			return null;
		}
	}

	public String hentNavn() {
		//TODO: Bruk toString()?
		//TODO: Obsolete?
		return navn;
	}

	public String info() {
		Long pasnr = new Long(pasientnummer);
		return String.format("%s, %s, %s, %s, %s",
		                     pasnr.toString(), navn,
		                     foedselsnummer, adresse, postnummer);
	}
}
