package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Estados.Estados;
import PlanetBound.GameLogic.Game;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelObservable {
    private Game jogo;
    private PropertyChangeSupport change;

    public ModelObservable(){
        jogo = new Game();
        change = new PropertyChangeSupport(jogo);
        fireEvent(Estados.START.toString());
    }

    public final void fireEvent(String ev){
        System.out.println(jogo.toString());
        change.firePropertyChange(ev, null, true);
    }

    public void addPropertyChangeListener(PropertyChangeListener l){
        change.addPropertyChangeListener(l);
    }

    public void addPropertyChangeListener(Estados estado, PropertyChangeListener l){
        change.addPropertyChangeListener(estado.name(), l);
    }

  /*  public void addPropertyChangeListener(Eventos ev, PropertyChangeListener l){
        change.addPropertyChangeListener(ev.toString(), l);
    }*/
  

    public void startGame () {
        fireEvent(jogo.start().toString());
    }

/*    public void chooseShip (int value) {
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

    public void doEvent(){*/

    }

    /*
    *
    *   MENU Surface Planet
    *
    *
    */
    public void moveDrone(int value) {
        //fireEvent(jogo.moveDrone(value));
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

    public int getFuel () {
        return jogo.getFuel();
    }

    public int getOfficers () {
        return jogo.getOfficers();

    }

    public int getShield (){
        return jogo.getShield();
    }

    
}
