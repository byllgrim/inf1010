public class Fletting {
	public static GrNode flettEnkleLister(GrNode liste1, GrNode liste2) {
		GrNode nyListe = new GrNode(); /* maa ha en implementasjon */

		while ((liste1.hentNeste != null)
		       && (liste2.hentNeste != null))
		{
			if (liste1.compareTo(liste2) <= 0) {
				nyListe.settNeste(liste1)
				liste1 = liste1.hentNeste();
			} else {
				nyListe.settNeste(liste2;
				liste2 = liste2.hentNeste();
			}
		}

		if (liste1.hentNeste == null)
			nyListe.settNeste(liste2);
		else
			nyListe.settNeste(liste1);

		return nyListe.hentNeste();
	}
}
