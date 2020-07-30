package PlanetBound.GameLogic.Dados.Eventss;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Util;

public class FuelLossEvent extends Event {

    public FuelLossEvent (GameData data) {
        super(data);
    }

    @Override
    public void aplicaEvento () {
        try {
            data.getNave().wasteFuel(1);
            data.addMsgLog(Enums.Events.FuelLoss.getDescription());
        } catch (NullPointerException e) {
            Util.pError(e.getMessage());
        }
    }
}
