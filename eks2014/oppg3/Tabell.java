public class Tabell {
	public static int[] fjernNuller(int[] langTab) {
		int i, j, v, startNull, sluttNull;
		boolean begynnelse = true;
		int[] kortTab = new int[langTab.length];

		startNull = sluttNull = 0;
		for (i = 0; i < langTab.length; i++) {
			v = langTab[i];
			if (v != 0) {
				sluttNull = 0;
				if (begynnelse) begynnelse = false;
			} else {
				sluttNull++;
				if (begynnelse) startNull++;
			}
		}

		int len = langTab.length - (startNull + sluttNull);
		for (i = startNull, j = 0; j < len; j++, i++)
			kortTab[j] = langTab[i];

		return kortTab;
	}
}
