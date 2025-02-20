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
                buyDrone();
                break;
            case 2:
                hireNewoOfficer();
                break;
            case 3:
                upgradeWeapons();
                break;
            case 4:
                upgradeCargoHold();
                break;
            default:

        }
        getGameData().getNave().wasteFuel(1);

        return new AwaitStationDecisions(getGameData());
    }

    @Override
    public IEstados move () {
        getGameData().getNave().wasteFuel(1);

        if (getGameData().getNave().getCombustivel() < 1)
            return new GameOver(getGameData());

        return new PlanetOrbit(getGameData());
    }

    private void buyDrone () {
        //red, black, green and blue
        if (getGameData().getSetor().getSpaceStation().buyDrone(getGameData().getNave()))
            getGameData().addMsgLog("Comprou um Drone novo!");
        else
            getGameData().addMsgLog("Não é possivel comprar um drone novo!");

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

    private void upgradeCargoHold () {
        boolean can = false;
        Nave nave = getGameData().getNave();
        if (!nave.officersNeeded()) {
            try {
                can = getGameData()
                        .getSetor()
                        .getSpaceStation()
                        .upgradeCargoHold(nave);


            } catch (Exception e) {
                getGameData().addMsgLog(e.getMessage());
            }

            if (!can) {
                getGameData().addMsgLog("Não é possivel fazer upgrade nesta estação");
            } else {
                getGameData().addMsgLog("Porão UPGRATED!!");
            }
        }
        else
            getGameData().addMsgLog("Não tem officer para realizar esta ação.");

    }

    @Override
    public EstadoID getEstadoID () {
        return EstadoID.AWAIT_STATION_DECISIONS;
    }

}
