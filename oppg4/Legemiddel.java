package oppg4;

abstract public class Legemiddel {
	protected static long teller = 0; //TODO: vurder private

	protected String preparatnavn;
	protected double pris;
	protected double totalVirkestoffImg; //TODO: rename
	protected long nummer;

	public Legemiddel(String navn, double pris, double virkestoff) {
		preparatnavn = navn;
		this.pris = pris;
		totalVirkestoffImg = virkestoff;
		nummer = teller++;
	}

	public void settPris(double pris) {
		this.pris = pris;
	}

	public String hentNavn() {
		return preparatnavn;
	}

	public String info() {
		Long nr = new Long(nummer);
		Double p = new Double(pris);
		Double v = new Double(totalVirkestoffImg);

		String info;
		info = String.format("%s, %s, %s, %s, %s, %s, %s",
		                     nr.toString(), preparatnavn, hentForm(),
		                     hentType(), p, hentMengde(), v.toString());

		if (this instanceof TypeA || this instanceof TypeB)
			info = info + ", " + hentStyrke();

		return info;
	}

	private String hentForm() {
		if (this instanceof Mikstur)
			return "mikstur";
		else if (this instanceof Piller)
			return "pille";
		else
			return "?";
	}

	private String hentType() {
		if (this instanceof TypeA)
			return "a";
		else if (this instanceof TypeB)
			return "b";
		else if (this instanceof TypeC)
			return "c";
		else
			return "?";
	}

	private String hentMengde() {
		if (this instanceof Mikstur) {
			Mikstur m = (Mikstur)this;
			Double mengde = new Double(m.hentVirkestoffPerCm3());
			return mengde.toString();
		} else if (this instanceof Piller) {
			Piller p = (Piller)this;
			Double antl = new Double(p.hentVirkestoffPerPille());
			return antl.toString();
		} else {
			return "?";
		}
	}

	private String hentStyrke() {
		if (this instanceof TypeA) {
			int s = ((TypeA)this).hentNarkoseGrad();
			Integer i = new Integer(s);
			return i.toString();
		} else if (this instanceof TypeB) {
			int s = ((TypeB)this).hentVanedannelse();
			Integer i = new Integer(s);
			return i.toString();
		} else if (this instanceof TypeC) {
			return "";
		} else {
			return "?";
		}
	}
}
