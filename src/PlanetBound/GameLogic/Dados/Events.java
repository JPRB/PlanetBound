package PlanetBound.GameLogic.Dados;

import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Dice;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Util;

public final class Events {

    private static GameData data;

    public static void setData (GameData d) {
        data = d;
    }

    public static int aplicaEvento (GameData data) {
        setData(data);
        return aplicaEvento(data, Dice.rollD6());
    }

    public static int aplicaEvento (GameData data, int eventoVal) {
        setData(data);
        if (eventoVal == Enums.Events.CrewDeath.getValue()) {
            CrewDeath();
        } else if (eventoVal == Enums.Events.SalvageShip.getValue()) {
            SalvageShip();
        } else if (eventoVal == Enums.Events.CargoLoss.getValue()) {
            CargoLoss();
        } else if (eventoVal == Enums.Events.FuelLoss.getValue()) {
            FuelLoss();
        } else if (eventoVal == Enums.Events.NoEvent.getValue()) {
            NoEvent();
        } else {
            CrewRescue();
        }

        return eventoVal;
    }


    private static void CrewDeath () {

        data.getNave().crewMemberDie();

        data.addMsgLog(Enums.Events.CrewDeath.getDescription());
    }

    private static void SalvageShip () {
        try {
            int random = Dice.rollD6();
            Resources x = Resources.randomResource(random);

            final boolean added = data.getNave().getCarga().addResource(x);
            data.addMsgLog(Enums.Events.SalvageShip.getDescription());

            if (added)
                data.addMsgLog("Recolhes-te " + random + (random > 1 ? " recursos " : " recurso ") + x.getCor());
             else
                data.addMsgLog("Não foi possivel adicionar recursos");

        } catch (NullPointerException e) {
            Util.pError(e.getMessage());
        }
    }

    private static void CargoLoss () {
        try {
            int random = Dice.rollD3();
            Resources x = Resources.randomResource(random);

            final boolean added = data.getNave().getCarga().removeResources(x);

            data.addMsgLog(Enums.Events.CargoLoss.getDescription());

            if (added)
                data.addMsgLog("Perdes-te " + random + (random > 1 ? " recursos " : " recurso ") + x.getCor());
            else
                data.addMsgLog("Não foi possivel remover recursos");


        } catch (NullPointerException e) {
            Util.pError(e.getMessage());
        }
    }

    private static void FuelLoss () {
        try {
            data.getNave().wasteFuel(1);
            data.addMsgLog(Enums.Events.FuelLoss.getDescription());
        } catch (NullPointerException e) {
            Util.pError(e.getMessage());
        }
    }

    private static void NoEvent () {
        data.addMsgLog(Enums.Events.NoEvent.getDescription());
    }

    private static void CrewRescue () {

        Nave nave = data.getNave();
        data.addMsgLog(Enums.Events.CrewRescue.getDescription());

        // ver se é preciso Crew Member
        if (nave.getOfficers() < 6){

            nave.addCrewMember();

            data.addMsgLog("Foi adicionado um novo officer.");
        }
        else
            data.addMsgLog("Não foi adicionado à crew, porque já está completa");
    }


}
