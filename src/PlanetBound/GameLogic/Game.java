package PlanetBound.GameLogic;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
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

    //	@return the state
    public IEstados getState () {
        return estado;
    }

    private void setEstado (IEstados estado) {
        this.estado = estado;
    }

    @Override
    public String toString () {
        return data.toString();
    }

    public List<String> getMsgLog () {
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


    public String getNave () {
        return data.getNaveToString();
    }

    // Methods to GUI


    // Nave:: Methods
    private Nave returnNave (){
        return data.getNave();
    }

    public int getFuel () {
        return returnNave().getCombustivel();
    }

    public int getOfficers () {
        return returnNave().getOfficers();

    }

    public int getShield (){
        return returnNave().getShields();
    }

    public int getMax (){
        return returnNave().getCarga().getCargoLvl();
    }

    public int getCargoMax (){
        return returnNave().getCarga().getMaxCargo();
    }


    // Planet Methods



    /*
            TODO : Methods State Machine
        */
    public void start () {
        setEstado(getState().start());
    }

    public void chooseShip (int value) {
        setEstado(getState().selectShip(value));
    }

    // Move to New Planet || To orbit in planet || to Ship in Planet Orbit
    public void move () {
        setEstado(getState().move());
    }

    public void moveToSpaceStation () {
        setEstado(getState().moveToSpaceStation());
    }

    public void getItemsSpaceStations (int item) {
        setEstado(getState().getItemsSpaceStations(item));
    }

    public void playAgain () {
        setEstado(getState().playAgain());
    }

    public void explorePlanet () {
        setEstado(getState().explore());
    }

    public void moveDrone (int value) {
        setEstado(getState().moveDrone(value));
    }

    public void convertResources(int value){
        setEstado(getState().convertResources(value));
    }

    public void doEvent (int val) {
        setEstado(getState().aplicaEvento(val));
    }
}
