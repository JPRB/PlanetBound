package PlanetBound.GameLogic.Estados;

public interface IEstados {

    // IEstados xpto();

    // Iniciar o Jogo
    IEstados start ();

    // Selecionar tipo de Nave
    IEstados selectShip (int value);



    IEstados moveToAnotherPlanet ();


    IEstados LandingPlanet ();

    IEstados finish ();


    IEstados Orbit ();

    IEstados collectResource ();

    IEstados moveToStationShip ();
}
