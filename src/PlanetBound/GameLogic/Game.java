package PlanetBound.GameLogic;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Estados.AwaitBeginning;
import PlanetBound.GameLogic.Estados.EstadoID;
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


    // ********************** Methods to GUI ************************************


    // Nave:: Methods
    private Nave returnNave () {
        return data.getNave();
    }

    public String getNaveType () {
        return returnNave().getNaveType();
    }


    public int getFuel () {
        return returnNave().getCombustivel();
    }


    public int getFuelMax () {
        return returnNave().getCombustivelMax();
    }

    public int getOfficers () {
        return returnNave().getOfficers();

    }

    public int getWeapon () {
        return returnNave().getWeapon();
    }

    public int getShield () {
        return returnNave().getShields();
    }

    public int getMax () {
        return returnNave().getCarga().getCargoLvl();
    } // ?????

    // Cargo MAX TO GUI
    public int getCargoMax () {
        return returnNave().getCarga().getMaxCargo();
    }


    // Aux to GUI
    private int getCargo (Enums.EResources resource) {

        return returnNave().getCarga().getResource(resource.toString()).getResourceVal();
    }


    public int getRedResource () {
        return getCargo(Enums.EResources.red);
    }

    public int getBlackResource () {
        return getCargo(Enums.EResources.black);
    }

    public int getBlueResource () {
        return getCargo(Enums.EResources.blue);
    }

    public int getGreenResource () {
        return getCargo(Enums.EResources.green);
    }






    // Planet:: Methods
    public Enums.PlanetType getPlanetType () {
        return data.getSetor().getPlanetType();
    }


    // Planet Surface :: METHODS
    public int[] getPosDrone () {
        return data.getSetor().getPlaneta().getSuperficie().getDronePos();
    }

    public int[] getPosAlien () {
        return data.getSetor().getPlaneta().getSuperficie().getAlienPos();
    }

    public Enums.AlienType getAlien () {
        return data.getSetor().getPlaneta().getSuperficie().getAlien().getAlienType();
    }

    public int[] getPosResource () {
        return data.getSetor().getPlaneta().getSuperficie().getResourcePos();
    }


    public String getResourceSurface () {
        return data.getSetor().getPlaneta().getSuperficie().getResource().getCor();
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

    public void convertResources (int value) {
        setEstado(getState().convertResources(value));
    }

    public void doEvent (int val) {
        setEstado(getState().aplicaEvento(val));
    }

    public EstadoID getEstadoID () {
        return estado.getEstadoID();
    }
}
