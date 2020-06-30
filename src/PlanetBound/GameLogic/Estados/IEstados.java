package PlanetBound.GameLogic.Estados;

public interface IEstados {

    // IEstados xpto();

    // Iniciar o Jogo
    IEstados start ();

    // Selecionar tipo de Nave
    IEstados selectShip (int value);


    // Mover para novo Planeta/Setor Ou para Planeta/Setor existente
    IEstados move ();

    IEstados moveToSpaceStation ();

    IEstados getItemsSpaceStations (int item);

    // Used when GameOver
    IEstados playAgain ();


    IEstados explore ();

    IEstados moveDrone(int value);

    IEstados convertResources (int value);

    IEstados convertResourceInOther(int value);

    IEstados aplicaEvento (int val);

    EstadoID getEstadoID();
}
