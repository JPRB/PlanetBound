package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;

public class AwaitShipSelection extends EstadosAdapter {

    public AwaitShipSelection (GameData data) {
        super(data);
    }


    @Override
    public IEstados selectShip (int nave) {

        getGameData().chooseShip(nave);

        // System.out.println(getGameData().getNave());
        // Criar 1º planeta, e ver se tem estação..
        getGameData().setSetor();

        return new PlanetOrbit(getGameData());
    }
}