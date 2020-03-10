package Shakki;

import Pelinappulat.*;

public class PeliLauta {
	private Pelinappula[][] shakkilauta;
	private int vuoro = 0;

	public PeliLauta() {
		shakkilauta = new Pelinappula[8][8];
	}

	public int getVuoro() {
        return this.vuoro;
    }
	
	public void setVuoro(int vuoro) {
        this.vuoro = vuoro;
    }
	
	public void setupGame() {
		for(int i=0; i<8;i++) {
			Sotilas s = new Sotilas(1 ,new Sijainti(i, 1));
			shakkilauta[1][i] = s;
			Sotilas s1 = new Sotilas(0, new Sijainti(i, 6));
			shakkilauta[6][i] = s1;
		}
		for (int i=0; i<8;) {
			Torni t = new Torni(1, new Sijainti(i, 0));
			shakkilauta[0][i] = t;
			Torni t1 = new Torni(0, new Sijainti(i, 7));
			shakkilauta[7][i] = t1;
			i += 7;
		}
		for (int i=1; i<7;) {
			Hevonen h = new Hevonen(1, new Sijainti(i, 0));
			shakkilauta[0][i] = h;
			Hevonen h1 = new Hevonen(0, new Sijainti(i, 7));
			shakkilauta[7][i] = h1;
			i += 5;
		}
		for (int i=2; i<6;) {
			Lahetti l = new Lahetti(1, new Sijainti(i, 0));
			shakkilauta[0][i] = l;
			Lahetti l1 = new Lahetti(0, new Sijainti(i, 7));
			shakkilauta[7][i] = l1;
			i += 3;
		}
		Kuningatar k = new Kuningatar(1, new Sijainti(3, 0));
		shakkilauta[0][3] = k;
		Kuningatar k1 = new Kuningatar(0, new Sijainti(3, 7));
		shakkilauta[7][3] = k1;
		Kuningas ku = new Kuningas(1, new Sijainti(4, 0));
		shakkilauta[0][4] = ku;
		Kuningas ku1 = new Kuningas(0, new Sijainti(4, 7));
		shakkilauta[7][4] = ku1;
	}

	public boolean isPieceAt(int col, int row) {
		return shakkilauta[row][col] != null;
	}

	public boolean movePieceTo(Sijainti nappula, Sijainti moveTo) {
		Pelinappula n= getPieceAt(nappula);
		if(n.getOmistaja() == vuoro) {
			if(n instanceof Hevonen) {
				if(n.isValid(moveTo)) {
					if (isPieceAt(moveTo.getCol(), moveTo.getRow()) && (n.getOmistaja()==getPieceAt(moveTo).getOmistaja())) {
						System.out.println("Oma liikkeen päässä");
						return false;
					}
					removePieceAt(moveTo);
					removePieceAt(nappula);
					n.setSijainti(moveTo);
					shakkilauta[moveTo.getRow()][moveTo.getCol()] = n;
					switch (vuoro) {
					case 0: vuoro = 1;
					break;
					case 1: vuoro = 0;
					break;
					}
					return true;
				}
			}
			if(n instanceof Sotilas) {
				switch(n.isValidSotilas(moveTo)) {
				case 0: return false;

				case 1: if(isPieceAt(moveTo.getCol(), moveTo.getRow())) {
					System.out.println("Nappula liikkeen päässä");
					return false;
				}
				if (isPathClear(nappula, moveTo)) {
					removePieceAt(nappula);
					n.setSijainti(moveTo);
					shakkilauta[moveTo.getRow()][moveTo.getCol()] = n;
					switch (vuoro) {
					case 0: vuoro = 1;
					break;
					case 1: vuoro = 0;
					break;
					}
					return true;
				}


				case 2: if (isPieceAt(moveTo.getCol(), moveTo.getRow()) && (n.getOmistaja()==getPieceAt(moveTo).getOmistaja())) {
					System.out.println("Oma liikkeen päässä");
					return false;
				}
				if(isPieceAt(moveTo.getCol(), moveTo.getRow()) && !(n.getOmistaja()==getPieceAt(moveTo).getOmistaja())) {
					removePieceAt(moveTo);
					removePieceAt(nappula);
					n.setSijainti(moveTo);
					shakkilauta[moveTo.getRow()][moveTo.getCol()] = n;
					switch (vuoro) {
					case 0: vuoro = 1;
					break;
					case 1: vuoro = 0;
					break;
					}
					return true;
				}


				}
			}
			if(n.isValid(moveTo))  {
				if (isPieceAt(moveTo.getCol(), moveTo.getRow()) && (n.getOmistaja()==getPieceAt(moveTo).getOmistaja())) {
					System.out.println("Oma liikkeen päässä");
					return false;
				}
				if (isPathClear(nappula, moveTo)) {
					removePieceAt(moveTo);
					removePieceAt(nappula);
					n.setSijainti(moveTo);
					shakkilauta[moveTo.getRow()][moveTo.getCol()] = n;
					switch (vuoro) {
					case 0: vuoro = 1;
					break;
					case 1: vuoro = 0;
					break;
					}
					return true;
				}

			}
			System.out.println("Virheellinen liike");
			return false;	
		}
		System.out.println("Toisen pelaajan vuoro! äläs hätäile!");
		return false;
	}
	public void removePieceAt(Sijainti sijainti) {
		shakkilauta[sijainti.getRow()][sijainti.getCol()] = null;
	}

