package PlanetBound.GameLogic.Dados.Eventss;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Utils.Enums;

public class CrewDeathEvent extends Event {

    public CrewDeathEvent (GameData data) {
        super(data);
    }

    @Override
    public void aplicaEvento () {
        data.getNave().crewMemberDie();

        data.addMsgLog(Enums.Events.CrewDeath.getDescription());
    }
}
