package Shakki;

import Pelinappulat.*;

public class Shakki {
	public PeliLauta shakkilauta;
	
	public Shakki() {
		shakkilauta = new PeliLauta();
		setBoard();
	}
	
	public void setBoard() {
		for (int i = 0; i < 8; i++) {
			shakkilauta.setPieceTo(new Sotilas(1, new Sijainti(i, 1)));
			shakkilauta.setPieceTo(new Sotilas(2, new Sijainti(i, 6)));
		}
	}
}
