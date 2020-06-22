package PlanetBound.GameLogic.Utils;

public class Enums {

    public enum ShipType {
        Militar(1),
        Explorer(2);

        private final int value;

        ShipType(int val){
            this.value = val;
        }

        public int getValue () {
            return value;
        }
    }

    public enum PlanetType {
        BLACK_PLANET,
        RED_PLANET,
        GREEN_PLANET,
        BLUE_PLANET
    }

    public enum AlienType {
        BLACK_ALIEN,
        RED_ALIEN,
        GREEN_ALIEN,
        BLUE_ALIEN
    }


    public enum EResources {
        black("black"),
        red("red"),
        green("green"),
        blue("blue"),
        artifact("artifact");

        private String description;

        EResources(String desc){
            this.description = desc;
        }

        public String getDesc () {
            return description;
        }
    }

    public enum PlanetSectorType {
        RedSector,
        WhiteSector
    }

    public enum Events {
        CrewDeath(1, "Um membro da tripulação morreu.\n"),
        SalvageShip(2, "Encontraste uma nave abandonada com recursos.\n"), // recolher recursos de 1 tipo
        CargoLoss(3, "Ocorreu um problema no porão. Perdeste alguns recursos.\n"), // d3 [1-3] to see how much of that resource you lose
        FuelLoss(4, "Usaste demasiado combustivel.\n"),
        NoEvent(5, "Não aconteceu nenhum evento.\n"),
        CrewRescue(6, "Encontraste um membro numa nave abandonada.\n");

        private final int value;
        private final String description;

        Events(int val, String desc){
            this.value = val;
            this.description = desc;
        }

        public int getValue () {
            return value;
        }

        public String getDescription () {
            return description;
        }
    }

    public enum Station {
        buyDrone(1, "Comprar Novo Drone"),
        hireNewCrew(2, "Contratar Novo Membro"),
        upgradeWeapons(3, "Upgrate Armas"),
        upgradeCargoHold(4, "Upgrate Carga"),
        convertResources(5, "Coverter Recursos");

        private final int value;
        private final String description;

        Station(int val, String desc){
            this.value = val;
            this.description = desc;
        }

        public int getValue () {
            return value;
        }

        public String getDescription () {
            return description;
        }
    }
}
