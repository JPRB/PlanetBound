package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;

public abstract class EstadosAdapter implements IEstados {

    // Reference to GameData (Class which manipulate data)

    private GameData data;


    public EstadosAdapter (GameData data) {
        this.data = data;
    }

    public GameData getGameData () {
        return data;
    }

    public void setData (GameData data) {
        this.data = data;
    }


    // TODO : Definir implementações vazias para os métodos do interface IEstado

    @Override
    public IEstados start () {
        return this;
    }

    @Override
    public IEstados finish () {
        return this;
    }


    @Override
    public IEstados selectShip (int value) {
        return this;
    }

    @Override
    public IEstados move () {
        return this;
    }


    @Override
    public IEstados moveToSpaceStation () {
        return this;
    }

    @Override
    public IEstados getItemsSpaceStations (int item) {
        return this;
    }

    @Override
    public IEstados playAgain () {
        return this;
    }

    @Override
    public IEstados explore () {
        return this;
    }

    @Override
    public IEstados moveDrone (int value) {
        return this;
    }


    @Override
    public IEstados convertResources (int value) {
        return this;
    }

    @Override
    public IEstados aplicaEvento (int value) {
        return this;
    }
}
