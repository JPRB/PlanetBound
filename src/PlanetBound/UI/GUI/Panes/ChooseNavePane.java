package PlanetBound.UI.GUI.Panes;


import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.GUI.Buttons.CaptionButton;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChooseNavePane extends MainPane {

    private VBox vb;
    private BorderPane bPane;
    private CaptionButton militarBtn;
    private CaptionButton explorerBtn;


    public ChooseNavePane (ModelObservable modelo, ViewController vc) {
        super(modelo, vc);

        setListeners();
    }

    @Override
    public void setLayout (){

        /*BackgroundImage backImg = new BackgroundImage(new ImageLoader1(BACKGROUND1).getImagem(),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        */
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

        //bPane.setBackground(new Background(backImg));
        this.getChildren().add(bPane);
    }

    @Override
    protected void setListeners () {
        militarBtn.setOnMouseClicked( e ->{
                modelo.chooseShip(Enums.ShipType.Militar.getValue());
        });

        explorerBtn.setOnMouseClicked( e ->{
            modelo.chooseShip(Enums.ShipType.Explorer.getValue());
        });

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

        militarBtn = new CaptionButton("Militar", new ImageLoader(ImgConstants.SPACESHIP_MILITAR.getName()).getImagem(), 200, 200);

        explorerBtn = new CaptionButton("Explorer", new ImageLoader(ImgConstants.SPACESHIP_EXPLORER.getName()).getImagem(), 200, 200);

        menu.getChildren().addAll(militarBtn, explorerBtn);
        menu.setAlignment(Pos.CENTER);

        return menu;
    }
}
