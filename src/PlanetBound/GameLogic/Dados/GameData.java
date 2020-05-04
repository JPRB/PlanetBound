package PlanetBound.GameLogic.Dados;

import PlanetBound.GameLogic.Dados.Nave.Explorer;
import PlanetBound.GameLogic.Dados.Nave.FactoryNave;
import PlanetBound.GameLogic.Dados.Nave.Militar;
import PlanetBound.GameLogic.Dados.Nave.Nave;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    // Nave
    private Nave nave;
    private Planet planeta;

    private final List<String> msgLog;

    public GameData () {
        initializeData();


        msgLog = new ArrayList<>();

    }


    public String getNave () {
        return nave.toString();
    }

    public List<String> getMsgLog() {
        return msgLog;
    }

    public void chooseShip (int ship) {
        nave = FactoryNave.criaNave(ship);
    }


    public void initializeData() {
        planeta = new Planet();


    }

}
