package PlanetBound.GameLogic.Estados;

public interface IEstados {

    // IEstados xpto();

    IEstados start ();

    IEstados selectShip (int value);

    IEstados finish ();

    IEstados enterOrbit ();
}