	public Pelinappula getPieceAt(Sijainti sijainti) {
		return shakkilauta[sijainti.getRow()][sijainti.getCol()];
	}

	public void setPieceTo(Sijainti nappula, Sijainti moveTo) {
        Pelinappula n= getPieceAt(nappula);
        n.setSijainti(moveTo);
        removePieceAt(nappula);
        shakkilauta[moveTo.getRow()][moveTo.getCol()] = n;
    }

	public Pelinappula[][] getPelilauta() {
		return this.shakkilauta;
	}
	public boolean isPathClear(Sijainti alku, Sijainti loppu) {
		if (alku.getCol() == loppu.getCol()) {
			if (alku.getRow() -1 > loppu.getRow()) {
				for (int i = alku.getRow() -1; i > loppu.getRow(); i--) {
					if (isPieceAt(alku.getCol(), i)) {
						return false;
					}
				}
			}
			if (alku.getRow() +1 < loppu.getRow()) {
				for (int i = alku.getRow() +1; i < loppu.getRow(); i++) {
					if (isPieceAt(alku.getCol(), i)) {
						return false;
					}
				}
			}
			return true;
		}
		if (alku.getRow() == loppu.getRow()) {
			if (alku.getCol() -1 > loppu.getCol()) {
				for (int i = alku.getCol() -1; i > loppu.getCol(); i--) {
					if (isPieceAt(i, alku.getRow())) {
						return false;
					}
				}
			}
			if (alku.getCol() +1 < loppu.getCol()) {
				for (int i = alku.getCol() +1; i < loppu.getCol(); i++) {
					if (isPieceAt(i, alku.getRow())) {
						return false;
					}
				}
			}
			return true;
		}
		if (Math.abs(alku.getRow() - loppu.getRow()) == Math.abs(alku.getCol() - loppu.getCol())) {
			if (alku.getCol() +1 < loppu.getCol() && alku.getRow() +1 < loppu.getRow()) {
				int counter = 1;
				for (int i = alku.getCol() +1; i < loppu.getCol(); i++) {
					if (isPieceAt(alku.getCol()+counter, alku.getRow()+counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getCol() -1 > loppu.getCol() && alku.getRow() +1 < loppu.getRow()) {
				int counter = 1;
				for (int i = alku.getCol() -1; i > loppu.getCol(); i--) {
					if (isPieceAt(alku.getCol()-counter, alku.getRow()+counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getCol() -1 > loppu.getCol() && alku.getRow() -1 > loppu.getRow()) {
				int counter = 1;
				for (int i = alku.getCol() -1 ; i > loppu.getCol(); i--) {
					if (isPieceAt(alku.getCol()-counter, alku.getRow()-counter)) {
						return false;
					}
					counter++;
				}
			}
			if (alku.getCol() +1 < loppu.getCol() && alku.getRow() -1 > loppu.getRow()) {
				int counter = 1;
				for (int i = alku.getCol() +1 ; i < loppu.getCol(); i++) {
					if (isPieceAt(alku.getCol()+counter, alku.getRow()-counter)) {
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