public class Resept {
	protected static long teller = 0; //TODO: vurder private

	protected Legemiddel legemiddel;
	protected String lege;
	protected String pasient;
	protected int reit;
	protected long nummer; //TODO: unikt!

	public Resept(Legemiddel legemiddel, String lege,
	              String pasient, int reit)
	{
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.pasient = pasient;
		this.reit = reit;
		nummer = teller++;
	}
}
