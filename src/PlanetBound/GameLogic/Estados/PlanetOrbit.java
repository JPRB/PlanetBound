package PlanetBound.GameLogic.Estados;

import PlanetBound.GameLogic.Dados.GameData;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Util.Util;

public class PlanetOrbit extends EstadosAdapter {


    public PlanetOrbit (GameData gameData) {
        super(gameData);
    }


    @Override
    public IEstados moveToAnotherPlanet () {

        Nave nave = this.getGameData().getNave();

        if (nave.getCombustivel() <= 1)
            return new GameOver(getGameData());

        getGameData().addMsgLog("Durante a Viagem...");
        getGameData().addMsgLog("*******************");

        // Evento
        this.getGameData().evento();

        // Testar se passou num buraco negro
        if (this.getGameData().wormHole()) {
            this.getGameData().addMsgLog("Realizou a viagem por Worm hole");

            final int shield = nave.getShields();
            final int fuel = nave.getCombustivel();

            if (shield > 1) {
                //if (Tem Shield officer) {
                // Custa 3 de fuel 2 de shield
                nave.setCombustivel(fuel - 3);
                nave.setShields(shield - 2);
                 /*}
                 else {
                       // Não Tem Shield officer??
                     // Custa 3+1 de fuel 2+2 de shield
                     nave.setCombustivel(fuel - 4);
                     nave.setShields(shield - 4);
                 }*/
            } /*else {
                // perdeu oficial

            }*/
        }


        // Novo Sector/planeta
        try {
            this.getGameData().setSetor();
            this.getGameData().addMsgLog("Novo planeta encontrado!");
        }catch (Exception e){
            Util.pError(e.getMessage());
        }

        return this;
    }

    @Override
    public IEstados Orbit () {

        //getGameData().setPlaneta();

        return this;
    }
}
