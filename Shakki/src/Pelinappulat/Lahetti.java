package Pelinappulat;

import Shakki.Sijainti;

public class Lahetti extends Pelinappula{
	
	public Lahetti(int omistaja, Sijainti sijainti) {
		super(omistaja, sijainti);
	}
	
	@Override
	public boolean isValid(Sijainti s) {
		if(Math.abs(s.getCol()-getSijainti().getCol())==Math.abs(s.getRow()-getSijainti().getRow())) {
			return true;
		}
		return false;
	}
}
