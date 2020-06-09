package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;

public class AwaitConvertResource extends EstadosAdapter {

    public AwaitConvertResource (GameData data) {
        super(data);
    }

   /* Black -> Red",
            "Black -> Green",
            "Black -> Blue",
            "Red -> Black",
            "Red -> Green",
            "Red -> Blue",
            "Green -> Black",
            "Green -> Red",
            "Green -> Blue",
            "Blue -> Red",
            "Blue -> Black",
            "Blue -> Green"*/


    public IEstados convertResources (int value) {

        boolean converted = false;

        Nave nave = getGameData().getNave();

        if (!nave.haveCargoOfficer()) {
            getGameData().addMsgLog("Não tem oficial para esta tarefa. Vá até uma spaceStation contratar outro.");
            return new PlanetOrbit(getGameData());
        }

        switch (value) {
            case 1:
                converted = nave.convertIntoFuel();
                break;
            case 2:
                converted = nave.convertIntoShield();
                break;
            case 3:
                converted = nave.convertIntoAMMO();
                break;
            default:
                getGameData().addMsgLog("Opção Inválida");
        }

        if (!converted)
            getGameData().addMsgLog("Não conseguiu converter os recursos");


        return this;
    }

    @Override
    public EstadoID getEstadoID () {
        return EstadoID.CONVERT_RESORUCES;
    }


    // move to Ship in Planet Orbit
    @Override
    public IEstados move () {
        return new PlanetOrbit(getGameData());
    }

    private void convertResources () {

        // Convert one resource in other
        // Ex.: 1 green -> black

    }

}
