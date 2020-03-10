package Shakki;

public class Sijainti {
	private int row;
	private int col;
	
	public Sijainti(int col, int row) {
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
