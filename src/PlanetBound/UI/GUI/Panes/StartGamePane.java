package PlanetBound.UI.GUI.Panes;

import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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

        setListeners();
    }

    @Override
    public void setLayout () {

        pane = new BorderPane();

        //Instantiating the HBox class
        VBox txtBox = new VBox();
        Label titulo = setTitle();

        txtBox.getChildren().add(titulo);
        txtBox.setAlignment(Pos.CENTER);

        // Buttons
        VBox vbtns = new VBox();
        vbtns.setSpacing(25);
        vbtns.getChildren().add(setButtons());
        vbtns.setAlignment(Pos.CENTER_RIGHT);




        //Setting the space between the nodes of a HBox pane
        //hbox.setSpacing(10);

        // Sound Botão
       /* Button soundBtn = new Button();
        Image soundImg = new Image(getClass().getResource("\\Images\\soundIcon.png").toExternalForm(), 30, 30, true, true);

        soundBtn.setGraphic(new ImageView(soundImg));

        HBox.setMargin(soundBtn, new Insets(20, 20, 20, 20));
        hbox.setAlignment(Pos.TOP_RIGHT);
        hbox.getChildren().add(soundBtn);*/

        pane.setTop(txtBox);
        pane.setCenter(vbtns);

        ImageView backGround = new ImageView(new ImageLoader(ImgConstants.SPACE.getName()).getImagem());
        this.getChildren().addAll(backGround, pane);

    }

    @Override
    protected void setListeners () {

        startBtn.setOnMouseClicked(e -> {
            modelo.startGame();
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

        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setSpacing(300);
        box.getChildren().addAll(startBtn, finishBtn);


        return box;
    }
}
