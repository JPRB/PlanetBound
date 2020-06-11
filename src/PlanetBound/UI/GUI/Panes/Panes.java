package PlanetBound.UI.GUI.Panes;

public enum Panes {
    StartGamePane(0),
    ChooseNavePane(1),
    PlanetOrbitPane(2),
    SpaceStationPane(3),
    MoveDronePane(4);


    private int value;

    Panes(int val){
        this.value = val;
    }

    public int getValue () {
        return value;
    }
}
