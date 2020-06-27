package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;

public class BlackAlien extends Alien {


    public BlackAlien () {
        super();
    }

    public BlackAlien (boolean morto) {

    }


    @Override
    public int attack () {
        int val = Dice.rollD6();

        if (val == 1) {
            return 0;
        } else if (val == 5 || val == 6) {
            return 1;
        }
        return -1;
    }

    @Override
    public Enums.AlienType getAlienType () {
        return Enums.AlienType.BLACK_ALIEN;
    }
}
