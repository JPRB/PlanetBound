package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.UI.GUI.Panes.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ViewController {


    private BorderPane rootPane;
    private ModelObservable modelo;
    private ArrayList<Pane> panes;
    private LandingCraftPane LCP;
    private NaveAttributesPane ship;

    public ViewController (ModelObservable modelo) {
        this.modelo = modelo;

        rootPane = new BorderPane();
        panes = new ArrayList<>();
        initVC();
    }

    public BorderPane getRootPane () {
        return rootPane;
    }


    public void initVC () {

        //MainPane Mainpane = new MainPane();

        panes.add(0, new StartGamePane(modelo, this));
        panes.add(1, new ChooseNavePane(modelo, this));

        panes.add(2, new PlanetOrbitPane(modelo, this));
        panes.add(3, new SpaceStationPane(modelo, this));

        panes.add(4, LCP = new LandingCraftPane(modelo, this));

        ship = new NaveAttributesPane(modelo, this);

        setListeners();

        setPaneVisibility(Panes.StartGamePane);

    }

    private void setListeners () {

        modelo.addPropertyChangeListener(EstadoID.AWAIT_SHIP_SELECTION, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.ChooseNavePane);
            }
        });

        modelo.addPropertyChangeListener(EstadoID.PLANET_ORBIT, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.PlanetOrbitPane);
            }
        });

        modelo.addPropertyChangeListener(EstadoID.AWAIT_STATION_DECISIONS, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.SpaceStationPane);
            }
        });

        modelo.addPropertyChangeListener(EstadoID.EXPLORE_RESOURCES, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.LandingCraftPane);
            }
        });

    }


    private void setPaneVisibility (Panes pane) {
        int value = pane.getValue();
        Pane p = panes.get(value);
        rootPane.setTop(null);

        if (value == Panes.PlanetOrbitPane.getValue())
            rootPane.setTop(ship);

        rootPane.setCenter(p);
    }


    private void setPanesDisabled () {
        for (Pane pane : panes) {
            pane.setVisible(false);
            pane.setDisable(true);
        }
    }

}
