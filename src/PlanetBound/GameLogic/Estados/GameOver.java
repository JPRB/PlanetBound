package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;

public class GameOver extends EstadosAdapter{

    public GameOver (GameData data) {
        super(data);
    }


    @Override
    public IEstados playAgain () {
        return new AwaitShipSelection(getGameData());
    }
}
