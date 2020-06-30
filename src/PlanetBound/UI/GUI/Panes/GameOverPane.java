package PlanetBound.UI.GUI.Panes;

import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
        pane.setPrefHeight(height);
        pane.setPrefWidth(width);

        VBox txtBox = new VBox();
        Label titulo = setTitle();

        txtBox.getChildren().add(titulo);
        txtBox.setAlignment(Pos.CENTER);

        // Buttons
        VBox vbtns = new VBox();
        vbtns.setSpacing(25);
        vbtns.getChildren().add(setButtons());
        vbtns.setAlignment(Pos.CENTER_RIGHT);


        pane.setTop(txtBox);
        pane.setCenter(vbtns);

        ImageView backGround = new ImageView(new ImageLoader(ImgConstants.SPACE.getName()).getImagem());
        this.getChildren().addAll(backGround, pane);
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
        titulo.setTextFill(Color.RED);
        titulo.setFont(Font.font("Magneto", FontWeight.EXTRA_BOLD, 80));
        titulo.setAlignment(Pos.TOP_CENTER);


        return titulo;
    }


    private HBox setButtons () {
        // Horizontal Box (align Center) w/ Btn to Start or finish
        HBox box = new HBox();


        playAgainBtn = new DefaultButton("Play Again", null, 200, 50, false);
        finishBtn = new DefaultButton("Exit", null, 200, 50, false);

        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setSpacing(300);
        box.getChildren().addAll(playAgainBtn, finishBtn);


        return box;
    }

}
