package Shakki;

import PeliNappulat.*;

public class Shakki {
	public PeliLauta shakkilauta;
	
	public Shakki() {
		shakkilauta = new PeliLauta();
		setBoard();
	}
	
	public void setBoard() {
		for (int i = 0; i < 8; i++) {
			shakkilauta.setPieceTo(new Sotilas(1, new Sijainti(1, i)));
			shakkilauta.setPieceTo(new Sotilas(2, new Sijainti(6, i)));
		}
	}
}
