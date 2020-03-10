package Peli;

public class Data {
	
	/**
	 * Tietokannan apuluokka
	 */
	
	public String tyyppi;
	public int x;
	public int y;
	public boolean b;
	
	public Data(String tyyppi,int x,int y,boolean b) {
		this.tyyppi = tyyppi;
		this.x = x;
		this.y = y;
		this.b = b;
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
	
	public boolean getB() {
		return this.b;
	}
}
