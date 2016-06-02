public class FlettingAvInt {
	public static IntNode flettEnkleLister(IntNode liste1,
	                                       IntNode liste2)
	{
		IntNode nyListe = new IntNode();
		IntNode sisteNode = nyListe;

		while ((liste1 != null) && (liste2 != null)) {
			if (liste1.innhold < liste2.innhold) {
				sisteNode.neste = liste1;
				liste1 = liste1.neste;
			} else {
				sisteNode.neste = liste2;
				liste2 = liste2.neste;
			}
		}

		if (liste1 == null)
			sisteNode.neste = liste2;
		else
			sisteNode.neste = liste1;

		return nyListe.neste; /* skip dummy */
	}
}
