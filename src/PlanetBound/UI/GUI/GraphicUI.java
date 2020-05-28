package PlanetBound.UI.GUI;

import PlanetBound.GameLogic.Game;
import PlanetBound.UI.GUI.Buttons.DefaultButton;
import PlanetBound.UI.GUI.Panes.MainPane;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GraphicUI implements Constants {
    static MediaPlayer mp;

    private Game gameLogic;
    private Stage initialStage;


    public GraphicUI (Stage stage, Game game) {
        gameLogic = game;
        initialStage = stage;
    }

    public void run () {
        //gameMusic();
        ModelObservable modelObs = new ModelObservable();
        ViewController vc = new ViewController(modelObs);

        Scene scene = new Scene(vc.getRootPane());
        // setCursor(scene);
        showStage(scene);
    }

    private void setCursor (Scene scene) {
        try {
            Image imageCursor = new Image(getClass().getResourceAsStream("Images\\cursor.png"));

            scene.setCursor(new ImageCursor(imageCursor));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void showStage (Scene scene) {
        initialStage.setTitle("Planet Bound");


        initialStage.setResizable(false);
        initialStage.centerOnScreen();
        initialStage.setHeight(600);
        initialStage.setWidth(800);

        initialStage.setScene(scene);
        initialStage.show();
        /*initialStage.setOnCloseRequest(e -> {
            Platform.exit();
        });*/
    }


    private void gameMusic () {

        try {
            Media music = new Media(getClass().getResource(MAIN_MUSIC).toExternalForm());
            mp = new MediaPlayer(music);

            mp.setStopTime(Duration.INDEFINITE);
            mp.setAutoPlay(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }


    private void muteMusic () {
        mp.setMute(true);
    }
}
