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

        panes.add(Panes.StartGamePane.getValue(), new StartGamePane(modelo, this));
        panes.add(Panes.ChooseNavePane.getValue(), new ChooseNavePane(modelo, this));

        panes.add(Panes.PlanetOrbitPane.getValue(), new PlanetOrbitPane(modelo, this));
        panes.add(Panes.SpaceStationPane.getValue(), new SpaceStationPane(modelo, this));

        panes.add(Panes.LandingCraftPane.getValue(), LCP = new LandingCraftPane(modelo, this));
        panes.add(Panes.ConvertResources.getValue(), new ConvertResourcesPane(modelo, this));
        panes.add(Panes.GameOverPane.getValue(), new GameOverPane(modelo, this));

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

        modelo.addPropertyChangeListener(EstadoID.CONVERT_RESOURCES, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.ConvertResources);
            }
        });

        modelo.addPropertyChangeListener(EstadoID.GAME_OVER, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.GameOverPane);
            }
        });

    }


    private void setPaneVisibility (Panes pane) {
        int value = pane.getValue();
        Pane p = panes.get(value);
        rootPane.setTop(null);

        if (value == Panes.PlanetOrbitPane.getValue() || value == Panes.ConvertResources.getValue())
            rootPane.setTop(ship);

        rootPane.setCenter(p);
    }

}
