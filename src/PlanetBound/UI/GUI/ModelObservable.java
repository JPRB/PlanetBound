package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.GameLogic.Game;
import PlanetBound.GameLogic.Utils.Enums;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

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
        //jogo.clearMsgLog();
        change.firePropertyChange(ev, null, true);
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
        fireEvent(jogo.start().toString());
    }

    public void chooseShip (int value) {
        fireEvent(jogo.chooseShip(value).toString());
    }

    // Move to New Planet || To orbit in planet || to Ship in Planet Orbit
    public void move () {
        fireEvent(jogo.move().toString());
    }

    public void doEvent (int val) {
        jogo.move();
        fireEvent(jogo.doEvent(val).toString());
    }

    public void moveToSpaceStation () {
        fireEvent(jogo.moveToSpaceStation().toString());
    }


    public void getItemsSpaceStations (int item) {
        fireEvent(jogo.getItemsSpaceStations(item).toString());
    }

    public void explorePlanet () {
        fireEvent(jogo.explorePlanet().toString());
    }

    public void moveDrone (int value) {
        fireEvent(jogo.moveDrone(value).toString());
    }

    public void playAgain () {
        fireEvent(jogo.playAgain().toString());
    }

    public void convertResources (int value) {
        fireEvent(jogo.convertResources(value).toString());
    }

    public void convertInOtherResource (int value) {
        fireEvent(jogo.convertResourceInOther(value).toString());
    }


    public EstadoID getEstadoID () {
        return jogo.getEstadoID();
    }


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


    public List<String> getMsgLog () {
        return jogo.getMsgLog();
    }

    public void clearMsg () {
        jogo.clearMsgLog();
    }

    // GUI NAVE
    public int getFuel () {
        return jogo.getFuel();
    }

    public int getOfficers () {
        return jogo.getOfficers();

    }

    public int getShield () {
        return jogo.getShield();
    }

    public int getCargoMax () {
        return jogo.getCargoMax();
    }

    public int getBlueResources () {
        return jogo.getBlueResource();
    }

    public int getBlackResources () {
        return jogo.getBlackResource();
    }

    public int getRedResources () {
        return jogo.getRedResource();
    }

    public int getGreenResources () {
        return jogo.getGreenResource();
    }

    public int getArtifactResoruces () {
        return jogo.getArtifactResource();
    }

    // GUI Planet Orbit
    public boolean getStation () {
        return jogo.haveStationShip();
    }


    public Enums.PlanetType getPlanetType () {
        return jogo.getPlanetType();
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


    public int[] getPosResource () {
        return jogo.getPosResource();
    }


    public String getResource () {
        return jogo.getResourceSurface();
    }

    // Gui to convert Resources
    public void convertIntoArmor () {
        this.convertResources(3);
    }

    public void convertIntoFuel () {
        this.convertResources(1);
    }

    public void convertIntoShield () {
        this.convertResources(2);
    }

    public void convertResblackToRedBtn () {
        convertInOtherResource(1);
    }

    public void convertResblackToGreenBtn () {
        convertInOtherResource(2);
    }

    public void convertResblackToBlueBtn () {
        convertInOtherResource(3);
    }

    public void convertResblueToBlackBtn () {
        convertInOtherResource(4);
    }

    public void convertResblueToGreenBtn () {
        convertInOtherResource(5);
    }

    public void convertResblueToRedBtn () {
        convertInOtherResource(6);
    }


    public void convertResredToBlackBtn () {
        convertInOtherResource(7);
    }

    public void convertResredToBlueBtn () {
        convertInOtherResource(8);
    }

    public void convertResredToGreenBtn () {
        convertInOtherResource(9);
    }

    public void convertResgreenToRedBtn () {
        convertInOtherResource(10);
    }


    public void convertResgreenToBlackBtn () {
        convertInOtherResource(11);
    }

    public void convertResgreenToBlueBtn () {
        convertInOtherResource(12);
    }





    public String getNaveType () {
        return jogo.getNaveType();
    }

    public int getWeapon () {
        return jogo.getWeapon();
    }


    public int getFuelMax () {
        return jogo.getFuelMax();
    }

    public boolean getEstadoAlien () {
        return jogo.getAlienDied();
    }

}
