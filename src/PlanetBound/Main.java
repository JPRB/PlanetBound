package PlanetBound;

import PlanetBound.GameLogic.Game;
import PlanetBound.UI.GUI.GraphicUI;
import PlanetBound.UI.txt.TextUserInterface;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        /*if (args.length == 0 && args[0].equals("-console")){ // make console work

            Game game = new Game();
            TextUserInterface ui = new TextUserInterface(game);

            ui.run();
        }
        else*/
            launch(args);


    }

    @Override
    public void start (Stage stage) throws Exception {
        Game game = new Game();
        GraphicUI gameInterface = new GraphicUI(stage, game);

        gameInterface.run();

    }
}
