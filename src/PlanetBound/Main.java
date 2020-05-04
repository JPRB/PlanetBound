package PlanetBound;

import PlanetBound.GameLogic.Game;
import PlanetBound.UI.txt.TextUserInterface;

public class Main {

    public static void main(String[] args) {
        Game g = new Game();
        TextUserInterface ui = new TextUserInterface(g);

        ui.run();
    }
}
