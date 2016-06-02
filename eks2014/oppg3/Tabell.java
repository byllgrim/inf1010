public class Tabell {
	public static int[] fjernNuller(int[] langTab) {
		int i, j, v, startNull, sluttNull;
		boolean begynnelse = true;
		int[] kortTab;

		for (i = 0; i < langTab.size) {
			v = lanTab[i];
			if (v != 0) {
				sluttNull = 0;
				if (begynnelse) begynnelse = false;
			} else {
				sluttNull++;
				if (begynnelse) startNull++;
			}
		}

		len = langTab.size - (startNull + sluttNull);
		for (i = startNull, j = 0; j < len; j++, i++)
			kortTab[j] = langTab[i];

		return kortTab;
	}
}
