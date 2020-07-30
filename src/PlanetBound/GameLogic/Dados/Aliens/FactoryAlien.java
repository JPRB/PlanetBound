package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Dados.Setor.Planetas.*;
import PlanetBound.GameLogic.Utils.Util;

public class FactoryAlien {

    public static Alien criaAlien () {

        switch (Util.probability(4)){
            case 1: return new BlackAlien();
            case 2: return new BlueAlien();
            case 3: return new RedAlien();
            case 4: return new GreenAlien();
        }
        return null;
    }
}
