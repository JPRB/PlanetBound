package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.GUI.Buttons.CaptionButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class PlanetOrbitPane extends MainPane implements PropertyChangeListener {

    private CaptionButton explorerBtn;
    private CaptionButton newPlanetBtn;
    private CaptionButton spaceStationBtn;
    private HBox planet;
    private BorderPane bp;
    private HBox btns;
    ImageView img;
    ChoiceDialog d;

    public PlanetOrbitPane (ModelObservable model, ViewController vc) {
        super(model, vc);

         this.getChildren().addAll(bp);

        modelo.addPropertyChangeListener(EstadoID.PLANET_ORBIT, this);


        setListener();

        propertyChange(null);
    }

    @Override
    public void setLayout () {
        bp = new BorderPane();

        bp.setPrefSize(width, height);
        bp.setMaxSize(width, height);
        bp.setMinSize(width, height);

        List<Enums.Events> l = new ArrayList<>();
        for (Enums.Events evt : Enums.Events.values()){
            l.add(evt);
        }

        // create a choice dialog
        d = new ChoiceDialog<Enums.Events>(l.get(0), l);
        // setheader text
        d.setHeaderText("Selecione o evento que quer. \nPara avançar normalmente, basta cancelar!");


        atualiza();
    }

    private void atualiza () {
        bp.setBottom(null);
        bp.setBottom(setBtns());

        bp.setCenter(setPlanet());
    }


    private ImageView setImgPlanet() {
        String planetURI;

        switch (modelo.getPlanetType()) {
            case BLACK_PLANET:
                planetURI = ImgConstants.BLACK_PLANET.getName();
                break;
            case RED_PLANET:
                planetURI = ImgConstants.RED_PLANET.getName();
                break;
            case BLUE_PLANET:
                planetURI = ImgConstants.BLUE_PLANET.getName();
                break;
            case GREEN_PLANET:
                planetURI = ImgConstants.GREEN_PLANET.getName();
                break;
            default:
                planetURI = null;
        }

        return new ImageView(new ImageLoader(planetURI).getImagem());
    }

    private HBox setPlanet () {
        HBox box = new HBox();

        System.out.println(modelo.getPlanetType().toString());

        img = setImgPlanet();
        img.setFitWidth(300);
        img.setPreserveRatio(true);

        box.getChildren().addAll(img);

        box.setAlignment(Pos.CENTER);

        box.setBorder(new Border(new BorderStroke(Color.PINK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

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

        box.getChildren().addAll(explorerBtn, newPlanetBtn, spaceStationBtn);


        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        box.setPadding(new Insets(20, 20, 50, 20));
        box.setSpacing(25);

        return box;
    }


    protected void setListener () {
        explorerBtn.setOnAction(actionEvent -> {
            modelo.explorePlanet();
        });

        spaceStationBtn.setOnAction(actionEvent -> {
            modelo.moveToSpaceStation();
        });

        newPlanetBtn.setOnAction(actionEvent -> {
            // show the dialog
            Optional<Enums.Events> evt = d.showAndWait();
            int val = -1;

            if (evt.isPresent())
                val = evt.get().getValue();

            System.out.println(val);

            modelo.doEvent(val);
        });


    }

    @Override
    protected void setListeners () {

    }

    @Override
    public void propertyChange (PropertyChangeEvent evt) {
        // bp.setCenter(null);
        planet = setPlanet();

        spaceStationBtn.setVisible(modelo.getStation());
        spaceStationBtn.setManaged(modelo.getStation());
        bp.setCenter(planet);


    }



}
