package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Resources.Resources;
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
    public List<Resources> addPlanetResources () {
        List <Resources> res = new ArrayList<>();

        res.add(new Resources(Enums.PlanetResources.red.name()));
        res.add(new Resources(Enums.PlanetResources.blue.name()));

        return res;
    }

    /*public void setRecursos (List<Resources> recursos) {
        this.recursos.addAll(recursos);
    }*/
}
