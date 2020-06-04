package PlanetBound.UI.GUI.Panes;

import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.Constants;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public abstract class MainPane extends Pane implements Constants {

    protected ModelObservable modelo;
    protected ViewController view;
    protected double  width;
    protected double height;

    protected MainPane(ModelObservable obs, ViewController vc) {
        this(obs, vc, 800, 600);
    }

    protected MainPane(ModelObservable obs, ViewController vc, double width, double height ) {
        this.modelo = obs;
        this.view = vc;
        this.width = width;
        this.height = height;

        getStyleClass().add(getClass().getResource("/PlanetBound/UI/GUI/Css/Stylesheet.css").toExternalForm());
        setLayout();
    }


    public abstract void setLayout ();



}
