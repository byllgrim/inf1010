import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Sort {
    private static Scanner innfil;
    private static PrintWriter utfil;
    private static int antTraader;
    private static int antOrd;
    private static Sammenfletter sf;

    public static void main(String[] args) {
        try {
            antTraader = Integer.parseInt(args[0]);
            innfil = new Scanner(new File(args[1]));
            utfil = new PrintWriter(new File(args[2]));

            antOrd = lesAntOrd();
            String[] ord = lesOrd();

            sf = new Sammenfletter(antTraader);
            opprettTraader(sf, ord);
            sf.vent();

            skrivFil();
        } catch (NumberFormatException e) {
            System.err.println("Argument 2 skal vaere et heltall");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Feil antall argumenter!");
        } catch (FileNotFoundException e) {
            System.err.println("Filen eksisterer ikke! " + e.getMessage());
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        } catch (DataFormatException e) {
            System.err.println("Feil i interne datastrukturer!");
        }
    }

    private static int lesAntOrd() throws ParseException {
        int antOrd;
        try {
            antOrd = Integer.parseInt(innfil.nextLine());
        } catch (NumberFormatException e) {
            throw new ParseException("Feil i innfil, forste linje skal vaere et heltall", 0);
        } catch (NoSuchElementException e) {
            throw new ParseException("Forste linje mangler, skal vaere et heltall", 0);
        }
        return antOrd;
    }

    private static String[] lesOrd() throws ParseException {
        String[] ord = new String[antOrd];
        int i;
        for (i = 0; i < antOrd && innfil.hasNextLine(); i++) {
            ord[i] = innfil.nextLine();
        }

        if (i != antOrd) {
            throw new ParseException("Advarsel! For faa ord i filen", i);
        }

        if (innfil.hasNextLine()) {
            throw new ParseException("Advarsel! Antall ord stemmer ikke med filen", i);
        }

        return ord;
    }

    private static void opprettTraader(Sammenfletter sf, String[] ord) {
        int n = antOrd/antTraader;
        for(int i=0; i < antTraader; i++) {
            int til = (i == antTraader-1) ? (antOrd) : (i+1)*n;
            String[] delTabell = Arrays.copyOfRange(ord, i*n, til);
            Sorterer sorterer = new Sorterer(sf, delTabell);
            new Thread(sorterer).start();
        }
    }
    private static void skrivFil() throws DataFormatException {
        if (!erKorrekt())
            throw new DataFormatException();

        utfil.println(antOrd);
        String[] t = sf.hentTabell();
        for(int i = 0; i < t.length; i++){
            utfil.println(t[i]);
        }
        utfil.close();
    }
    private static boolean erKorrekt() {
        String[] t = sf.hentTabell();
        boolean riktigLengde = (t.length == antOrd);
        boolean ikkeNull = (t[t.length-1] != null);
        boolean sortert = true;
        for (int i = 0; i < t.length-1; i++) {
            if (t[i].compareTo(t[i+1]) > 0) {
                sortert = false;
                break;
            }
        }
        return riktigLengde && ikkeNull && sortert;
    }
}
