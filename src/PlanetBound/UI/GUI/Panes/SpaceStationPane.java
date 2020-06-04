package PlanetBound.UI.GUI.Panes;

import PlanetBound.UI.GUI.Buttons.CaptionButton;
import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SpaceStationPane extends MainPane {

    private CaptionButton buyDroneBtn;
    private CaptionButton hireNewCrewBtn;
    private CaptionButton upgradeWeaponsBtn;
    private CaptionButton upgradeCargoHoldBtn;
    private VBox vbox;

    public SpaceStationPane (ModelObservable obs, ViewController vc) {
        super(obs, vc);

    }

    @Override
    public void setLayout () {
        vbox = setOptionsBtn();

        vbox.setPrefWidth(width/2);
        vbox.setAlignment(Pos.CENTER);


        this.getChildren().addAll(vbox);

    }

    private VBox setOptionsBtn () {
        // Horizontal Box (align Center) w/ Btn to buyDrone hireNewCrew  upgradeWeapons upgradeCargoHold
        VBox box = new VBox();


        buyDroneBtn = new CaptionButton("Buy new Drone", new ImageLoader(ImgConstants.DRONE.getName()).getImagem(), 50, 50, 100, 200);

        hireNewCrewBtn = new CaptionButton("Hire New Crew", new ImageLoader(ImgConstants.OFFICER.getName()).getImagem(), 50, 50, 100, 200);
        upgradeWeaponsBtn = new CaptionButton("Upgrade Weapons", null, 50,50, 50, 200);
        upgradeCargoHoldBtn = new CaptionButton("Upgrade CargoHold", new ImageLoader(ImgConstants.CARGO.getName()).getImagem(), 100, 150, 100, 200);


        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        box.setSpacing(50);

        box.getChildren().addAll(buyDroneBtn, hireNewCrewBtn, upgradeWeaponsBtn, upgradeCargoHoldBtn);


        return box;
    }


}
