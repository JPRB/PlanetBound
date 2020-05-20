package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Utils.Dice;

public class RedAlien extends Alien {


    public RedAlien () {
        super();
    }


    @Override
    public int attack () {
        int val = Dice.rollD6();

        if (val == 6 || val == 5) {
            return 0;
        } else if (val == 2 || val == 1) {
            // setDie();
            return 1;
        }

        return -1;
    }
}
