package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NaveAttributesPane extends MainPane {

    private VBox vb;
    private Button btnMilitar;
    private BorderPane bPane;
    private GridPane pane;
    private HBox weaponShiled;
    private HBox cargoHold;
    private HBox officer;
    private VBox fuelBar;
    private HBox naveImg;
    private GridPane pane1;

    public NaveAttributesPane (ModelObservable obs, ViewController vc) {
        super(obs, vc);


        /*img.fitWidthProperty().bind(stage.widthProperty());

        pane.setCenter(img);*/

        setListeners();
    }

    @Override
    public void setLayout () {
        // create a tile pane
        pane = new GridPane();


        pane.setVgap(10);
        pane.setHgap(10);

        pane.setMinWidth(width);
        pane.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        pane.setBackground(new Background(new BackgroundFill(Color.rgb(35, 85, 10), CornerRadii.EMPTY, Insets.EMPTY)));

        //pane.setGridLinesVisible(true);

      /*  pane1.addColumn(0, setNave("militar"));
        pane1.addColumn(1, setFuelBar(5));

        pane1.addColumn(2, setWeaponShield(4, 3));
        pane1.addColumn(3, setOfficer(4));

        pane1.addColumn(4,  setCargoHold(6, 0, 0, 0, 0));


        pane.getChildren().addAll(pane1);*/


        this.getChildren().addAll(pane);
    }


    private void atualiza (int weapon, int shield, String nave, int fuel, int officers, int Cargo, int blue, int black, int red, int green) {

        pane.getChildren().remove(pane1);

        pane1 = new GridPane();

        naveImg =       setNave(nave);
        fuelBar =       setFuelBar(fuel);
        weaponShiled =  setWeaponShield(weapon, shield);
        officer =       setOfficer(officers);
        cargoHold =     setCargoHold(Cargo, blue, black, red, green);


        pane1.addColumn(0, naveImg);
        pane1.addColumn(1, fuelBar);
        pane1.addColumn(2, officer);
        pane1.addColumn(3, weaponShiled);

        pane1.addColumn(4, cargoHold);

        pane.getChildren().addAll(pane1);
    }


    @Override
    protected void setListeners () {
        modelo.addPropertyChangeListener(EstadoID.PLANET_ORBIT, new PropertyChangeListener() {
            @Override
            public void propertyChange (PropertyChangeEvent evt) {
                int weapon = modelo.getWeapon();
                int shield = modelo.getShield();
                String nave = modelo.getNaveType();
                int fuel = modelo.getFuel();
                int officers = modelo.getOfficers();
                int Cargo = modelo.getCargoMax();
                int blue = modelo.getBlueResources();
                int black = modelo.getBlackResources();
                int red = modelo.getRedResources();
                int green = modelo.getGreenResources();

                // Convert value of Fuel to 0-100 %
                fuel *= 100;

                if (modelo.getFuelMax() > 50)
                    fuel /= 53;
                else
                    fuel /= 35;

                atualiza(weapon, shield, nave, fuel, officers, Cargo, blue, black, red, green);
            }
        });
    }

    private VBox setFuelBar (int fuel) {
        VBox fuelBox = new VBox();
        //fuelBox.setFillWidth(true);

        ImageView imgVw = new ImageView(new ImageLoader(ImgConstants.FUEL.getName()).getImagem());
        imgVw.setFitWidth(100);
        imgVw.setPreserveRatio(true);

        // create a progressbar
        ProgressBar fuelBar = new ProgressBar((double) fuel/100);


        fuelBar.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));


        fuelBox.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        fuelBox.setSpacing(-20);


        fuelBox.getChildren().addAll(imgVw, fuelBar);

        return fuelBox;
    }

    private HBox setOfficer (int officer) {
        HBox officerBox = new HBox();
        officerBox.setMaxWidth(50);


        ImageView imgOfficer = new ImageView(new ImageLoader(ImgConstants.OFFICER.getName()).getImagem());
        imgOfficer.setFitWidth(50);
        imgOfficer.setPreserveRatio(true);


        Label officerNum = new Label(String.valueOf(officer), imgOfficer);
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


    private HBox setCargoHold (int maxCargo, int blueRes, int blackRes, int redRes, int greenRes) {
        final int imgFit = 25;

        HBox cargoHold = new HBox();
        //cargoHold.setMinWidth(width/6);

        ImageView cargo = new ImageView(new ImageLoader(ImgConstants.CARGO_HOLD.getName()).getImagem());
        cargo.setFitWidth(imgFit * 4);
        cargo.setPreserveRatio(true);


        Label cargoMax = new Label(String.valueOf(maxCargo), cargo);
        cargoMax.setTextFill(Color.WHITE);


        HBox resources = new HBox();
        //resources.setPrefWidth(width/6);


        // Black
        ImageView blackImg = new ImageView(new ImageLoader(ImgConstants.BLACK_CUBE.getName()).getImagem());
        blackImg.setFitWidth(imgFit);
        blackImg.setPreserveRatio(true);

        Label blackLb = new Label(String.valueOf(blackRes), blackImg);
        blackLb.setTextFill(Color.WHITE);
        blackLb.setPadding(new Insets(10, 10, 10, 10));

        // Red
        ImageView redImg = new ImageView(new ImageLoader(ImgConstants.RED_CUBE.getName()).getImagem());
        redImg.setFitWidth(imgFit);
        redImg.setPreserveRatio(true);

        Label redLb = new Label(String.valueOf(redRes), redImg);
        redLb.setTextFill(Color.WHITE);
        redLb.setPadding(new Insets(10, 10, 10, 10));

        // Blue
        ImageView blueImg = new ImageView(new ImageLoader(ImgConstants.BLUE_CUBE.getName()).getImagem());
        blueImg.setFitWidth(imgFit);
        blueImg.setPreserveRatio(true);

        Label blueLb = new Label(String.valueOf(blueRes), blueImg);
        blueLb.setTextFill(Color.WHITE);
        blueLb.setPadding(new Insets(10, 10, 10, 10));

        // Green
        ImageView greenImg = new ImageView(new ImageLoader(ImgConstants.GREEN_CUBE.getName()).getImagem());
        greenImg.setFitWidth(imgFit);
        greenImg.setPreserveRatio(true);

        Label greenLb = new Label(String.valueOf(greenRes), greenImg);
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

    private HBox setWeaponShield (int w, int s) {
        HBox box = new HBox();
        box.setMaxWidth(40);

        // WEAPON

        VBox weaponBox = new VBox();
        weaponBox.setMaxWidth(box.getMaxWidth());

        ImageView weapon = new ImageView(new ImageLoader(ImgConstants.WEAPON.getName()).getImagem());
        weapon.setFitWidth(50);
        weapon.setPreserveRatio(true);

        Label weaponNum = new Label(String.valueOf(w), weapon);
        weaponNum.setTextFill(Color.WHITE);

        weaponBox.getChildren().add(weaponNum);


        //  SHIELDS

        VBox shieldsBox = new VBox();
        shieldsBox.setMaxWidth(60);
        shieldsBox.setMinWidth(60);
        shieldsBox.setPrefWidth(60);

        ImageView shields = new ImageView(new ImageLoader(ImgConstants.SHIELD.getName()).getImagem());
        shields.setFitWidth(35);
        shields.setPreserveRatio(true);

        Label shieldsNum = new Label(String.valueOf(s), shields);
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


    private HBox setNave (String nave) {

        HBox box = new HBox();

        ImageView ship;

        if (!nave.isEmpty()) {
            if (nave.equals(Enums.ShipType.Militar.name()))
                ship = new ImageView(new ImageLoader(ImgConstants.SPACESHIP_MILITAR.getName()).getImagem());
            else
                ship = new ImageView(new ImageLoader(ImgConstants.SPACESHIP_EXPLORER.getName()).getImagem());

            ship.setFitWidth(100);
            ship.setPreserveRatio(true);

            box.getChildren().add(ship);
        }

        return box;
    }

}