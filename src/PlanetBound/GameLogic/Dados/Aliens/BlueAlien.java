package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;

public class BlueAlien extends Alien {

    @Override
    public int attack () {
        int val = Dice.rollD6();

        if (val == 4) {
            return 0;
        } else if (val >= 3 && val <= 5) {
            return 1;
        }

        return -1;
    }

    @Override
    public Enums.AlienType getAlienType () {
        return Enums.AlienType.BLUE_ALIEN;
    }
}
