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
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChooseNavePane extends MainPane {


    private BorderPane bPane;
    private CaptionButton militarBtn;
    private CaptionButton explorerBtn;


    public ChooseNavePane (ModelObservable modelo, ViewController vc) {
        super(modelo, vc);

        setListeners();
    }

    @Override
    public void setLayout () {

        // title
        VBox txtBox = new VBox();
        Label titulo = setTitle();

        txtBox.getChildren().add(titulo);
        txtBox.setAlignment(Pos.CENTER);

        bPane = new BorderPane();
        bPane.setPrefHeight(height);
        bPane.setPrefWidth(width);

        bPane.setTop(txtBox);
        bPane.setCenter(setButtons());



        this.getChildren().addAll(backGround(), bPane);
    }


    public ImageView backGround () {
        ImageView imgVw = new ImageView(new ImageLoader(ImgConstants.SPACE1.getName()).getImagem());
        imgVw.setFitHeight(height);
        imgVw.setFitWidth(width);

        return imgVw;
    }

    @Override
    protected void setListeners () {
        militarBtn.setOnMouseClicked(e -> {
            modelo.chooseShip(Enums.ShipType.Militar.getValue());
        });

        explorerBtn.setOnMouseClicked(e -> {
            modelo.chooseShip(Enums.ShipType.Explorer.getValue());
        });

    }


    private Label setTitle () {

        Label titulo = new Label();
        titulo.setText("Choose Ship");
        titulo.setTextFill(Color.ALICEBLUE);
        titulo.setFont(Font.font("Magneto", FontWeight.EXTRA_BOLD, 80));
        titulo.setAlignment(Pos.TOP_CENTER);


        return titulo;
    }

    private HBox setButtons () {
        // Horizontal Box (align Center) w/ Btn to Start or finish
        HBox menu = new HBox();
        menu.setSpacing(30);
        menu.setAlignment(Pos.CENTER);

        militarBtn = new CaptionButton("Militar", new ImageLoader(ImgConstants.SPACESHIP_MILITAR.getName()).getImagem(), 200, 200);
        militarBtn.setOpacity(0.8);
        militarBtn.setStyle("-fx-font-weight: bold");

        explorerBtn = new CaptionButton("Explorer", new ImageLoader(ImgConstants.SPACESHIP_EXPLORER.getName()).getImagem(), 200, 200);
        explorerBtn.setOpacity(0.8);
        explorerBtn.setStyle("-fx-font-weight: bold");


        menu.getChildren().addAll(militarBtn, explorerBtn);


        return menu;
    }
}
