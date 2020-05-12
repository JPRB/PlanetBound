package PlanetBound.GameLogic.Dados;

import PlanetBound.GameLogic.Dados.Nave.FactoryNave;
import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Dados.Setor.Setor;
import PlanetBound.GameLogic.Util.Util;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    // Nave
    private Nave nave;
    private Setor setor;

    private final List<String> msgLog;

    public GameData () {
        initializeData();

        msgLog = new ArrayList<>();
    }


    public void initializeData () {
        setSetor();
    }



    /*
    ################## Begin #################
    ############# MsgLog Methods #############
    ##########################################
    */

    public List<String> getMsgLog () {
        return msgLog;
    }


    public void addMsgLog (String msgLog) {
        this.msgLog.add(msgLog);
    }

    public void clearMsgLog () {
        this.msgLog.clear();
    }


    /*
     ################## Begin ##################
     ############### Nave Methods ##############
     ###########################################
     */

    public String getNaveToString () {
        return nave.toString();
    }

    public Nave getNave () {
        return nave;
    }


    public void chooseShip (int ship) {
        nave = FactoryNave.criaNave(ship);
    }


    public void setSetor () {
        this.setor = new Setor();
    }

    public void setSetor (Setor setor) {
        this.setor = setor;
    }

    public Setor getSetor () {
        return setor;
    }

    public void evento() {
        int nEvento = Events.aplicaEvento(this);

        /*if (No weapon officer || shield officer) {
            Events.getEvento(nEvento);
        }*/

    }


    public boolean wormHole () {

        return (Util.probability(8) == 1);
    }
}
