package PlanetBound.UI.GUI.Panes;

import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartGamePane extends MainPane{

    Button startBtn;
    Button finishBtn;
    BorderPane pane;

    public StartGamePane (ModelObservable obs, ViewController vc) {
        super(obs, vc);

        this.setPrefWidth(800);
        this.setPrefHeight(600);

    }

    @Override
    public void setLayout () {

        pane = new BorderPane();

        //Instantiating the HBox class
        VBox vbox = new VBox();

        //Setting the space between the nodes of a HBox pane
        //hbox.setSpacing(10);

        // Sound Botão
       /* Button soundBtn = new Button();
        Image soundImg = new Image(getClass().getResource("\\Images\\soundIcon.png").toExternalForm(), 30, 30, true, true);

        soundBtn.setGraphic(new ImageView(soundImg));

        HBox.setMargin(soundBtn, new Insets(20, 20, 20, 20));
        hbox.setAlignment(Pos.TOP_RIGHT);
        hbox.getChildren().add(soundBtn);*/

        vbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(setTitle(), setButtons());

        vbox.setMinWidth(800);


        pane.setCenter(vbox);

        this.getChildren().addAll(pane);

        listeners();
    }


    private void listeners () {

        startBtn.setOnMouseClicked(e -> {

        });


        finishBtn.setOnMouseClicked(e -> {
            Platform.exit();
        });
    }

    // Game Title
    private Label setTitle () {

        Label titulo = new Label();
        titulo.setText("Planet Bound");
        titulo.setTextFill(Color.DODGERBLUE);
        titulo.setFont(Font.font("Magneto", FontWeight.EXTRA_BOLD, 80));
        titulo.setAlignment(Pos.TOP_CENTER);


        return titulo;
    }


    private HBox setButtons() {
        // Horizontal Box (align Center) w/ Btn to Start or finish
        HBox box = new HBox();


        startBtn = new DefaultButton("Start", null, 200, 50, false);
        finishBtn = new DefaultButton("Finish", null, 200, 50, false);

        //box.setMargin(startBtn, new Insets(300, 200, 20, 20));
        //box.setMargin(finishBtn, new Insets(300, 20, 20, 20));
        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        box.setSpacing(300);
        box.getChildren().addAll(startBtn, finishBtn);


        return box;
    }
}
