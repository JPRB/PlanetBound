package PlanetBound.GameLogic.Dados.Eventss;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Utils.Enums;

public class NoEventEvent extends Event {

    public NoEventEvent (GameData data) {
        super(data);
    }

    @Override
    public void aplicaEvento () {
        data.addMsgLog(Enums.Events.NoEvent.getDescription());
    }
}
