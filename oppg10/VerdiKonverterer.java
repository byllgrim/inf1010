public class VerdiKonverterer {
	public static int tallVerdi(char c) throws RuntimeException {
		int v = -1;

		switch (c) {
		case '#':
			v = 37;
			break;
		case '&':
			v = 38;
			break;
		case '.':
			v = 0;
			break;
		case '@':
			v = 36;
		}

		if (48 < c && c < 58)     /* 1-9 */
			v = (c - 48);
		if (64 < c && c < 91)     /* A-Z */
			v = (c - 55);
		if (96 < c && c < 123)    /* a-z */
			v = (c - 58);

		if (v == -1)
			throw new RuntimeException("Ugyldig tegn");
		if (!lovligIntervall(v))
			throw new RuntimeException("Ulovlig intervall");
		else
			return v;
	}

	private static boolean lovligIntervall(int i) {
                return ((i >= 0 && i <= 64) || i == 0);
        }

	public static char tilSymbol(int i) {
		int c = '.'; //actually a char

		switch (i) {
		case 37:
			c = '#';
			break;
		case 38:
			c = '&';
			break;
		case 0:
			c = '.';
			break;
		case 36:
			c = '@';
			break;
		}

		if (0 < i && i < 10)    /* 1-9 */
			c = (i + 48);
		if (9 < i && i < 36)    /* A-Z */
			c = (i + 55);
		if (38 < i && i < 65)   /* a-z */
			c = (i + 58);

		return (char)c;
	}
}
