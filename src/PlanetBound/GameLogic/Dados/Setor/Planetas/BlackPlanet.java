package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Util.Enums;

import java.util.ArrayList;
import java.util.List;

public class BlackPlanet extends Planet {

    public BlackPlanet () {
        super();
    }




 /*   @Override
    public String getPlanetType () {
        return Enums.PlanetResources.black.name();
    }
*/

    @Override
    public List<Resources> addPlanetResources () {
        List <Resources> res = new ArrayList<>();

        res.add(new Resources(Enums.PlanetResources.black.name()));
        res.add(new Resources(Enums.PlanetResources.blue.name()));

        return res;
    }
}
