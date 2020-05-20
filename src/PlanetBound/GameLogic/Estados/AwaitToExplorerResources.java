package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.Aliens.Alien;
import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Drone;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Dados.Setor.Planetas.Planet;
import PlanetBound.GameLogic.Dados.Setor.Planetas.PlanetSuperficie;
import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;

public class AwaitToExplorerResources extends EstadosAdapter {


    public AwaitToExplorerResources (GameData data) {
        super(data);
    }


    @Override
    public IEstados moveDrone (int value) {

        PlanetSuperficie superficie = getGameData().getSetor().getPlaneta().getSuperficie();
        Alien alien = getGameData().getSetor().getPlaneta().getSuperficie().getAlien();
        Drone drone = getGameData().getNave().getDrone();

        int[] posDrone = drone.getXY();
        int[] posResource = superficie.getResourcePos();
        // int[] posAlien = superficie.getAlienPos();

        try {
            switch (value) {
                // Top
                case 1:
                    drone.setPos(posDrone[0], posDrone[1] - 1);
                    break;
                // Right
                case 2:
                    drone.setPos(posDrone[0] + 1, posDrone[1]);
                    break;
                // Left
                case 3:
                    drone.setPos(posDrone[0] - 1, posDrone[1]);
                    break;
                // Bot
                case 4:
                    drone.setPos(posDrone[0], posDrone[1] + 1);
                    break;

            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            getGameData().addMsgLog(exc.getMessage());
        }

        // ALIEN INTERACTION W/ DRONE
        if (alien.hasDied())
            superficie.setAlien();
        else
            alien.interaction(drone);


        // posDrone = superficie.getDronePos();

        getGameData().addMsgLog(String.format("Recurso (X, Y): (%d, %d)", posResource[0], posResource[1]));
        getGameData().addMsgLog(String.format("Drone (X, Y): (%d, %d)", drone.getX(), drone.getY()));
        getGameData().addMsgLog(String.format("ALIEN (X, Y): (%d, %d)", alien.getX(), alien.getY()));

        if (posDrone[0] == posResource[0] && posDrone[1] == posResource[1]) {
            try {
                // Recurso Planet
                Resources resources = collectResource(getGameData().getSetor().getPlaneta());
                // ADD recurso PORÃO
                boolean collected = getGameData().getNave().collectResource(resources);

                if (collected)
                    getGameData().addMsgLog("Recolheu " + resources.getResourceVal() + " recurso " + resources.getCor());
                else
                    getGameData().addMsgLog("Eram demasiados recursos. Tentou-se recolher recursos " + resources.getCor());


                if (getGameData().getNave().getCarga().getResource(Enums.PlanetResources.artifact.name()).getResourceVal() == 5) {
                    getGameData().addMsgLog("Ganhaste!!! Parabéns");
                    return new GameOver(getGameData());
                }


                return new PlanetOrbit(getGameData());

            } catch (NullPointerException npe) {
                getGameData().addMsgLog("Não conseguiu adicionar recurso à Carga.");
                getGameData().addMsgLog("Info: " + npe);

            } catch (Exception e) {
                getGameData().addMsgLog("Não conseguiu coletar recurso");
                getGameData().addMsgLog("Info: " + e);
            }
        }

        return this;
    }

    private Resources collectResource (Planet planeta) throws NullPointerException {
        int val = 1;
        Resources resources = new Resources(planeta.getSuperficie().getResource().getCor());

        planeta.removeRecurso(resources);

        if (!resources.getCor().equals(Enums.PlanetResources.artifact.name()))
            val = Dice.rollD6();

        resources.setResourceVal(val);

        return resources;
    }


}
