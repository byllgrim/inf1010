public class ReseptBlaa extends Resept{
	public ReseptBlaa(Legemiddel legemiddel, String lege,
	                  String pasient, int reit)
	{
		super(legemiddel, lege, pasient, reit);
		this.legemiddel.settPris(0);
	}
}