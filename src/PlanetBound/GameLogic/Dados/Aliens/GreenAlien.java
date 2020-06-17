package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;

public class GreenAlien extends Alien {

    @Override
    public int attack () {
        int val = Dice.rollD6();

        if (val == 1 || val == 2) {
            return 0;
        } else if (val >= 4 && val <= 6) {
            return 1;
        }

        return -1;
    }

    @Override
    public Enums.AlienType getAlienType () {
        return Enums.AlienType.GREEN_ALIEN;
    }
}
