package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Enums;

import java.util.ArrayList;
import java.util.List;

public class GreenPlanet extends Planet{

    public GreenPlanet () {
        super();
    }

  /*  @Override
    public String getPlanetType () {
        return Enums.PlanetResources.green.name();
    }
*/

    @Override
    public List<Resources> addPlanetResources () {
        List <Resources> res = new ArrayList<>();

        res.add(new Resources(Enums.PlanetResources.red.name()));
        res.add(new Resources(Enums.PlanetResources.green.name()));

        return res;
    }

}
