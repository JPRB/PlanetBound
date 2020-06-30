package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        else
            getGameData().addMsgLog("Recurso convertido com sucesso");

        return new AwaitConvertResource(getGameData());
    }

    @Override
    public EstadoID getEstadoID () {
        return EstadoID.CONVERT_RESOURCES;
    }


    // move to Ship in Planet Orbit
    @Override
    public IEstados move () {
        return new PlanetOrbit(getGameData());
    }

    public IEstados convertResourceInOther (int value) {

        // Convert one resource in other
        // Ex.: 1 green -> black
        boolean converted = false;

        Nave nave = getGameData().getNave();

        if (!nave.haveCargoOfficer()) {
            getGameData().addMsgLog("Não tem oficial para esta tarefa. Vá até uma spaceStation contratar outro.");
            return new PlanetOrbit(getGameData());
        }


        switch (value) {
            case 1:
                converted = convertResourceIn(Enums.EResources.black.name(), Enums.EResources.red.name());
                break;
            case 2:
                converted = convertResourceIn(Enums.EResources.black.name(), Enums.EResources.green.name());
                break;
            case 3:
                converted = convertResourceIn(Enums.EResources.black.name(), Enums.EResources.blue.name());
                break;


            case 4:
                converted = convertResourceIn(Enums.EResources.blue.name(), Enums.EResources.black.name());
                break;
            case 5:
                converted = convertResourceIn(Enums.EResources.blue.name(), Enums.EResources.green.name());
                break;
            case 6:
                converted = convertResourceIn(Enums.EResources.blue.name(), Enums.EResources.red.name());
                break;


            case 7:
                converted = convertResourceIn(Enums.EResources.red.name(), Enums.EResources.black.name());
                break;
            case 8:
                converted = convertResourceIn(Enums.EResources.red.name(), Enums.EResources.blue.name());
                break;
            case 9:
                converted = convertResourceIn(Enums.EResources.red.name(), Enums.EResources.green.name());
                break;

            case 10:
                converted = convertResourceIn(Enums.EResources.green.name(), Enums.EResources.red.name());
                break;
            case 11:
                converted = convertResourceIn(Enums.EResources.green.name(), Enums.EResources.black.name());
                break;
            case 12:
                converted = convertResourceIn(Enums.EResources.green.name(), Enums.EResources.blue.name());
                break;

            default:
                getGameData().addMsgLog("Opção Inválida");
        }

        if (!converted)
            getGameData().addMsgLog("Não conseguiu converter os recursos");
        else
            getGameData().addMsgLog("Recurso convertido com sucesso!");

        return new AwaitConvertResource(getGameData());
    }


    private boolean convertResourceIn (String res1, String res2) {

        Nave nave = getGameData().getNave();
        try {

            Resources resource = nave.getCarga().getResource(res1);
            Resources resource2 = nave.getCarga().getResource(res2);

            if (resource != null && resource.getResourceVal() > 0 && resource2.getResourceVal() < nave.getCarga().getMaxCargo()) {
                nave.getCarga().removeResources(resource.getCor(), 1);
                nave.getCarga().addResource(res2, 1);
                return true;
            } else
                return false;

        } catch (
                Exception e) {
            //System.out.println(e.getMessage());
            return false;
        }

    }

}
