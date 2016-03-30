package oppg4;

import oppg6.YngsteForstReseptListe;
import oppg6.EnkelReseptListe;

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
		resepter = new YngsteForstReseptListe();
	}

	private String settPostnummer(String num) {
		if (num.length() == 4) {
			return num;
		} else {
			return null;
		}
	}

	public String hentPostnummer() {
		return postnummer;
	}

	public String hentNavn() {
		//TODO: Bruk toString()?
		//TODO: Obsolete?
		return navn;
	}

	public EnkelReseptListe hentResepter() {
		return resepter;
	}

	public String info() {
		Long pasnr = new Long(pasientnummer);
		return String.format("%s, %s, %s, %s, %s",
		                     pasnr.toString(), navn,
		                     foedselsnummer, adresse, postnummer);
	}
}
