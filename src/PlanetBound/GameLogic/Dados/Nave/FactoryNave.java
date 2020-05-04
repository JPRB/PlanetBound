package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Dados.Nave.Explorer;
import PlanetBound.GameLogic.Dados.Nave.Militar;
import PlanetBound.GameLogic.Dados.Nave.Nave;

public class FactoryNave {

        public static Nave criaNave(String item) {
            if (item.equals("Militar")) {
                return new Militar();
            } else if (item.equals("Explorer")) {
                return new Explorer();
            } else return null;
        }

    public static Nave criaNave(int item) {
        if (item == 1) {
            return new Militar();
        } else if (item == 2) {
            return new Explorer();
        } else return null;
    }
}
