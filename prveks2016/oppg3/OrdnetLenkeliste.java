/*
 * NB! Programmet fungerer ikke, men jeg gidder ikke fikse det heller.
 */

class OrdnetLenkeliste {
	public static void main(String[] args) {
		Liste<String> ordliste = new Liste<String>();

		String[] navn = new String[]{
			"I", "dag", "er", "det", "eksamen", "i", "INF1010.\n",
			"Jeg", "håper", "du", "liker", "denne", "oppgaven.\n",
			"Lykke", "til!", "hilsen", "oppgaveforfatteren\n"};

		System.out.print("Setter inn: ");
		for (String n: navn) {
			System.out.print(n + " ");
			ordliste.settInn(n);
		}
		System.out.println();
		ordliste.skrivAlle();
		System.out.println();
	}
}
