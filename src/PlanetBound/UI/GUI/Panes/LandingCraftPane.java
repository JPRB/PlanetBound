package PlanetBound.UI.GUI.Panes;

import PlanetBound.GameLogic.Estados.EstadoID;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Enums.EResources;
import PlanetBound.UI.GUI.ModelObservable;
import PlanetBound.UI.GUI.ViewController;
import PlanetBound.UI.Resources.ImageLoader;
import PlanetBound.UI.Resources.ImgConstants;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LandingCraftPane extends MainPane {


    private GridPane pane;
    private TextField keyEvent;

    private ImageView alien;
    private ImageView resource = null;
    private ImageView localToCollect;

    private ImageView drone = null;


    public LandingCraftPane (ModelObservable obs, ViewController vc) {
        super(obs, vc);

        alien = new ImageView();
        setListeners();
    }

    @Override
    public void setLayout () {

        pane = new GridPane();
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(25);
        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(25);
        pane.getColumnConstraints().addAll(cc, cc, cc, cc, cc, cc);
        pane.getRowConstraints().addAll(rc, rc, rc, rc, rc, rc);

        int row = 6;
        int col = 6;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pane.add(new Label(), j, i);
            }
        }


        pane.setPrefSize(width, height);
        pane.setGridLinesVisible(true);
        this.getChildren().addAll(setKeyEvent(), pane);
    }

    private void setPos (ImageView img, int x, int y) {
        img.setPreserveRatio(true);
        img.setFitWidth(50);
        img.setFitHeight(50);

        pane.setAlignment(Pos.BASELINE_CENTER);
        pane.getChildren().remove(img);
        pane.add(img, x, y);
    }


    private void setImg (ImageView oldImg, Image newImg) {
        oldImg.setImage(newImg);
    }

    @Override
    protected void setListeners () {
        keyEvent.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    modelo.moveDrone(1);
                    System.out.println("up");
                    break;
                case DOWN:
                    modelo.moveDrone(4);
                    System.out.println("DOWN");
                    break;
                case LEFT:
                    modelo.moveDrone(3);
                    System.out.println("LEFT");
                    break;
                case RIGHT:
                    modelo.moveDrone(2);
                    System.out.println("RIGHT");
                    break;
                default:
            }
        });

        modelo.addPropertyChangeListener(EstadoID.EXPLORE_RESOURCES,
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange (PropertyChangeEvent evt) {
                        setDrone();

                        setAlien();

                        setResource();

                        setLocalToCollect();
                    }
                });
    }


    private void setAlien () {
        //if (alien.getImage() == null || modelo.getEstadoAlien()) {
            switch (modelo.getAlien()) {
                case BLACK_ALIEN:
                    setImg(alien, new ImageLoader(ImgConstants.BLACK_ALIEN.getName()).getImagem());
//                    alien = new ImageView(new ImageLoader(ImgConstants.BLACK_ALIEN.getName()).getImagem());
                    break;
                case RED_ALIEN:
                    setImg(alien, new ImageLoader(ImgConstants.RED_ALIEN.getName()).getImagem());
//                    alien = new ImageView(new ImageLoader(ImgConstants.RED_ALIEN.getName()).getImagem());
                    break;
                case BLUE_ALIEN:
                    setImg(alien, new ImageLoader(ImgConstants.BLUE_ALIEN.getName()).getImagem());
//                    alien = new ImageView(new ImageLoader(ImgConstants.BLUE_ALIEN.getName()).getImagem());
                    break;
                case GREEN_ALIEN:
                    setImg(alien, new ImageLoader(ImgConstants.GREEN_ALIEN.getName()).getImagem());
//                    alien = new ImageView(new ImageLoader(ImgConstants.GREEN_ALIEN.getName()).getImagem());
                    break;
            //}
        }
        setAlienPos();
    }

    private void setAlienPos () {
        int x = modelo.getAlienPos()[0];
        int y = modelo.getAlienPos()[1];
        setPos(alien, x, y);
    }

    private void setResource () {
        if (resource == null) {
            switch (modelo.getResource()) {
                case "black":
                    resource = new ImageView(new ImageLoader(ImgConstants.BLACK_CUBE.getName()).getImagem());
                    break;
                case "blue":
                    resource = new ImageView(new ImageLoader(ImgConstants.BLUE_CUBE.getName()).getImagem());
                    break;
                case "green":
                    resource = new ImageView(new ImageLoader(ImgConstants.GREEN_CUBE.getName()).getImagem());
                    break;
                case "red":
                    resource = new ImageView(new ImageLoader(ImgConstants.RED_CUBE.getName()).getImagem());
                    break;
            }

            int x = modelo.getPosResource()[0];
            int y = modelo.getPosResource()[1];
            setPos(resource, x, y);
        }
    }

    private void setLocalToCollect () {
        /*int x = modelo.getPosDrone()[0];
        int y = modelo.getPosDrone()[1];
        setPos(localToCollect, x, y);*/
    }

    private void setDrone () {
        if (drone == null)
            drone = new ImageView(new ImageLoader(ImgConstants.DRONE.getName()).getImagem());

        setDronePos();
    }


    private void setDronePos () {
        int x = modelo.getDronePos()[0];
        int y = modelo.getDronePos()[1];
        setPos(drone, x, y);
    }


    // AUX METHOD

    private TextField setKeyEvent () {
        keyEvent = new TextField();
        keyEvent.setMaxSize(0, 0);
        keyEvent.setPrefSize(0, 0);
        keyEvent.setMinSize(0, 0);
        keyEvent.requestFocus();

        return keyEvent;
    }

}
