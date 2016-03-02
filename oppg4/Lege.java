public class Lege implements Lik {
	protected String navn;
	protected EldsteForstReseptListe resepter;

	public Lege(String navn) {
		this.navn = navn; //TODO: unikt!
		// TODO: resepter
	}

	public boolean samme(String navn) {
		return this.navn.equals(navn);
	}
}
