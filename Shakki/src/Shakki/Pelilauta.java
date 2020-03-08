package Shakki;

import Pelinappulat.*;

public class Pelilauta {
	private Pelinappula[][] shakkilauta;
	
	public Pelilauta() {
		shakkilauta = new Pelinappula[8][8];
	}
	
	public boolean isPieceAt(int row, int col) {
	return shakkilauta[row][col] != null;
	}
	
	public void movePieceTo(Pelinappula nappula, Sijainti sijainti) {
		if (isPieceAt(sijainti.getRow(), sijainti.getCol())) {
			removePieceAt(sijainti);
		}
		removePieceAt(nappula.getSijainti());
		shakkilauta[sijainti.getRow()][sijainti.getCol()] = nappula;
		nappula.setSijainti(sijainti);
		
	}
	
	public void removePieceAt(Sijainti sijainti) {
		shakkilauta[sijainti.getRow()][sijainti.getCol()] = null;
	}
	
	public Pelinappula getPieceAt(Sijainti sijainti) {
		return shakkilauta[sijainti.getRow()][sijainti.getCol()];
	}
}
