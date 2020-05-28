package PlanetBound.UI.GUI;

import PlanetBound.UI.GUI.Panes.ChooseNavePane;
import PlanetBound.UI.GUI.Panes.NaveAttributesPane;
import PlanetBound.UI.GUI.Panes.StartGamePane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
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

        // panes.add(new StartGamePane(modelo, this));
        // panes.add(new ChooseNavePane(modelo, this));
        panes.add(new NaveAttributesPane(modelo, this));



        rootPane.getChildren().addAll(panes);

        rootPane.setVisible(true);
    }
}
