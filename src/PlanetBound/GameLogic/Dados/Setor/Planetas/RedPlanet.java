package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Utils.Enums;

import java.util.ArrayList;
import java.util.List;

public class RedPlanet extends Planet  {


    public RedPlanet () {
        super();
    }




    /*@Override
    public String getPlanetType () {
        return Enums.PlanetResources.red.name();
    }
*/
    @Override
    public List<PlanetBound.GameLogic.Dados.Resources.Resources> addPlanetResources () {
        List <PlanetBound.GameLogic.Dados.Resources.Resources> res = new ArrayList<>();

        res.add(new PlanetBound.GameLogic.Dados.Resources.Resources(Enums.EResources.red.name()));
        res.add(new PlanetBound.GameLogic.Dados.Resources.Resources(Enums.EResources.blue.name()));

        return res;
    }

    @Override
    public Enums.PlanetType getPlanetType () {
        return Enums.PlanetType.REDPLANET;
    }

    /*public void setRecursos (List<Resources> recursos) {
        this.recursos.addAll(recursos);
    }*/
}
