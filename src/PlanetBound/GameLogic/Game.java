package PlanetBound.GameLogic;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Estados.AwaitBeginning;
import PlanetBound.GameLogic.Estados.IEstados;

import java.util.List;

public class Game {

    private IEstados estado;

    private GameData data;

    public Game () {
        data = new GameData();
        // Definir o estado inicial
        setEstados(new AwaitBeginning(data));
        // estado = new ...
    }

    public GameData getGameData () {
        return data;
    }



    //	@return the state
    public IEstados getState() {
        return estado;
    }

    public void setEstados(IEstados estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public List<String> getMsgLog() {
        return data.getMsgLog();
    }


    // TODO : Methods State Machine

    public void chooseShip (int value){
        setEstados(getState().selectShip(value));
    }

    public void start () {
        setEstados(getState().start());
    }

    public void finish (){
        setEstados(getState().finish());
    }


}
