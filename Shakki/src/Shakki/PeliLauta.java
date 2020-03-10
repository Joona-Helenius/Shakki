package Shakki;

import Pelinappulat.*;

public class PeliLauta {
	private Pelinappula[][] shakkilauta;
	
	public PeliLauta() {
		shakkilauta = new Pelinappula[8][8];
	}
	
	i
	
	public void removePieceAt(Sijainti sijainti) {
		shakkilauta[sijainti.getRow()][sijainti.getCol()] = null;
	}
	
	public Pelinappula getPieceAt(Sijainti sijainti) {
		return shakkilauta[sijainti.getRow()][sijainti.getCol()];
	}
	
	public void setPieceTo(Pelinappula nappula) {
		shakkilauta[nappula.getSijainti().getRow()][nappula.getSijainti().getCol()] = nappula;
	}
	public boolean isPathClear(Sijainti alku, Sijainti loppu) {
		if (alku.getRow() == loppu.getRow()) {
			if (alku.getCol() -1 > loppu.getCol()) {
				for (int i = alku.getCol() -1; i > loppu.getCol(); i--) {
					if (isPieceAt(alku.getRow(), i)) {
						return false;
					}
				}
			}
			if (alku.getCol() +1 < loppu.getCol()) {
				for (int i = alku.getCol() +1; i < loppu.getCol(); i++) {
					if (isPieceAt(alku.getRow(), i)) {
						return false;
					}
				}
			}
			return true;
		}
		if (alku.getCol() == loppu.getCol()) {
			if (alku.getRow() -1 > loppu.getRow()) {
				for (int i = alku.getRow() -1; i > loppu.getRow(); i--) {
					if (isPieceAt(i, alku.getCol())) {
						return false;
					}
				}
			}
			if (alku.getRow() +1 < loppu.getRow()) {
				for (int i = alku.getRow() +1; i < loppu.getRow(); i++) {
					if (isPieceAt(i, alku.getCol())) {
						return false;
					}
				}
			}
			return true;
		}
		if (Math.abs(alku.getCol() - loppu.getCol()) == Math.abs(alku.getRow() - loppu.getRow())) {
			if (alku.getRow() +1 < loppu.getRow() && alku.getCol() +1 < loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow() +1; i < loppu.getRow(); i++) {
					if (isPieceAt(alku.getRow()+counter, alku.getCol()+counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getRow() -1 > loppu.getRow() && alku.getCol() +1 < loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow() -1; i > loppu.getRow(); i--) {
					if (isPieceAt(alku.getRow()-counter, alku.getCol()+counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getRow() -1 > loppu.getRow() && alku.getCol() -1 > loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow() -1 ; i > loppu.getRow(); i--) {
					if (isPieceAt(alku.getRow()-counter, alku.getCol()-counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getRow() +1 < loppu.getRow() && alku.getCol() -1 > loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow() +1 ; i < loppu.getRow(); i++) {
					if (isPieceAt(alku.getRow()+counter, alku.getCol()-counter)) {
						return false;
					}
					counter++;
				}
			}
			return true;
		}
		return false;
	}
}
