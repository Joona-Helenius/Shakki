package Pelinappulat;

import Shakki.Sijainti;

public class Hevonen extends Pelinappula{
	public Hevonen(int omistaja, Sijainti sijainti) {
		super(omistaja,sijainti);
	}
	
	@Override
	public boolean isValid(Sijainti s) {
		if(Math.abs(s.getCol()-getSijainti().getCol()) == 1 && Math.abs(s.getRow()-getSijainti().getRow()) == 2) {
			return true;
		}
		if(Math.abs(s.getCol()-getSijainti().getCol()) == 2 && Math.abs(s.getRow()-getSijainti().getRow()) == 1) {
			return true;	
		}
		return false;
	}
}
