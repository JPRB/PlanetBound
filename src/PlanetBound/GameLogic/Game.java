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
        setEstado(new AwaitBeginning(data));
        // estado = new ...
    }

    /*public GameData getGameData () {
        return data;
    }*/

    //	@return the state
    public IEstados getState() {
        return estado;
    }



    private void setEstado (IEstados estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public List<String> getMsgLog() {
        return data.getMsgLog();
    }

    public void clearMsgLog () {
        this.data.clearMsgLog();
    }

    public String getPlanetResources () {
        return data.getSetor().getPlaneta().getRecursos().toString();
    }

    public boolean haveStationShip () {
        return data.getSetor().getSpaceStation() != null;
    }





    /*
        TODO : Methods State Machine
    */
    public void start () {
        setEstado(getState().start());
    }

    public void chooseShip (int value) {
        setEstado(getState().selectShip(value));
    }

    public void Orbit () {
        setEstado(getState().Orbit());
    }

    public void moveToNewPlanet() {
        setEstado(getState().moveToAnotherPlanet());
    }


    public void finish (){
        setEstado(getState().finish());
    }

    public void moveToStationShip () {
        setEstado(getState().moveToStationShip());
    }
}
