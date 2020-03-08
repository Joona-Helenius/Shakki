package Pelinappulat;

import Shakki.*;

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
}
