package PlanetBound.UI.GUI.Panes;

import PlanetBound.UI.GUI.Images.ImageLoader;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class NaveAttributesPane extends MainPane {

    private VBox vb;
    private Button btnMilitar;
    private BorderPane bPane;
    private TilePane pane;

    public NaveAttributesPane (ModelObservable obs, ViewController vc) {
        super(obs, vc);




    }

    @Override
    public void setLayout () {
        // create a tile pane
        pane = new TilePane();


        pane.setMaxWidth(width/2);
        pane.setPrefHeight(height);
        pane.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        pane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));



        pane.getChildren().add(setFuelBar());

        this.getChildren().addAll(pane);
    }



    public VBox setFuelBar()
    {
        VBox fuelBox = new VBox();


        
        ImageView imgVw = new ImageView(new ImageLoader(FUEL_ICON).getImagem());
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
}