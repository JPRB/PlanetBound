package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.Events.Event;
import PlanetBound.GameLogic.Dados.Factories.FactoryEvent;
import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Utils.Util;

public class AwaitEvent extends EstadosAdapter {

    public AwaitEvent (GameData data) {
        super(data);
    }


    public IEstados aplicaEvento (int value) {

        Nave nave = this.getGameData().getNave();


        getGameData().addMsgLog("Durante a Viagem...\n\n");

        // Testar se passou num buraco negro
        if (this.getGameData().wormHole()) {
            this.getGameData().addMsgLog("Realizou a viagem por Worm hole\n\n");

            final int shield = nave.getShields();
            final int fuel = nave.getCombustivel();

            if (shield > 1) {
                if (nave.getOfficers() == 6) {
                    // Custa 3 de fuel 2 de shield
                    nave.setCombustivel(fuel - 3);
                    nave.setShields(shield - 2);
                } else {
                    // Não Tem Shield officer
                    // Custa 3+1 de fuel 2+2 de shield
                    nave.setCombustivel(fuel - 4);
                    nave.setShields(shield - 4);
                }
            } else {
                nave.crewMemberDie();
            }
        }

        // Evento
        Event evento;

        if (value == 7 || value == -1)
            evento = FactoryEvent.criaEvento(getGameData());
        else
            evento = FactoryEvent.criaEvento(getGameData(), value);

        if (evento != null)
            evento.aplicaEvento();
        else
            getGameData().addMsgLog("Ocorreu um erro no evento\n");


        getGameData().addMsgLog("\nFim da Viagem...\n");


        // Novo Sector/planeta
        try {
            this.getGameData().setSetor();
            this.getGameData().addMsgLog("\n\n---->Novo planeta encontrado!<----\n");
        } catch (Exception e) {
            Util.pError(e.getMessage());
        }

        return new PlanetOrbit(getGameData());
    }

    @Override
    public EstadoID getEstadoID () {
        return EstadoID.DO_EVENT;
    }

}
