package PlanetBound.GameLogic.Dados;

import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.Util.Util;

import java.util.List;


public class Planet {

    private String planetSector;
    private List<Resources> recursos;


    public Planet (List<Resources> recursos) {
        setPlanetSector();
        this.recursos = recursos;
    }

    public void setRecursos (List<Resources> recursos) {
        this.recursos = recursos;
    }

    public void setPlanetSector () {
        this.planetSector = Util.PlanetSector();
    }

    public String getPlanetSector () {
        return planetSector;
    }





}
