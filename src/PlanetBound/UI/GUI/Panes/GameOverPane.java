package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GameOverPane extends MainPane {



    public GameOverPane (ModelObservable obs, ViewController vc) {
        super(obs, vc, 300, 160);

        setListeners();
    }

    @Override
    protected void setListeners () {

    }

    @Override
    public void setLayout () {



        this.getChildren().addAll();
    }

}
