package PlanetBound.GameLogic.Dados.Events;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Util;

public class CargoLossEvent extends Event {


    public CargoLossEvent (GameData data) {
        super(data);
    }

    @Override
    public void aplicaEvento () {
        try {
            int random = Dice.rollD3();
            Resources x = Resources.randomResource(random);

            final boolean added = data.getNave().getCarga().removeResources(x);

            data.addMsgLog(Enums.Events.CargoLoss.getDescription());

            if (added)
                data.addMsgLog("Perdes-te " + random + (random > 1 ? " recursos " : " recurso ") + x.getCor());
            else
                data.addMsgLog("Não foi possivel remover recursos");


        } catch (NullPointerException e) {
            Util.pError(e.getMessage());
        }
    }

}
