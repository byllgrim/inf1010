public class Katt {
	private String navn;

	public Katt(String navn) {
		this.navn = navn;
	}

	public void jakt(Bol<Mus> musebol, Bol<Rotte> rottebol) {
		System.out.printf("%s ", navn);

		if (!musebol.erTomt() && !musebol.hentDyr().erDod()) {
			String navn = rottebol.hentDyr().hentNavn();
			System.out.printf("angriper %s.\n", navn);
			musebol.hentDyr().bliAngrepet();
		} else if(!rottebol.erTomt() && !rottebol.hentDyr().erDod()) {
			String navn = rottebol.hentDyr().hentNavn();
			System.out.printf("angriper %s.\n", navn);
			rottebol.hentDyr().bliAngrepet();
		} else {
			System.out.printf("er en daarlig jeger.\n");
		}
	}
}
