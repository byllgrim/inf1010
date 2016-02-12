public class Lege implements Lik {
	protected String navn;

	public Lege(String navn) {
		this.navn = navn; //TODO: unikt!
	}

	public boolean samme(String navn) {
		return this.navn.equals(navn);
	}
}
