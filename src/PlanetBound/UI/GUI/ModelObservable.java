package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Game;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelObservable {
    private Game jogo;
    private PropertyChangeSupport change;

    public ModelObservable(){
        jogo = new Game();
        change = new PropertyChangeSupport(jogo);
        /*fireEvent(Eventos.ESTADOINICIOJOGO.toString());*/
    }

    public final void fireEvent(String ev){
        System.out.println(jogo);
        change.firePropertyChange(ev, null, true);
    }

    public void addPropertyChangeListener(PropertyChangeListener l){
        change.addPropertyChangeListener(l);
    }

  /*  public void addPropertyChangeListener(Eventos ev, PropertyChangeListener l){
        change.addPropertyChangeListener(ev.toString(), l);
    }*/


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
