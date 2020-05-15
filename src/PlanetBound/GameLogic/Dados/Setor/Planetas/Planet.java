package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Nave.Drone;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Dice;

import java.util.ArrayList;
import java.util.List;

import static PlanetBound.GameLogic.Utils.Dice.rollD6;


public abstract class Planet {

    private List<Resources> recursos = new ArrayList<>();
    private PlanetSuperficie superficie;


    public Planet () {
        initialize();
    }


    public PlanetSuperficie getSuperficie () {
        return superficie;
    }

    public void setSuperficie (Drone drone) {
        this.superficie = new PlanetSuperficie(recursos.get(recursos.size()-1), drone);
    }

  /*  public Resources collectResource () throws Exception
    {
        if (superficie.getDronePos() == superficie.getResourcePos()){

            removeRecurso(superficie.getResource());

            return new Resources(superficie.getResource().getCor(), Dice.rollD6());
        }

        return null;
    }*/


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

    public boolean removeRecurso (Resources recurso) throws NullPointerException{
        Resources res = recursos.stream().filter(r -> r.getCor().equals(recurso.getCor())).findFirst().orElse(null);

        return recursos.remove(res);
    }

    public abstract List<Resources> addPlanetResources ();

}
