package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Utils.Dice;

public class BlueAlien extends Alien {

    @Override
    public int attack () {
        int val = Dice.rollD6();

        if (val == 4) {
            return 0;
        } else if (val == 3 || val == 5) {
            setDie();
            System.out.println("Alien morreu");
        } else
            System.out.println("Alien MISS");

        return -1;
    }
}
