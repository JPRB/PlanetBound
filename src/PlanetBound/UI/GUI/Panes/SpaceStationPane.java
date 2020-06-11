package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.GUI.Buttons.CaptionButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SpaceStationPane extends MainPane {

    private CaptionButton buyDroneBtn;
    private CaptionButton hireNewCrewBtn;
    private CaptionButton upgradeWeaponsBtn;
    private CaptionButton upgradeCargoHoldBtn;
    private CaptionButton backBtn;

    public SpaceStationPane (ModelObservable obs, ViewController vc) {
        super(obs, vc);

        setListeners();
    }

    @Override
    public void setLayout () {

        GridPane pane = new GridPane();

        pane.setPrefSize(width, 100);
        pane.setMaxSize(pane.getPrefWidth(), pane.getPrefHeight());
        pane.setMinSize(pane.getPrefWidth(), pane.getPrefHeight());


        pane.addColumn(0, setStation());
        pane.addColumn(1, setOptionsBtn());

        ImageView backGround = new ImageView(new ImageLoader(ImgConstants.SPACE.getName()).getImagem());


        this.getChildren().addAll(backGround, pane);
    }

    @Override
    protected void setListeners () {

        backBtn.setOnAction(actionEvent -> {
            modelo.move();
        });

        buyDroneBtn.setOnAction(actionEvent -> {
            getItems(Enums.Station.buyDrone.getValue());
        });

        hireNewCrewBtn.setOnAction(actionEvent -> {
            getItems(Enums.Station.hireNewCrew.getValue());
        });

        upgradeWeaponsBtn.setOnAction(actionEvent -> {
            getItems(Enums.Station.upgradeWeapons.getValue());
        });

        upgradeCargoHoldBtn.setOnAction(actionEvent -> {
            getItems(Enums.Station.upgradeCargoHold.getValue());
        });

    }

    private void getItems (int value){
        modelo.getItemsSpaceStations(value);
    }


    private VBox setStation() {

        VBox box = new VBox();

        box.getChildren().addAll(setBack(), setImg());

        return box;
    }

    private VBox setImg() {
        VBox imgBox = new VBox();
        imgBox.setPrefSize(width/2, height);
        imgBox.setMaxSize(imgBox.getPrefWidth(), height);
        imgBox.setMinSize(imgBox.getPrefWidth(), height);


        ImageView img = new ImageView(new ImageLoader(ImgConstants.SPACE_STATION.getName()).getImagem());
        img.setPreserveRatio(true);
        imgBox.setAlignment(Pos.CENTER);

        imgBox.getChildren().addAll(img);
        imgBox.setBorder(new Border(new BorderStroke(Color.valueOf("red"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        return imgBox;
    }


    private VBox setBack (){
        VBox backBox = new VBox();

        backBtn = new CaptionButton("< Voltar", null,  25, 50);
        backBtn.setOpacity(0.9);
        backBtn.setColor("#a7c7e0");
        backBtn.setStyle("-fx-font-weight: bold");

        backBox.setAlignment(Pos.TOP_LEFT);
        backBox.setPadding(new Insets(10, 10, 10, 10));
        backBox.getChildren().addAll(backBtn);
        backBox.setBorder(new Border(new BorderStroke(Color.valueOf("red"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        return backBox;
    }

    private VBox setOptionsBtn () {
        // Horizontal Box (align Center) w/ Btn to buyDrone hireNewCrew  upgradeWeapons upgradeCargoHold
        VBox box = new VBox();


        buyDroneBtn = new CaptionButton("Buy new Drone", new ImageLoader(ImgConstants.DRONE.getName()).getImagem(), 50, 50, 100, 200);
        buyDroneBtn.setOpacity(0.9);
        buyDroneBtn.setColor("#a7c7e0");
        buyDroneBtn.setStyle("-fx-font-weight: bold");

        hireNewCrewBtn = new CaptionButton("Hire New Crew", new ImageLoader(ImgConstants.OFFICER.getName()).getImagem(), 50, 50, 100, 200);
        hireNewCrewBtn.setStyle("-fx-font-weight: bold");
        hireNewCrewBtn.setColor("#a7c7e0");
        hireNewCrewBtn.setOpacity(0.9);

        upgradeWeaponsBtn = new CaptionButton("Upgrade Weapons", null, 50,50, 50, 200);
        upgradeWeaponsBtn.setStyle("-fx-font-weight: bold");
        upgradeWeaponsBtn.setColor("#a7c7e0");
        upgradeWeaponsBtn.setOpacity(0.9);

        upgradeCargoHoldBtn = new CaptionButton("Upgrade CargoHold", new ImageLoader(ImgConstants.CARGO.getName()).getImagem(), 80, 130, 100, 200);
        upgradeCargoHoldBtn.setStyle("-fx-font-weight: bold");
        upgradeCargoHoldBtn.setColor("#a7c7e0");
        upgradeCargoHoldBtn.setOpacity(0.9);


        box.setAlignment(Pos.CENTER);
        box.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        box.setPadding(new Insets(20, 20, 50, 20));
        box.setSpacing(25);

        box.getChildren().addAll(buyDroneBtn, hireNewCrewBtn, upgradeWeaponsBtn, upgradeCargoHoldBtn);


        return box;
    }


}
