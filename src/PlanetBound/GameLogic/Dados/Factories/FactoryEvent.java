package PlanetBound.GameLogic.Dados.Factories;

import PlanetBound.GameLogic.Dados.Events.*;
import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Utils.Util;

public class FactoryEvent {

    public static Event criaEvento (GameData data) {
        switch (Util.probability(6)) {
            case 1:
                return new CrewDeathEvent(data);
            case 2:
                return new SalvageShipEvent(data);
            case 3:
                return new CargoLossEvent(data);
            case 4:
                return new FuelLossEvent(data);
            case 5:
                return new NoEventEvent(data);
            case 6:
                return new CrewRescueEvent(data);
        }
        return null;
    }
}
