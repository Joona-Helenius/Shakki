package Pelinappulat;

import Shakki.Sijainti;

public class Kuningas extends Pelinappula{
	public Kuningas(int omistaja, Sijainti sijainti) {
		super(omistaja,sijainti);
	}
	
	@Override
	public boolean isValid(Sijainti s) {
		if(Math.abs(s.getCol()-getSijainti().getCol()) + Math.abs(s.getRow()-getSijainti().getRow())<=2) {
			if(Math.abs(s.getCol()-getSijainti().getCol())==2) {
				return false;
			}
			if(Math.abs(s.getRow()-getSijainti().getRow())==2) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	
}
