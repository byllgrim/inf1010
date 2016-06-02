public class Sammenfletter { //monitor
    private int antTraader;
    private int ferdige = 0;
    private String[] morTabell = null;

    public Sammenfletter(int antTraader) {
        this.antTraader = antTraader;
    }

    public synchronized void leverTabell(String[] t) {
        ferdige++;
        notify();
        flettSammen(t);
    }

    private void flettSammen(String[] delTabell) {
        if (morTabell == null) {
            morTabell = delTabell;
            return;
        }
        String[] ny = new String[delTabell.length + morTabell.length];
        int i, m, d;
        for (i = m = d = 0; i < ny.length; i++) {
            if (d >= delTabell.length) {
                ny[i] = morTabell[m++];
                continue;
            } else if (m >= morTabell.length) {
                ny[i] = delTabell[d++];
                continue;
            }

            if (morTabell[m].compareTo(delTabell[d]) < 0){
                ny[i] = morTabell[m++];
            } else {
                ny[i] = delTabell[d++];
            }
        }

        morTabell = ny;
    }

    public synchronized void vent() {
        while(ferdige != antTraader) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Uforventet feil i vent()");
            }
        }
    }
    public String[] hentTabell(){
        return morTabell;
    }
}
