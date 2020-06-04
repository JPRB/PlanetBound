package PlanetBound.UI.Resources;

public enum ImgConstants {
    CURSOR("cursor.png"),
    ALIEN_RED("AlienRed.png"),
    ALIEN_BLACK("AlienBlack.png"),
    ALIEN_GREEN("AlienGreen.png"),
    ALIEN_BLUE("AlienBlue.png"),
    SPACE("space.png"),
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
    CARGO("cargo.jpg");

    private String name;

    ImgConstants (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }
}
