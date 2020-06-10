package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class EventPane extends MainPane {

    ComboBox<String> comboBox;
    BorderPane bp;
    private Button nextBtn;

    public EventPane (ModelObservable obs, ViewController vc) {
        super(obs, vc, 300, 160);

        setListeners();
    }

    @Override
    protected void setListeners () {
        nextBtn.setOnAction(actionEvent -> {
            String val = comboBox.getSelectionModel().getSelectedItem().toString();
            //val.

            modelo.doEvent();
            System.out.println("aqui");
        });
    }

    @Override
    public void setLayout () {
        bp = new BorderPane();
        bp.setCenter(setComboBox());

        nextBtn = new Button("Seguir");
        bp.setRight(nextBtn);

        this.getChildren().addAll(bp);
    }


    public HBox setComboBox () {
        HBox box = new HBox();
        comboBox = new ComboBox<>();

        for (Enums.Events evt : Enums.Events.values()){
            comboBox.getItems().add(evt.name());
        }
        comboBox.setMinWidth(200);

        Label text = new Label("Escolha um Evento: ");
        text.setMinWidth(100);
        text.setTextFill(Color.WHITE);


        box.getChildren().addAll(text, comboBox);
        box.setAlignment(Pos.CENTER);
        return box;
    }
}
