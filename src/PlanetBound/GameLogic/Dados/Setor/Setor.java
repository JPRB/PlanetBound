package PlanetBound.GameLogic.Dados.Setor;

import PlanetBound.GameLogic.Dados.Setor.Planetas.FactoryPlanet;
import PlanetBound.GameLogic.Dados.Setor.Planetas.Planet;
import PlanetBound.GameLogic.Util.Enums;
import PlanetBound.GameLogic.Util.Util;

public class Setor {

    private String SectorType;
    private Planet planeta;
    private SpaceStation spaceStation;


    public Setor (){
        setPlanetSector();
        setPlaneta();
        setSpaceStation();
    }


    public String getPlanetSector () {
        return SectorType;
    }

    private void setPlanetSector () {
        this.SectorType = Util.PlanetSector();
    }

    public SpaceStation getSpaceStation () {
        return spaceStation;
    }

    public void setSpaceStation () {
        if (SectorType.equals(Enums.PlanetSectorType.RedSector.name()))
            this.spaceStation = new SpaceStation();
    }


     /*
    ################## Begin ##################
    ############# Planeta Methods #############
    ###########################################
    */

    public void setPlaneta () {
        this.planeta = FactoryPlanet.criaPlaneta();
    }

    public Planet getPlaneta () {
        return planeta;
    }

}
