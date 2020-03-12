package Pelinappulat;

import Shakki.*;

/**
 * Perittävä luokka eri tyyppisille pelinappuloille, jossa on yleisiä pelinappuloiden ominaisuuksia. 
 * Luokan omistaja attribuutti kertoo, kenen nappula on kyseessä, 0 = valkoinen, 1 = musta.
 */

public class Pelinappula {
	protected int omistaja;
	protected Sijainti sijainti;
	
	public Pelinappula(int omistaja, Sijainti sijainti) {
		this.omistaja = omistaja;
		this.sijainti = sijainti;
	}
	public Sijainti getSijainti() {
		return this.sijainti;
	}
	public void setSijainti(Sijainti sijainti) {
		this.sijainti = sijainti;
	}
	public int getOmistaja() {
		return omistaja;
	}
	
	/**
     * Tarkistaa liikkeen laillisuuden. Palauttaa true jos laillinen, false jos ei. Overridataan jokaisessa nappulaluokassa.
     */
	
	public boolean isValid(Sijainti s) {
		return false;
	}
	
	/**
     * Tarkistaa liikkeen laillisuuden. Palauttaa 0, jos laiton liike, 1 jos laillinen liike liikkuen vertikaalisesti, 
     * ja 2 jos laillinen liike liikkuen diagonaalisesti.
     */
	
	public int isValidSotilas(Sijainti s) {
		return 0;
	}
}
