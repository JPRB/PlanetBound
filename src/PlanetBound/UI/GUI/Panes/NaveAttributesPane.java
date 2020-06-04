package PlanetBound.UI.GUI.Panes;

import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class NaveAttributesPane extends MainPane {

    private VBox vb;
    private Button btnMilitar;
    private BorderPane bPane;
    private GridPane pane;

    public NaveAttributesPane (ModelObservable obs, ViewController vc) {
        super(obs, vc);


        /*img.fitWidthProperty().bind(stage.widthProperty());

        pane.setCenter(img);*/

    }

    @Override
    public void setLayout () {
        // create a tile pane
        pane = new GridPane();

        pane.setVgap(10);
        pane.setHgap(30);

        pane.setMinWidth(width/2);
        pane.setMinHeight(height);
        pane.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        pane.setBackground(new Background(new BackgroundFill(Color.rgb(35, 85, 10), CornerRadii.EMPTY, Insets.EMPTY)));


        pane.setGridLinesVisible(true);


        VBox weaponShiled = setWeaponShield();


        pane.addColumn(0, setFuelBar());
        pane.addColumn(1, setOfficer());
        GridPane.setHalignment(weaponShiled, HPos.CENTER);
        pane.addColumn(2, weaponShiled);
        // column span 3, row span 1
        pane.add(setNave("militar"), 1, 1, 3, 1);


        pane.add(setCargoHold("6", "6", "6", "6", "6"), 0, 2, 3, 1);


       /* HBox box = new HBox();

        box.getChildren().addAll(setFuelBar(), setOfficer(), setWeaponShield(), setNave("militar"), setCargoHold("6", "6", "6", "6", "6"));

        bPane.setTop(box);*/

        this.getChildren().addAll(pane);
    }



    private VBox setFuelBar()
    {
        VBox fuelBox = new VBox();
        fuelBox.setFillWidth(true);

        ImageView imgVw = new ImageView(new ImageLoader(ImgConstants.FUEL.getName()).getImagem());
        imgVw.setFitWidth(100);
        imgVw.setPreserveRatio(true);


        // create a progressbar
        ProgressBar fuelBar = new ProgressBar(0);


        fuelBar.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));


        fuelBox.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        fuelBox.setSpacing(-20);


        fuelBox.getChildren().addAll(imgVw, fuelBar);

        return fuelBox;
    }

    private VBox setOfficer()
    {
        VBox officerBox = new VBox();
        officerBox.setMaxWidth(50);


        ImageView imgOfficer = new ImageView(new ImageLoader(ImgConstants.OFFICER.getName()).getImagem());
        imgOfficer.setFitWidth(50);
        imgOfficer.setPreserveRatio(true);



        Label officerNum  = new Label ("2", imgOfficer);
        // officerNum.setMaxWidth(officerBox.getMaxWidth());
        officerNum.setTextFill(Color.WHITE);
        officerNum.setAlignment(Pos.CENTER);






        officerNum.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));


        officerBox.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));


        officerBox.getChildren().addAll(officerNum);

        return officerBox;
    }


    private VBox setCargoHold(String maxCargo, String blackRes, String redRes, String blueRes, String greenRes)
    {
        VBox cargoHold = new VBox();
        //cargoHold.setMinWidth(width/6);

        ImageView cargo = new ImageView(new ImageLoader(ImgConstants.CARGO_HOLD.getName()).getImagem());
        cargo.setFitWidth(200);
        cargo.setPreserveRatio(true);


        Label cargoMax  = new Label (maxCargo, cargo);
        cargoMax.setTextFill(Color.WHITE);


        HBox resources = new HBox();
        //resources.setPrefWidth(width/6);


        // Black
        ImageView black = new ImageView(new ImageLoader(ImgConstants.BLACK_CUBE.getName()).getImagem());
        black.setFitWidth(50);
        black.setPreserveRatio(true);

        Label blackLb  = new Label (blackRes, black);
        blackLb.setTextFill(Color.WHITE);
        blackLb.setPadding(new Insets(10, 10, 10, 10));

        // Red
        ImageView red = new ImageView(new ImageLoader(ImgConstants.RED_CUBE.getName()).getImagem());
        red.setFitWidth(50);
        red.setPreserveRatio(true);

        Label redLb  = new Label (redRes, red);
        redLb.setTextFill(Color.WHITE);
        redLb.setPadding(new Insets(10, 10, 10, 10));

        // Blue
        ImageView blue = new ImageView(new ImageLoader(ImgConstants.BLUE_CUBE.getName()).getImagem());
        blue.setFitWidth(50);
        blue.setPreserveRatio(true);

        Label blueLb  = new Label (blueRes, blue);
        blueLb.setTextFill(Color.WHITE);
        blueLb.setPadding(new Insets(10, 10, 10, 10));

        // Green
        ImageView green = new ImageView(new ImageLoader(ImgConstants.GREEN_CUBE.getName()).getImagem());
        green.setFitWidth(50);
        green.setPreserveRatio(true);

        Label greenLb  = new Label (greenRes, green);
        greenLb.setTextFill(Color.WHITE);
        greenLb.setPadding(new Insets(10, 10, 10, 10));


        resources.getChildren().addAll(blackLb, redLb, blueLb, greenLb);




        cargoHold.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));


        resources.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));



        cargoHold.getChildren().addAll(cargoMax, resources);

        return cargoHold;
    }

    private VBox setWeaponShield()
    {
        VBox box = new VBox();
        box.setMaxWidth(40);

        // WEAPON

        VBox weaponBox = new VBox();
        weaponBox.setMaxWidth(box.getMaxWidth());

        ImageView weapon = new ImageView(new ImageLoader(ImgConstants.WEAPON.getName()).getImagem());
        weapon.setFitWidth(50);
        weapon.setPreserveRatio(true);

        Label weaponNum  = new Label ("5", weapon);
        weaponNum.setTextFill(Color.WHITE);

        weaponBox.getChildren().add(weaponNum);


        //  SHIELDS

        VBox shieldsBox = new VBox();
        shieldsBox.setMaxWidth(40);

        ImageView shields = new ImageView(new ImageLoader(ImgConstants.SHIELD.getName()).getImagem());
        shields.setFitWidth(35);
        shields.setPreserveRatio(true);

        Label shieldsNum  = new Label ("9", shields);
        shieldsNum.setTextFill(Color.WHITE);



        shieldsBox.getChildren().add(shieldsNum);



        // TODO : ELIMINAR

        shieldsBox.setBorder(new Border(new BorderStroke(Color.BLUE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        weaponBox.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));


        box.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));








        box.getChildren().addAll(shieldsBox, weaponBox);

        return box;
    }



    private HBox setNave(String nave){

        HBox box = new HBox();

        ImageView ship;

        if (nave.equals("militar"))
            ship = new ImageView(new ImageLoader(ImgConstants.SPACESHIP_MILITAR.getName()).getImagem());
        else
            ship = new ImageView(new ImageLoader(ImgConstants.SPACESHIP_EXPLORER.getName()).getImagem());

        ship.setFitWidth(200);
        ship.setPreserveRatio(true);

        box.getChildren().add(ship);


        return box;
    }
}