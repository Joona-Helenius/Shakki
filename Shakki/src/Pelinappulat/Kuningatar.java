package Pelinappulat;

import Shakki.Sijainti;

public class Kuningatar extends Pelinappula{
	public Kuningatar(int omistaja, Sijainti sijainti) {
		super(omistaja,sijainti);
	}
	
	@Override
	public boolean isValid(Sijainti s) {
		if(Math.abs(s.getCol()-getSijainti().getCol())==Math.abs(s.getRow()-getSijainti().getRow())) {
			return true;
		}
		if(Math.abs(s.getCol()-getSijainti().getCol())==0) {
			return true;
		}
		if(Math.abs(s.getRow()-getSijainti().getRow())==0) {
			return true;
		}
		return false;
	}

}
