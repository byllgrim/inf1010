public class Sorterer implements Runnable {
    private String[] t;
    private Sammenfletter sf;

    public Sorterer(Sammenfletter sf, String[] tabell) {
        this.sf = sf;
        t = tabell;
    }

    public void run() {
        sorterTabell();
        sf.leverTabell(t);
    }

    private void sorterTabell() {
        for(int i = 0; i < t.length-1; i++) {
            if (t[i].compareTo(t[i+1]) > 0) {
                finnPlass(i+1);
            }
        }
    }

    private void finnPlass(int i) {
        String ord = t[i];
        t[i] = t[i-1];
        t[i-1] = null;
        for(int j = 0; j < i; j++) {
            if (t[j] == null) {
                t[j] = ord;
                return;
            }
            if (ord.compareTo(t[j]) < 0) {
                String tmp = t[j];
                t[j] = ord;
                ord = tmp;
            }
        }
    }
}

/* Sorteringsalgoritme
 *
 * 1. Start på index 0
 * 2. Sammenlign med neste
 * 3. (neste er større) ? i++ 2 : 4
 * 4. tmp = neste
 * 5. Sammenlign fra toppen
 * 6. tmp er mindre ? sett inn : (i++ repeter 6)
 */
