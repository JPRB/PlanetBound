package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Estados.Estados;
import PlanetBound.UI.GUI.Panes.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.concurrent.ThreadPoolExecutor;

public class ViewController {


    private BorderPane rootPane;
    private ModelObservable modelo;
    private ArrayList<Pane> panes;

    public ViewController (ModelObservable modelo) {
        this.modelo = modelo;

        initVC();
    }

    public BorderPane getRootPane () {
        return rootPane;
    }


    public void initVC () {
        rootPane = new BorderPane();
        panes = new ArrayList<>();
        //MainPane Mainpane = new MainPane();

        panes.add(new StartGamePane(modelo, this));
        panes.add(new ChooseNavePane(modelo, this));
        panes.add(new NaveAttributesPane(modelo, this));
        panes.add(new SpaceStationPane(modelo, this));

        rootPane.getChildren().addAll(panes);


        setListeners ();

        setPaneVisibility(Panes.StartGamePane);
    }

    private void setListeners () {
        modelo.addPropertyChangeListener(Estados.START, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.StartGamePane);
            }
        });

        modelo.addPropertyChangeListener(Estados.CHOOSE_SHIP, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                setPaneVisibility(Panes.ChooseNavePane);
            }
        });

        modelo.addPropertyChangeListener(Estados.EXPLORE_PLANET, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                // setPaneVisibility(Panes.StartGamePane);
            }
        });

        modelo.addPropertyChangeListener(Estados.DO_EVENT, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                //setPaneVisibility(Panes);
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
