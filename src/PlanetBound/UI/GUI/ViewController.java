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
    private Dialog dialog;

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

        Pane eventPane = new EventPane(modelo, this);
        //MainPane Mainpane = new MainPane();
        dialog = new Dialog();
        dialog.getDialogPane().setContent(eventPane);


        panes.add(new StartGamePane(modelo, this));
        panes.add(new ChooseNavePane(modelo, this));
        // panes.add(new NaveAttributesPane(modelo, this));
        panes.add(new PlanetOrbitPane(modelo, this));
        panes.add(new SpaceStationPane(modelo, this));

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
                dialog.close();
                setPaneVisibility(Panes.PlanetOrbitPane);
            }
        });

        modelo.addPropertyChangeListener(EstadoID.AWAIT_STATION_DECISIONS, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.SpaceStationPane);
            }
        });

        modelo.addPropertyChangeListener(EstadoID.DO_EVENT, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                dialog.show();
            }
        });

       /* modelo.addPropertyChangeListener(Estados.START, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.StartGamePane);
            }
        });*/

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
