package Shakki;

import Pelinappulat.*;

public class PeliLauta {
	private Pelinappula[][] shakkilauta;
	
	public PeliLauta() {
		shakkilauta = new Pelinappula[8][8];
	}
	
	public boolean isPieceAt(int row, int col) {
	return shakkilauta[row][col] != null;
	}
	
	public boolean movePieceTo(Pelinappula nappula, Sijainti sijainti) {
		if (isPieceAt(sijainti.getRow(), sijainti.getCol())) {
			removePieceAt(sijainti);
		}
		removePieceAt(nappula.getSijainti());
		shakkilauta[sijainti.getRow()][sijainti.getCol()] = nappula;
		nappula.setSijainti(sijainti);
		
		return true;	
	}
	
	public void removePieceAt(Sijainti sijainti) {
		shakkilauta[sijainti.getRow()][sijainti.getCol()] = null;
	}
	
	public Pelinappula getPieceAt(Sijainti sijainti) {
		return shakkilauta[sijainti.getRow()][sijainti.getCol()];
	}
	
	public void setPieceTo(Pelinappula nappula) {
		shakkilauta[nappula.getSijainti().getRow()][nappula.getSijainti().getCol()] = nappula;
	}
}
