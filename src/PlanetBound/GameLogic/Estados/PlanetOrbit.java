package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.Events.Event;
import PlanetBound.GameLogic.Dados.Factories.FactoryEvent;
import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlanetOrbit extends EstadosAdapter {


    public PlanetOrbit (GameData gameData) {
        super(gameData);
    }


    // MOVE TO NEW PLANET
    @Override
    public IEstados moveToPlanet () {

        Nave nave = this.getGameData().getNave();
        Event evento;

        nave.wasteFuel(1);

        if (nave.getCombustivel() <= 1 || nave.getOfficers() < 1) {
            this.getGameData().addMsgLog("### GAME OVER ###");
            return new GameOver(getGameData());
        }

        getGameData().addMsgLog("Durante a Viagem...");



        // Testar se passou num buraco negro
        if (this.getGameData().wormHole()) {
            this.getGameData().addMsgLog("Realizou a viagem por Worm hole");

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
        evento = FactoryEvent.criaEvento(getGameData());
        if (evento != null) {
            evento.aplicaEvento();
        }else
            getGameData().addMsgLog("Ocorreu um erro no evento");



        getGameData().addMsgLog("Fim da Viagem...");


        // Novo Sector/planeta
        try {
            this.getGameData().setSetor();
            this.getGameData().addMsgLog("Novo planeta encontrado!");
        } catch (Exception e) {
            Util.pError(e.getMessage());
        }

        return this;
    }

    @Override
    public IEstados moveToSpaceStation () {


        List<Resources> resources = Stream.of(Enums.PlanetResources.values())
                .map(res -> getGameData().getNave().getCarga().getResource(res.name())).filter(res -> !res.getCor().equals(Enums.PlanetResources.artifact.name())).collect(Collectors.toList());

        //final long count = resources.stream().filter(r -> !r.getCor().equals(Enums.PlanetResources.artifact.name())).filter(r -> r.getResourceVal() >= 2).count();

        final long count = resources.stream().filter(r -> r.getResourceVal() >= 2).count();

        if (count == 4) {
            // Custo da orbita
            this.getGameData().getNave().wasteFuel(1);

            if (this.getGameData().getNave().getCombustivel() < 1)
                return new GameOver(getGameData());

            return new AwaitStationDecisions(getGameData());
        }

        getGameData().addMsgLog("Não é possível ir para estação espacial. Não tens recursos suficientes");
        return this;
    }


    @Override
    public IEstados explore () {

        Nave nave = getGameData().getNave();

        if (nave.getOfficers() < 3) {
            getGameData().addMsgLog("Não é possivel explorar, não tem Officer.");
            getGameData().addMsgLog("Vá até até uma estação espacial e contrate um novo.");
            return this;
        }

        // Se tiver drone
        if (nave.getDrone().getEstado() == 0){
            getGameData().addMsgLog("Não tem Drone, não pode explorar. Vá até uma estação comprar um novo.");
            return this;
        }

        // Se houver recursos
        if (getGameData().getSetor().getPlaneta().getRecursos().size() == 0) {
            getGameData().addMsgLog("Este planeta já não tem mais recursos.");
            return this;
        }

        nave.wasteFuel(1);

        getGameData().getSetor().getPlaneta().setSuperficie(nave.getDrone());

        System.out.println(String.format("Recurso (X, Y): (%d, %d)", getGameData().getSetor().getPlaneta().getSuperficie().getResourcePos()[0], getGameData().getSetor().getPlaneta().getSuperficie().getResourcePos()[1]));
        System.out.println(String.format("Drone (X, Y): (%d, %d)", getGameData().getSetor().getPlaneta().getSuperficie().getDronePos()[0], getGameData().getSetor().getPlaneta().getSuperficie().getDronePos()[1]));

        return new AwaitToExplorerResources(getGameData());
    }
}
