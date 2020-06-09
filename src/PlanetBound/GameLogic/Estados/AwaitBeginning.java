package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;

public class AwaitBeginning extends EstadosAdapter {

    public AwaitBeginning (GameData data) {
        super(data);
    }

    @Override
    public IEstados start() {

        // Escolher a nave


        return new AwaitShipSelection(getGameData());
        // return new Próximo estado (this.getGamedata());
    }

    @Override
    public IEstados finish () {

        return super.finish();
    }

    @Override
    public EstadoID getEstadoID () {
        return EstadoID.AWAIT_BEGINNING;
    }
}
