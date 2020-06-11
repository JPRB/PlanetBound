package PlanetBound.UI.Resources;

public enum ImgConstants {
    CURSOR("cursor.png"),
    RED_ALIEN("AlienRed.png"),
    BLACK_ALIEN("AlienBlack.png"),
    GREEN_ALIEN("AlienGreen.png"),
    BLUE_ALIEN("AlienBlue.png"),
    SPACE("space.jpg"),
    SPACESHIP_EXPLORER("spaceship-explorer.png"),
    SPACESHIP_MILITAR("spaceship-militar.png"),
    RED_CUBE("redCube.png"),
    BLACK_CUBE("blackCube.png"),
    BLUE_CUBE("blueCube.png"),
    GREEN_CUBE("greenCube.png"),
    FUEL("fuel.jpg"),
    OFFICER("officer.png"),
    WEAPON("weapon.jpg"),
    SHIELD("shield.png"),
    CARGO_HOLD("CargoHold.png"),
    DRONE("drone.png"),
    CARGO("cargo.jpg"),
    SPACE_STATION("spaceStation.png"),
    RED_PLANET("redPlanet.png"),
    BLUE_PLANET("bluePlanet.png"),
    BLACK_PLANET("blackPlanet.png"),
    GREEN_PLANET("greenPlanet.png")

    ;

    private String name;

    ImgConstants (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }
}
