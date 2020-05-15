package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;


public class AwaitStationDecisions extends EstadosAdapter {


    public AwaitStationDecisions (GameData data) {
        super(data);
    }

    @Override
    public IEstados getItemsSpaceStations (int item) {

        if (getGameData().getNave().getCombustivel() <= 1)
            return new GameOver(getGameData());

        switch (item) {
            case 1:
                convertResources();
                break;
            case 2:
                buyDrone();
                break;
            case 3:
                hireNewoOfficer();
                break;
            case 4:
                upgradeWeapons();
                break;
            case 5:
                upgradeCargoHold();
                break;
            default:

        }
        getGameData().getNave().wasteFuel(1);

        return this;
    }

    @Override
    public IEstados moveToPlanet () {
        getGameData().getNave().wasteFuel(1);

        if (getGameData().getNave().getCombustivel() < 1)
            return new GameOver(getGameData());

        return new PlanetOrbit(getGameData());
    }

    private void buyDrone () {
        //red, black, green and blue
        if (getGameData().getSetor().getSpaceStation().buyDrone(getGameData().getNave()))
            getGameData().addMsgLog("Comprou uma Drone novo!");
        else
            getGameData().addMsgLog("Não consigo comprar um drone novo!");

    }

    private void hireNewoOfficer () {
        // red green blue black
        Nave nave = getGameData().getNave();
        // verify if ship need anyone
        if (nave.getOfficers() < 6) {
            if (getGameData().getSetor().getSpaceStation().hireNewCrew(nave))
                getGameData().addMsgLog("Novo Oficial contratado!");

        } else {
            getGameData().addMsgLog("Não é possivel contratar novos membros");
        }
    }

    // TODO ?
    private void upgradeWeapons () {
        // red, black, green and blue
        getGameData().getSetor().getSpaceStation().upgradeWeapons();
    }

    // TODO ?
    private void convertResources () {
        // isto -> naquilo
        getGameData().getSetor().getSpaceStation().convertResources();
    }

    private void upgradeCargoHold () {
        boolean can = false;
        try {
            can = getGameData()
                    .getSetor()
                    .getSpaceStation()
                    .upgradeCargoHold(getGameData().getNave());


        } catch (Exception e) {
            getGameData().addMsgLog(e.getMessage());
        }

        if (!can) {
            getGameData().addMsgLog("Não é possivel fazer upgrade nesta estação");
        } else
            getGameData().addMsgLog("Porão UPGRATED!!");
    }

}
