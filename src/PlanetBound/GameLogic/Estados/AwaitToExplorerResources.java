package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;
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
        int[] posDrone = superficie.getDronePos();
        int[] posResource = superficie.getResourcePos();
        int[] posAlien = superficie.getAlienPos();

        switch (value) {
            // Top
            case 1:
                superficie.setDronePos(posDrone[0], posDrone[1] - 1);
                break;
            // Right
            case 2:
                superficie.setDronePos(posDrone[0] + 1, posDrone[1]);
                break;
            // Left
            case 3:
                superficie.setDronePos(posDrone[0] - 1, posDrone[1]);
                break;
            // Bot
            case 4:
                superficie.setDronePos(posDrone[0], posDrone[1] + 1);
                break;

        }
        posDrone = superficie.getDronePos();

        System.out.println(String.format("Recurso (X, Y): (%d, %d)", posResource[0], posResource[1]));
        System.out.println(String.format("Drone (X, Y): (%d, %d)", posDrone[0], posDrone[1]));
        System.out.println(String.format("ALIEN (X, Y): (%d, %d)", posAlien[0], posAlien[1]));

        if (posDrone[0] == posResource[0] && posDrone[1] == posResource[1]) {
            try {
                Resources resources = collectResource(getGameData().getSetor().getPlaneta());
                boolean collected = getGameData().getNave().collectResource(resources);

                if (collected)
                    getGameData().addMsgLog("Recolheu " + resources.getResourceVal() + " recurso " + resources.getCor());
                else
                    getGameData().addMsgLog("Eram demasiados recursos. Tentou-se recolher recursos " + resources.getCor());


                if (getGameData().getNave().getCarga().getResource(Enums.PlanetResources.artifact.name()).getResourceVal() == 5)
                {
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
        int val=1;
        Resources resources = new Resources(planeta.getSuperficie().getResource().getCor());

        planeta.removeRecurso(resources);

        if (!resources.getCor().equals(Enums.PlanetResources.artifact.name()))
            val = Dice.rollD6();

        resources.setResourceVal(val);

        return resources;
    }


}
