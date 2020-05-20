package PlanetBound.GameLogic.Dados.Events;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Utils.Enums;

public class CrewRescueEvent extends Event {

    public CrewRescueEvent (GameData data) {
        super(data);
    }

    @Override
    public void aplicaEvento () {
        Nave nave = data.getNave();
        data.addMsgLog(Enums.Events.CrewRescue.getDescription());

        // ver se é preciso Crew Member
        if (nave.getOfficers() < 6) {

            nave.addCrewMember();

            data.addMsgLog("Foi adicionado um novo officer.");
        } else
            data.addMsgLog("Não foi adicionado à crew, porque já está completa");
    }
}
