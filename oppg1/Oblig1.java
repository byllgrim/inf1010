public class Oblig1 {
	public static void main(String[] args) {
		Bol<Mus> musebol = new Bol<>();
		Bol<Rotte> rottebol = new Bol<>();
		Katt findus = new Katt("Findus");

		findus.jakt(musebol, rottebol);

		Rotte mackey = new Rotte("Mackey");
		rottebol.leggTilDyr(mackey);
		findus.jakt(musebol, rottebol);

		Mus bajali = new Mus("Bajali");
		musebol.leggTilDyr(bajali);
		Mus hajjababba = new Mus("Hajjababba");
		musebol.leggTilDyr(hajjababba);

		findus.jakt(musebol, rottebol);
	}
}
