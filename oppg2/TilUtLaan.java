/**
 * Representerer objekter som kan laanes ut.
 */
public interface TilUtLaan {

	/**
	 * Gjenstanden er naa utlaant til laaner og kan derfor
	 * ikke laanes ut til andre foer den er levert tilbake.
	 * @return true if successful, false otherwise.
	 */
	public boolean laanUtTil(String laaner);

	/**
	 * Leverer tilbake gjenstanden ved aa sette
	 * utlaaner til null.
	 */
	public void leverTilbake();
}
