package PlanetBound.UI.GUI.Panes;


import PlanetBound.UI.GUI.Buttons.CaptionButton;
import PlanetBound.UI.GUI.Images.ImageLoader;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static PlanetBound.UI.GUI.Constants.*;

public class ChooseNavePane extends MainPane {

    private VBox vb;
    private Button btnMilitar;
    private BorderPane bPane;

    public ChooseNavePane (ModelObservable obs, ViewController vc) {
        super(obs, vc);

    }

    @Override
    public void setLayout (){

        BackgroundImage backImg = new BackgroundImage(new ImageLoader(BACKGROUND1).getImagem(),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        // title
        VBox txtBox = new VBox();
        Label titulo = setTitle();

        txtBox.getChildren().add(titulo);
        txtBox.setAlignment(Pos.CENTER);

        // Buttons
        vb = new VBox();
        vb.setSpacing(25);
        vb.getChildren().add(setButtons());
        vb.setAlignment(Pos.CENTER_RIGHT);

        bPane = new BorderPane();
        bPane.setTop(txtBox);
        bPane.setCenter(vb);
        bPane.setPrefHeight(height);
        bPane.setPrefWidth(width);

        bPane.setBackground(new Background(backImg));
        this.getChildren().add(bPane);
    }

    private Label setTitle () {

        Label titulo = new Label();
        titulo.setText("Choose Ship");
        titulo.setTextFill(Color.DODGERBLUE);
        titulo.setFont(Font.font("Magneto", FontWeight.EXTRA_BOLD, 80));
        titulo.setAlignment(Pos.TOP_CENTER);


        return titulo;
    }


    private HBox setButtons() {
        // Horizontal Box (align Center) w/ Btn to Start or finish
        HBox menu = new HBox();
        menu.setSpacing(30);

        CaptionButton militarBtn = new CaptionButton("Militar", new ImageLoader(SHIP_MILITAR).getImagem(), 200, 200);

        CaptionButton explorerBtn = new CaptionButton("Explorer", new ImageLoader(SHIP_EXPLORER).getImagem(), 200, 200);

        menu.getChildren().addAll(militarBtn, explorerBtn);
        menu.setAlignment(Pos.CENTER);

        return menu;
    }
}