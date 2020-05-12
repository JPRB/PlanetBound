package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;

public abstract class EstadosAdapter implements IEstados {

    // Reference to GameData (Class which manipulate data)

    private GameData data;


    public EstadosAdapter(GameData data) {
        this.data = data;
    }

    public GameData getGameData() {
        return data;
    }

    public void setData(GameData data) {
        this.data = data;
    }



    // TODO : Definir implementações vazias para os métodos do interface IEstado

    @Override
    public IEstados start () {
        return this;
    }

    @Override
    public IEstados selectShip (int value) {
        return this;
    }

    @Override
    public IEstados Orbit () {
        return this;
    }

    @Override
    public IEstados moveToAnotherPlanet () { return this; }

    @Override
    public IEstados LandingPlanet () {
        return this;
    }

    @Override
    public IEstados finish () {
        return this;
    }

    @Override
    public IEstados collectResource () {
        return this;
    }

    @Override
    public IEstados moveToStationShip () {
        return this;
    }
}
