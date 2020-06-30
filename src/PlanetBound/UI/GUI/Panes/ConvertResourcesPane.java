package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.UI.GUI.Buttons.CaptionButton;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConvertResourcesPane extends MainPane {


    private CaptionButton convertIntoArmor;
    private CaptionButton convertIntoFuel;
    private CaptionButton convertIntoShield;

    private CaptionButton blackToRedBtn;
    private CaptionButton blackToGreenBtn;
    private CaptionButton blackToBlueBtn;
    private CaptionButton blueToBlackBtn;
    private CaptionButton blueToRedBtn;
    private CaptionButton blueToGreenBtn;
    private CaptionButton redToGreenBtn;
    private CaptionButton redToBlackBtn;
    private CaptionButton redToBlueBtn;
    private CaptionButton greenToRedBtn;
    private CaptionButton greenToBlackBtn;
    private CaptionButton greenToBlueBtn;
    private CaptionButton backBtn;

    public ConvertResourcesPane (ModelObservable model, ViewController vc) {
        super(model, vc);

        setListeners();
    }

    @Override
    public void setLayout () {

        BorderPane bp = new BorderPane();
        GridPane pane = new GridPane();
        this.setPrefSize(width, height);
        this.setMaxSize(width, height);
        this.setMinSize(width, height);

        pane.setPrefSize(200, 100);


        pane.addColumn(0, setGreenToBtn());
        pane.addColumn(1, setRedToBtn());
        pane.addColumn(2, setBlueToBtn());
        pane.addColumn(3, setBlackToBtn());


        ImageView backGround = new ImageView(new ImageLoader(ImgConstants.SPACE.getName()).getImagem());

        bp.getChildren().addAll(backGround);
        bp.setCenter(pane);
        bp.setBottom(setConvertersBtn());

        this.getChildren().addAll(bp);
    }

    private VBox setBlackToBtn () {
        VBox vb = new VBox();

        blackToRedBtn = new CaptionButton("", new ImageLoader(ImgConstants.BLACK_CUBE_RED.getName()).getImagem(), 125, 125, 60, 125);
        blackToRedBtn.setOpacity(0.9);

        blackToGreenBtn = new CaptionButton("", new ImageLoader(ImgConstants.BLACK_CUBE_GREEN.getName()).getImagem(), 125, 125, 60, 125);
        blackToGreenBtn.setOpacity(0.9);

        blackToBlueBtn = new CaptionButton("", new ImageLoader(ImgConstants.BLACK_CUBE_BLUE.getName()).getImagem(), 125, 125, 60, 125);
        blackToBlueBtn.setOpacity(0.9);

        vb.setAlignment(Pos.CENTER);

        vb.setPadding(new Insets(20, 20, 50, 20));
        vb.setSpacing(25);

        vb.getChildren().addAll(blackToRedBtn, blackToGreenBtn, blackToBlueBtn);


        return vb;
    }

    private VBox setBlueToBtn () {
        VBox vb = new VBox();


        blueToRedBtn = new CaptionButton("", new ImageLoader(ImgConstants.BLUE_CUBE_RED.getName()).getImagem(), 125, 125, 60, 125);
        blueToRedBtn.setOpacity(0.9);

        blueToBlackBtn = new CaptionButton("", new ImageLoader(ImgConstants.BLUE_CUBE_BLACK.getName()).getImagem(), 125, 125, 60, 125);
        blueToBlackBtn.setOpacity(0.9);

        blueToGreenBtn = new CaptionButton("", new ImageLoader(ImgConstants.BLUE_CUBE_GREEN.getName()).getImagem(), 125, 125, 60, 125);
        blueToGreenBtn.setOpacity(0.9);

        vb.setAlignment(Pos.CENTER);

        vb.setPadding(new Insets(20, 20, 50, 20));
        vb.setSpacing(25);

        vb.getChildren().addAll(blueToRedBtn, blueToBlackBtn, blueToGreenBtn);


        return vb;
    }

    private VBox setRedToBtn () {
        VBox vb = new VBox();


        redToGreenBtn = new CaptionButton("", new ImageLoader(ImgConstants.RED_CUBE_GREEN.getName()).getImagem(), 125, 125, 60, 125);
        redToGreenBtn.setOpacity(0.9);

        redToBlackBtn = new CaptionButton("", new ImageLoader(ImgConstants.RED_CUBE_BLACK.getName()).getImagem(), 125, 125, 60, 125);
        redToBlackBtn.setOpacity(0.9);

        redToBlueBtn = new CaptionButton("", new ImageLoader(ImgConstants.RED_CUBE_BLUE.getName()).getImagem(), 125, 125, 60, 125);
        redToBlueBtn.setOpacity(0.9);

        vb.setAlignment(Pos.CENTER);

        vb.setPadding(new Insets(20, 20, 50, 20));
        vb.setSpacing(25);

        vb.getChildren().addAll(redToGreenBtn,
                redToBlackBtn,
                redToBlueBtn);


        return vb;
    }

    private VBox setGreenToBtn () {
        VBox vb = new VBox();


        greenToRedBtn = new CaptionButton("", new ImageLoader(ImgConstants.GREEN_CUBE_RED.getName()).getImagem(), 125, 125, 60, 125);
        greenToRedBtn.setOpacity(0.9);

        greenToBlackBtn = new CaptionButton("", new ImageLoader(ImgConstants.GREEN_CUBE_BLACK.getName()).getImagem(), 125, 125, 60, 125);
        greenToBlackBtn.setOpacity(0.9);

        greenToBlueBtn = new CaptionButton("", new ImageLoader(ImgConstants.GREEN_CUBE_BLUE.getName()).getImagem(), 125, 125, 60, 125);
        greenToBlueBtn.setOpacity(0.9);


        vb.setAlignment(Pos.CENTER);

        vb.setPadding(new Insets(20, 20, 50, 20));
        vb.setSpacing(25);

        vb.getChildren().addAll(greenToRedBtn, greenToBlackBtn, greenToBlueBtn);


        return vb;
    }

    private HBox setConvertersBtn () {
        HBox box = new HBox();


        convertIntoArmor = new CaptionButton("Converter em Armor", null, 100, 125);
        convertIntoArmor.setOpacity(0.9);
        convertIntoArmor.setStyle("-fx-font-weight: bold");

        convertIntoFuel = new CaptionButton("Converter em Fuel", null, 100, 125);
        convertIntoFuel.setStyle("-fx-font-weight: bold");
        convertIntoFuel.setOpacity(0.9);

        convertIntoShield = new CaptionButton("Converter em shield", null, 100, 125);
        convertIntoShield.setStyle("-fx-font-weight: bold");
        convertIntoShield.setOpacity(0.9);

        backBtn = new CaptionButton("Voltar", new ImageLoader(ImgConstants.BLACK_PLANET.getName()).getImagem(), 50, 50,100, 125);
        backBtn.setStyle("-fx-font-weight: bold");
        backBtn.setOpacity(0.9);

        box.getChildren().addAll(convertIntoArmor, convertIntoFuel, convertIntoShield, backBtn);


        box.setAlignment(Pos.BOTTOM_CENTER);

        box.setPadding(new Insets(20, 20, 50, 20));
        box.setSpacing(25);

        return box;
    }


    @Override
    protected void setListeners () {

        // back to planet orbit
        backBtn.setOnAction(actionEvent -> {
            modelo.move();
        });

        convertIntoArmor.setOnAction(actionEvent -> {
            modelo.convertIntoArmor();
        });

        convertIntoFuel.setOnAction(actionEvent -> {
            modelo.convertIntoFuel();
        });

        convertIntoShield.setOnAction(actionEvent -> {
            modelo.convertIntoShield();
        });

        blackToRedBtn.setOnAction(actionEvent -> {
            modelo.convertResblackToRedBtn();
        });

        blackToGreenBtn.setOnAction(actionEvent -> {
            modelo.convertResblackToGreenBtn();
        });

        blackToBlueBtn.setOnAction(actionEvent -> {
            modelo.convertResblackToBlueBtn();
        });

        blueToBlackBtn.setOnAction(actionEvent -> {
            modelo.convertResblueToBlackBtn();
        });

        blueToRedBtn.setOnAction(actionEvent -> {
            modelo.convertResblueToRedBtn();
        });

        blueToGreenBtn.setOnAction(actionEvent -> {
            modelo.convertResblueToGreenBtn();
        });

        redToGreenBtn.setOnAction(actionEvent -> {
            modelo.convertResredToGreenBtn();
        });

        redToBlackBtn.setOnAction(actionEvent -> {
            modelo.convertResredToBlackBtn();
        });

        redToBlueBtn.setOnAction(actionEvent -> {
            modelo.convertResredToBlueBtn();
        });

        greenToRedBtn.setOnAction(actionEvent -> {
            modelo.convertResgreenToRedBtn();
        });

        greenToBlackBtn.setOnAction(actionEvent -> {
            modelo.convertResgreenToBlackBtn();
        });

        greenToBlueBtn.setOnAction(actionEvent -> {
            modelo.convertResgreenToBlueBtn();
        });

    }
}
