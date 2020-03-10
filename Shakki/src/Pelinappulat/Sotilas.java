package Pelinappulat;

import Shakki.Sijainti;

public class Sotilas extends Pelinappula{
	private boolean hasMoved = false;
	
	public Sotilas(int omistaja, Sijainti sijainti) {
		super(omistaja, sijainti);
	}
	
	@Override
	public boolean isValid(Sijainti s) {
		if (getOmistaja() == 0) {
			if (s.getCol() == getSijainti().getCol() && s.getRow()-getSijainti().getRow() == 1) {
				
				}
			}
			if (s.getCol() == getSijainti().getCol() && s.getRow()-getSijainti().getRow() == 2) {
				
			}
		}
		if( getOmistaja() == 1) {
			
		}
		return false;
	}
}
