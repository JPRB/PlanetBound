package PlanetBound.GameLogic.Dados;

import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Game;
import PlanetBound.GameLogic.Util.Dice;
import PlanetBound.GameLogic.Util.Enums;
import PlanetBound.GameLogic.Util.Util;
import com.sun.deploy.uitoolkit.impl.fx.Utils;

public final  class Events {

    private static GameData data;

    public static void setData (GameData d) {
        data = d;
    }

    public static int aplicaEvento(GameData data){
        setData(data);
        return getEvento(data, Dice.rollD6());
    }

    public static int getEvento(GameData data, int eventoVal) {
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
        data.addMsgLog(Enums.Events.CrewDeath.getDescription());
    }

    private static void SalvageShip () {
        try {
            int random = Dice.rollD6();
            Resources x = Resources.randomResource(random);

            data.getNave().getCarga().addResource(x);
            data.addMsgLog(Enums.Events.SalvageShip.getDescription());
            data.addMsgLog("Recolhes-te"+ random + (random > 1 ? "recursos" : "recurso") + x.getCor());

        }
        catch (NullPointerException e){
            System.out.print("NullPointerException Caught");
        }
    }

    private static void CargoLoss() {
        try {
            int random = Dice.rollD3();
            Resources x = Resources.randomResource(random);

            data.getNave().getCarga().removeResources(x);
            data.addMsgLog(Enums.Events.CargoLoss.getDescription());
            data.addMsgLog("Perdes-te "+ random + (random > 1 ? "recursos" : "recurso") + x.getCor());
        }
        catch (NullPointerException e){
            System.out.print("NullPointerException Caught");
        }
    }

    private static void FuelLoss() {
        try {
            data.getNave().wasteFuel(1);
            data.addMsgLog(Enums.Events.FuelLoss.getDescription());
        }
        catch (NullPointerException e){
            System.out.print("NullPointerException Caught");
        }
    }

    private static void NoEvent() {
        data.addMsgLog(Enums.Events.NoEvent.getDescription());
    }

    private static void CrewRescue() {
        // ver se é preciso Crew Member
        data.addMsgLog(Enums.Events.CrewRescue.getDescription());
        data.addMsgLog("Não foi adicionado à crew, porque já está completa");
    }





}
