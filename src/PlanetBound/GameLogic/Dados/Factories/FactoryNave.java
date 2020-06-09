package PlanetBound.GameLogic.Dados.Factories;

import PlanetBound.GameLogic.Dados.Nave.Explorer;
import PlanetBound.GameLogic.Dados.Nave.Militar;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Utils.Enums;

public class FactoryNave {

        public static Nave criaNave(String item) {
            if (item.equals("Militar")) {
                return new Militar();
            } else if (item.equals("Explorer")) {
                return new Explorer();
            } else return null;
        }

    public static Nave criaNave(int item) {
        if (item == Enums.ShipType.Militar.getValue()) {
            return new Militar();
        } else if (item == Enums.ShipType.Explorer.getValue()) {
            return new Explorer();
        } else return null;
    }
}
