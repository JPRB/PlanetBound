package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Resources.Resources;

import java.util.ArrayList;
import java.util.List;


public abstract class Planet {

    private List<Resources> recursos = new ArrayList<>();

    private int[][] land = new int[6][6];

    public Planet () {
        initialize();
    }




    private void initialize () {
        setRecursos(addPlanetResources());
    }


    /*public abstract String  getPlanetType ();*/



    public List<Resources> getRecursos () {
        return recursos;
    }

    public void setRecursos (List<Resources> recursos) {
        this.recursos = recursos;
    }

    public abstract List<Resources> addPlanetResources ();

}
