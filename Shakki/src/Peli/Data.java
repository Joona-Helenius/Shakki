package Peli;

/**
 * Tietokannan apuluokka, jolla dataa tallennetaan tietokantaan. Attribuuti tyyppi on nappulan tyyppi, x on x-koordinaatti ja y on y-koordinaatti
 */

public class Data {
		
	public String tyyppi;
	public int x;
	public int y;
	
	public Data(String tyyppi,int x,int y) {
		this.tyyppi = tyyppi;
		this.x = x;
		this.y = y;
	}
	
	public String getTyyppi() {
		return this.tyyppi;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}
