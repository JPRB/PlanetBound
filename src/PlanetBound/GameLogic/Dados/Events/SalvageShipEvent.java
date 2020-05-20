package PlanetBound.GameLogic.Dados.Events;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Util;

public class SalvageShipEvent extends Event {


    public SalvageShipEvent (GameData data) {
        super(data);
    }

    @Override
    public void aplicaEvento () {
        try {
            int random = Dice.rollD6();
            Resources x = Resources.randomResource(random);

            final boolean added = data.getNave().getCarga().addResource(x);
            data.addMsgLog(Enums.Events.SalvageShip.getDescription());

            if (added)
                data.addMsgLog("Recolhes-te " + random + (random > 1 ? " recursos " : " recurso ") + x.getCor());
            else
                data.addMsgLog("Não foi possivel adicionar recursos");

        } catch (NullPointerException e) {
            Util.pError(e.getMessage());
        }
    }
}
