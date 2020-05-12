package PlanetBound.GameLogic.Util;

public class Enums {
    public enum PlanetResources {
        black,
        red,
        green,
        blue,
        artifact
    }

    public enum PlanetSectorType {
        RedSector,
        WhiteSector
    }

    public enum Events {
        CrewDeath(1, "Um membro da tripulação morreu."),
        SalvageShip(2, "Encontraste uma nave abandonada. Recolheste os recursos."), // recolher recursos de 1 tipo
        CargoLoss(3, "Ocorreu um problema no porão. Perdeste alguns recursos."), // d3 [1-3] to see how much of that resource you lose
        FuelLoss(4, "Usaste demasiado combustivel."),
        NoEvent(5, "Não aconteceu nenhum evento."),
        CrewRescue(6, "Encontraste um membro numa nave abandonada.");

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
}
