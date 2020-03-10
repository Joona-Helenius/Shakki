package Pelinappulat;

import Shakki.Sijainti;

public class Sotilas extends Pelinappula{
    private boolean hasMoved = false;
    
    public Sotilas(int omistaja, Sijainti sijainti) {
        super(omistaja, sijainti);
    }

    @Override
    public int isValidSotilas(Sijainti s) {
        if (getOmistaja() == 0) {
            if (s.getCol() == getSijainti().getCol() && s.getRow()-getSijainti().getRow() == -1) {
                hasMoved = true;
                return 1;
            }
            if (s.getCol() == getSijainti().getCol() && s.getRow()-getSijainti().getRow() == -2) {
                if(!hasMoved) {
                    hasMoved = true;
                    return 1;
                }
            }
            if (Math.abs(s.getCol() - getSijainti().getCol()) == 1 && s.getRow()-getSijainti().getRow() == -1) {
            	return 2;
            }
        }
        if( getOmistaja() == 1) {
            if (s.getCol() == getSijainti().getCol() && s.getRow()-getSijainti().getRow() == 1) {
                hasMoved = true;
                return 1;
            }
            if (s.getCol() == getSijainti().getCol() && s.getRow()-getSijainti().getRow() == 2) {
                if(!hasMoved) {
                    hasMoved = true;
                    return 1;
                }
            }
            if (Math.abs(s.getCol() - getSijainti().getCol()) == 1 && s.getRow()-getSijainti().getRow() == 1) {
            	return 2;
            }
        }
        return 0;
    }
}