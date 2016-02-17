public class Resept {
	private static int teller = 0;

	private Legemiddel legemiddel;
	private String lege;
	private String pasient;
	private int reit;

	public Resept(Legemiddel legemiddel, String lege, String pasient,
	              int reit, boolean blaaResept) {
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.pasient = pasient;
		this.reit = reit;

		if (blaaResept)
			legemiddel.settPris(0);
	}
}
