package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

public class GameOverPane extends MainPane {

    Button playAgainBtn;
    Button finishBtn;

    public GameOverPane (ModelObservable obs, ViewController vc) {
        super(obs, vc);

        this.setPrefWidth(800);
        this.setPrefHeight(600);

        setListeners();
    }

    @Override
    public void setLayout () {

        BorderPane pane = new BorderPane();


        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(setTitle(), setButtons());

        vbox.setMinWidth(800);

        pane.setCenter(vbox);

        this.getChildren().addAll(pane);

    }

    @Override
    protected void setListeners () {

        playAgainBtn.setOnMouseClicked(e -> {
            modelo.playAgain();
        });


        finishBtn.setOnMouseClicked(e -> {
            Platform.exit();
        });
    }

    // Game Title
    private Label setTitle () {

        Label titulo = new Label("Game Over");
        titulo.setTextFill(Color.PALEVIOLETRED);
        titulo.setFont(Font.font("Magneto", FontWeight.EXTRA_BOLD, 80));
        titulo.setAlignment(Pos.TOP_CENTER);


        return titulo;
    }


    private HBox setButtons () {
        // Horizontal Box (align Center) w/ Btn to Start or finish
        HBox box = new HBox();


        playAgainBtn = new DefaultButton("Play Again", null, 200, 50, false);
        finishBtn = new DefaultButton("Exit", null, 200, 50, false);

        //box.setMargin(startBtn, new Insets(300, 200, 20, 20));
        //box.setMargin(finishBtn, new Insets(300, 20, 20, 20));
        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        box.setSpacing(300);
        box.getChildren().addAll(playAgainBtn, finishBtn);


        return box;
    }

}
