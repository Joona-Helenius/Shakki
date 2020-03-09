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
	
	public boolean isPathClear(Sijainti alku, Sijainti loppu, PeliLauta shakkilauta) {
		if (alku.getRow() == loppu.getRow()) {
			if (alku.getCol() > loppu.getCol()) {
				for (int i = alku.getCol() +1; i < loppu.getCol(); i++) {
					if (shakkilauta.isPieceAt(alku.getCol(), i)) {
						return false;
					}
				}
			}
			if (alku.getCol() < loppu.getCol()) {
				for (int i = alku.getCol() -1; i> loppu.getCol(); i--) {
					if (shakkilauta.isPieceAt(alku.getCol(), i)) {
						return false;
					}
				}
			}
			return true;
		}
		if (alku.getCol() == loppu.getCol()) {
			if (alku.getRow() > loppu.getRow()) {
				for (int i = alku.getRow() +1; i < loppu.getRow(); i++) {
					if (shakkilauta.isPieceAt(alku.getRow(), i)) {
						return false;
					}
				}
			}
			if (alku.getRow() < loppu.getRow()) {
				for (int i = alku.getRow(); i < loppu.getRow(); i--) {
					if (shakkilauta.isPieceAt(alku.getRow(), i)) {
						return false;
					}
				}
			}
			return true;
		}
		if (alku.getCol() - loppu.getCol() == alku.getRow() - loppu.getRow()) {
			if (alku.getRow() < loppu.getRow() && alku.getCol() < loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow(); i< loppu.getRow(); i++) {
					if (shakkilauta.isPieceAt(alku.getRow()+counter, alku.getCol()+counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getRow() > loppu.getRow() && alku.getCol() < loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow(); i< loppu.getRow(); i++) {
					if (shakkilauta.isPieceAt(alku.getRow()-counter, alku.getCol()+counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getRow() > loppu.getRow() && alku.getCol() > loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow(); i< loppu.getRow(); i++) {
					if (shakkilauta.isPieceAt(alku.getRow()-counter, alku.getCol()-counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getRow() < loppu.getRow() && alku.getCol() > loppu.getCol()) {
				int counter = 1;
				for (int i = alku.getRow(); i< loppu.getRow(); i++) {
					if (shakkilauta.isPieceAt(alku.getRow()+counter, alku.getCol()-counter)) {
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









