package PlanetBound.GameLogic;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Estados.AwaitBeginning;
import PlanetBound.GameLogic.Estados.IEstados;
import PlanetBound.GameLogic.Utils.Enums;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    private String getNave () {
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
    } // ?????

    public int getCargoMax (){
        return returnNave().getCarga().getMaxCargo();
    }

    private Map<Enums.EResources, int> getCargo () {
        Map<Enums.EResources, int> res = new HashMap<Enums.EResources, int>();

        Stream.of(Enums.EResources.values()).map(e ->
                res.put(e, returnNave().getCarga().getResource(e.name()).getResourceVal())
        );

        return res;
    }


    public void getRedResource(){
        getCargo().get(Enums.EResources.red);
    }

    public void getBlackResource(){
        getCargo().get(Enums.EResources.black);
    }

    public void getBlueResource(){
        getCargo().get(Enums.EResources.blue);
    }

    public void getGreenResource(){
        getCargo().get(Enums.EResources.green);
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
