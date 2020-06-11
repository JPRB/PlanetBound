package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.GameLogic.Game;
import PlanetBound.GameLogic.Utils.Enums;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelObservable {
    private Game jogo;
    private PropertyChangeSupport change;

    public ModelObservable () {
        jogo = new Game();
        change = new PropertyChangeSupport(jogo);
        fireEvent(EstadoID.AWAIT_BEGINNING.toString());
    }

    public final void fireEvent (String ev) {
        System.out.println(jogo.getEstadoID());
        change.firePropertyChange(ev, null, null);
    }

    public void addPropertyChangeListener (PropertyChangeListener l) {
        change.addPropertyChangeListener(l);
    }

    public void addPropertyChangeListener (EstadoID estado, PropertyChangeListener l) {
        change.addPropertyChangeListener(estado.name(), l);
    }

  /*  public void addPropertyChangeListener(Eventos ev, PropertyChangeListener l){
        change.addPropertyChangeListener(ev.toString(), l);
    }*/


    public void startGame () {
        jogo.start();

        fireEvent(EstadoID.AWAIT_SHIP_SELECTION.toString());
    }

    public void chooseShip (int value) {
        jogo.chooseShip(value);

        fireEvent(EstadoID.PLANET_ORBIT.name());
    }

    // Move to New Planet || To orbit in planet || to Ship in Planet Orbit
    public void move () {
        jogo.move();
        fireEvent(EstadoID.PLANET_ORBIT.name());
    }

    public void doEvent (int val){
        this.move();
        jogo.doEvent(val);
    }

    public void moveToSpaceStation () {
        jogo.moveToSpaceStation();

        // TODO : Verify if Estado in getEstadoID == AWAIT STATION DECICIONS

        fireEvent(EstadoID.AWAIT_STATION_DECISIONS.name());
    }


    public void getItemsSpaceStations (int item) {
        jogo.getItemsSpaceStations(item);
    }

    public void explorePlanet () {
        jogo.explorePlanet();
        fireEvent(EstadoID.EXPLORE_RESOURCES.name());
    }

    public void moveDrone (int value) {
        jogo.moveDrone(value);
        fireEvent(EstadoID.MOVE_DRONE.name());
    }




/*
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

    public void doEvent(){

}*/



    // Methods From Logic to GUI

    /*
     *
     * TODO:
     *  **** get combustivel
     *  **** get officers
     *  **** get shields
     *  **** get weapon
     *  **** get carga lvl
     *  **** get capacidade
        **** get resources
     *  **** get planeta resources?
     *  **** get
     */

    public int getFuel () {
        return jogo.getFuel();
    }

    public int getOfficers () {
        return jogo.getOfficers();

    }

    public int getShield () {
        return jogo.getShield();
    }


    public boolean getStation () {
        return jogo.haveStationShip();
    }





    // Gui To collect Resources

    public int[] getDronePos () {
        return jogo.getPosDrone();
    }

    public Enums.AlienType getAlien () {
        return jogo.getAlien();
    }

    public int[] getAlienPos () {
        return jogo.getPosAlien();
    }

    public Enums.PlanetType getPlanetType () {
        return jogo.getPlanetType();
    }


    public int[] getPosResource () {
        return jogo.getPosResource();
    }


    public String getResource () {
        return jogo.getResourceSurface();
    }
}
