/**
 * Generisk grensesnitt for hylle som kan holde et gitt antall elementer.
 * En plass i hylla er et tall mellom 0 og storrelsen.
 */
public interface GenHylle<T> {

	/**
	 * @return antall mulige elementer i hylle.
	 */
	public int storrelse();

	/**
	 * Sett inn element paa index, hvis des er ledig.
	 * @param e element som settes inn.
	 * @param i index det skal settes inn i.
	 */
	public void settInn(T e, int i);

	/**
	 * Ser om plass i hylla er ledig.
	 * @param i index som skal sjekkes.
	 * @return true hvis det er ledig, false ellers.
	 */
	public boolean erLedig(int i);

	/**
	 * Hent ut element fra gitt posisjon.
	 * @param i index som skal returneres.
	 * @return element på index i.
	 */
	public T taUt(int i);
}
