package Pelinappulat;

import Shakki.Sijainti;

public class Torni extends Pelinappula{

	public Torni(int omistaja, Sijainti sijainti) {
		super(omistaja, sijainti);
	}
	
	@Override
	public boolean isValid(Sijainti s) {
		if(Math.abs(s.getCol()-getSijainti().getCol())==0) {
			return true;
		}
		if(Math.abs(s.getRow()-getSijainti().getRow())==0) {
			return true;
		}
		return false;
	}
	
}
