package Shakki;

import Pelinappulat.*;

public class PeliLauta {
	private Pelinappula[][] shakkilauta;
	
	public PeliLauta() {
		shakkilauta = new Pelinappula[8][8];
	}
	
	public void setupGame() {
		for(int i=0; i<8;i++) {
			Sotilas s = new Sotilas(1 ,new Sijainti(1,i));
			shakkilauta[1][i] = s;
			Sotilas s1 = new Sotilas(0, new Sijainti(6, i));
			shakkilauta[6][i] = s1;
		}
	}
	
	public boolean isPieceAt(int row, int col) {
		return shakkilauta[row][col] != null;
	}
	
	public boolean movePieceTo(Sijainti nappula, Sijainti moveTo) {
		Pelinappula n= getPieceAt(nappula);
		if(isPathClear(nappula, moveTo)) {
			if (isPieceAt(moveTo.getRow(), moveTo.getCol()) && !(n.getOmistaja()==getPieceAt(moveTo).getOmistaja())) {
				removePieceAt(moveTo);
			}
			if (isPieceAt(moveTo.getRow(), moveTo.getCol()) && n.getOmistaja()==getPieceAt(moveTo).getOmistaja()) {
				System.out.println("Oma tiellä");
				return false;
			}
			removePieceAt(n.getSijainti());
			shakkilauta[moveTo.getRow()][moveTo.getCol()] = n;
			n.setSijainti(moveTo);
			
			return true;	
		}
		System.out.println("Ei onnistunut");
		return false;
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
