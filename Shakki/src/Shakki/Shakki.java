package Shakki;

import Pelinappulat.*;

public class Shakki {
	private Pelilauta shakkilauta;
	
	public Shakki() {
		shakkilauta = new Pelilauta();
		setBoard();
	}
	
	public void setBoard() {
		for (int i = 0; i < 8; i++) {
			shakkilauta[1][i] = new Sotilas(1, new Sijainti(1, i));
			shakkilauta[6][i] = new Sotilas(2, new Sijainti(6, i));
		}
		
	}
}
