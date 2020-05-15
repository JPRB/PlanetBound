package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Utils.Dice;

public class BlackAlien extends Alien {


    @Override
    public int attack () {
        int val = Dice.rollD6();

        if (val == 1) {
            return 0;
        } else if (val == 5 || val == 6) {
            this.setDie();
            System.out.println("Alien morreu");
        } else
            System.out.println("Alien MISS");
        return -1;
    }
}
