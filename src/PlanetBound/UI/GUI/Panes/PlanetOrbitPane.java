package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Dados.Setor.SpaceStation;
import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.UI.GUI.Buttons.CaptionButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlanetOrbitPane extends MainPane {

    private CaptionButton explorerBtn;
    private CaptionButton newPlanetBtn;
    private CaptionButton spaceStationBtn;
    private HBox planet;
    private BorderPane bp;
    private HBox btns;

    public PlanetOrbitPane (ModelObservable model, ViewController vc) {
        super(model, vc);


        this.getChildren().addAll(bp);

        modelo.addPropertyChangeListener(EstadoID.PLANET_ORBIT,
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange (PropertyChangeEvent evt) {
                        atualiza();
                        System.out.println("aqui");
                    }
                });




        setListeners();
    }

    @Override
    public void setLayout () {
        bp = new BorderPane();
        bp.setPrefSize(width, height);
        bp.setMaxSize(width, height);
        bp.setMinSize(width, height);

        atualiza();
    }

    private void atualiza () {
        bp.setCenter(planet = setPlanet());
        bp.setBottom(btns = setBtns());
    }

    private HBox setPlanet () {
        HBox box = new HBox();
        String planetURI;


        System.out.println(modelo.getPlanetType().toString());

        switch (modelo.getPlanetType()) {
            case BLACKPLANET:
                planetURI = ImgConstants.BLACK_PLANET.getName();
                break;
            case REDPLANET:
                planetURI = ImgConstants.RED_PLANET.getName();
                break;
            case BLUEPLANET:
                planetURI = ImgConstants.BLUE_PLANET.getName();
                break;
            case GREENPLANET:
                planetURI = ImgConstants.GREEN_PLANET.getName();
                break;
            default:
                planetURI = null;

        }

        ImageView img = new ImageView(new ImageLoader(planetURI).getImagem());
        img.setFitWidth(300);
        img.setPreserveRatio(true);

        box.getChildren().addAll(img);

        box.setAlignment(Pos.CENTER);

        return box;
    }


    public HBox setBtns () {
        HBox box = new HBox();


        explorerBtn = new CaptionButton("Explorar Planeta", new ImageLoader(ImgConstants.DRONE.getName()).getImagem(), 50, 50, 100, 200);
        explorerBtn.setOpacity(0.9);
        //explorerBtn.setColor("#a7c7e0");
        explorerBtn.setStyle("-fx-font-weight: bold");

        newPlanetBtn = new CaptionButton("Ir para novo Planeta", new ImageLoader(ImgConstants.OFFICER.getName()).getImagem(), 50, 50, 100, 200);
        newPlanetBtn.setStyle("-fx-font-weight: bold");
        // newPlanetBtn.setColor("#a7c7e0");
        newPlanetBtn.setOpacity(0.9);

        spaceStationBtn = new CaptionButton("Visitar Estação Espacial", new ImageLoader(ImgConstants.SPACE_STATION.getName()).getImagem(), 50, 50, 100, 200);
        spaceStationBtn.setStyle("-fx-font-weight: bold");
        //spaceStationBtn.setColor("#a7c7e0");
        spaceStationBtn.setOpacity(0.9);

        box.getChildren().addAll(explorerBtn, newPlanetBtn);

        if (modelo.getStation())
            box.getChildren().addAll(spaceStationBtn);

        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        box.setPadding(new Insets(20, 20, 50, 20));
        box.setSpacing(25);

        return box;
    }

    @Override
    protected void setListeners () {
        explorerBtn.setOnAction(new ExploreListener());
        newPlanetBtn.setOnAction(new NewPlanetListener());
        spaceStationBtn.setOnAction(new SpaceStationListener());


    }

    private class NewPlanetListener implements EventHandler<ActionEvent> {

        @Override
        public void handle (ActionEvent actionEvent) {
            modelo.move();
        }
    }

    private class ExploreListener implements EventHandler<ActionEvent> {

        @Override
        public void handle (ActionEvent actionEvent) {

        }
    }

    private class SpaceStationListener implements EventHandler<ActionEvent> {

        @Override
        public void handle (ActionEvent actionEvent) {
            modelo.moveToSpaceStation();
        }
    }

}
