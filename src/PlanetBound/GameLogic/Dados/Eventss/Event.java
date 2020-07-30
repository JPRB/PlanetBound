package PlanetBound.GameLogic.Dados.Eventss;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Util;

public abstract class Event {

    protected GameData data;

    protected Event(GameData data) {
        this.data = data;
    }

    public abstract void aplicaEvento();

}
