package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Utils.Dice;

public class GreenAlien extends Alien {
    @Override
    public int attack () {
        int val = Dice.rollD6();

        if (val == 1 || val == 2) {
            return 0;
        } else if (val == 4 || val == 6) {
            setDie();
            System.out.println("Alien morreu");
        } else
            System.out.println("Alien MISS");

        return -1;
    }
}
