package PlanetBound.UI.Resources;

public enum ImgConstants {
    CURSOR("cursor.png"),
    RED_ALIEN("AlienRed.png"),
    BLACK_ALIEN("AlienBlack.png"),
    GREEN_ALIEN("AlienGreen.png"),
    BLUE_ALIEN("AlienBlue.png"),
    SPACE("space.jpg"),
    SPACE1("space01.jpg"),
    SPACESHIP_EXPLORER("spaceship-explorer.png"),
    SPACESHIP_MILITAR("spaceship-militar.png"),
    RED_CUBE("redCube.png"),
    BLACK_CUBE("blackCube.png"),
    BLUE_CUBE("blueCube.png"),
    GREEN_CUBE("greenCube.png"),
    ARTIFACT("Artifact.png"),
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
    GREEN_PLANET("greenPlanet.png"),
    BLACK_CUBE_BLUE("blackCubeToBlue.png"),
    BLACK_CUBE_RED("blackCubeToGreen.png"),
    BLACK_CUBE_GREEN("blackCubeToRed.png"),
    BLUE_CUBE_RED("blueCubeToRed.png"),
    BLUE_CUBE_GREEN("blueCubeToGreen.png"),
    BLUE_CUBE_BLACK("blueCubeToBlack.png"),
    RED_CUBE_BLUE("redCubeToBlue.png"),
    RED_CUBE_BLACK("redCubeToBlack.png"),
    RED_CUBE_GREEN("redCubeToGreen.png"),
    GREEN_CUBE_BLUE("greenCubeToBlue.png"),
    GREEN_CUBE_RED("greenCubeToRed.png"),
    GREEN_CUBE_BLACK("greenCubeToBlack.png"),
    AURORA("aurora-borealis.jpg")
    ;

    private String name;

    ImgConstants (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }
}
