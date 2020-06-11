package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.UI.GUI.Panes.*;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ViewController {


    private BorderPane rootPane;
    private ModelObservable modelo;
    private ArrayList<Pane> panes;

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

        panes.add(new StartGamePane(modelo, this));
        panes.add(new ChooseNavePane(modelo, this));
        // panes.add(new NaveAttributesPane(modelo, this));
        panes.add(new PlanetOrbitPane(modelo, this));
        panes.add(new SpaceStationPane(modelo, this));

        panes.add(new LandingCraftPane(modelo, this));

        rootPane.getChildren().addAll(panes);


        setListeners();

        setPaneVisibility(Panes.StartGamePane);

    }

    private void setListeners () {
       modelo.addPropertyChangeListener(EstadoID.AWAIT_BEGINNING, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.StartGamePane);
            }
        });

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
                setPaneVisibility(Panes.MoveDronePane);
            }
        });

    }


    private void setPaneVisibility (Panes pane) {

        setPanesDisabled();

        Pane p = panes.get(pane.getValue());

        p.setVisible(true);
        p.setDisable(false);

    }


    private void setPanesDisabled () {
        for (Pane pane : panes) {
            pane.setVisible(false);
            pane.setDisable(true);
        }
    }

}
