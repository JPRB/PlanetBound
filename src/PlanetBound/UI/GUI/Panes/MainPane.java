package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.Constants;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.StageStyle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MainPane extends Pane implements Constants {

    protected ModelObservable modelo;
    protected ViewController view;
    protected double  width;
    protected double height;
    protected boolean log = true;

    protected MainPane(ModelObservable obs, ViewController vc) {
        this(obs, vc, 800-15, 562);
    }

    protected MainPane(ModelObservable obs, ViewController vc, double width, double height ) {
        this.modelo = obs;
        this.view = vc;
        this.width = width;
        this.height = height;

        getStyleClass().add(getClass().getResource("/PlanetBound/UI/GUI/Css/Stylesheet.css").toExternalForm());

        setLayout();

        log();
        // setListeners();
    }



    protected void setMsgLog () {
        List <String> list = modelo.getMsgLog();
        StringBuilder str = new StringBuilder();

        if (!list.isEmpty()){

            for(String msg : list){
                str.append(msg);
            }

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("MSG Log");
            alert.setHeaderText(null);

            alert.setContentText(str.toString());

            alert.showAndWait();
            modelo.clearMsg();
        }


    }

    public void log() {
        modelo.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                if (log)
                    setMsgLog();
            }
        });
    }

    public abstract void setLayout ();

    protected abstract void setListeners();


}
