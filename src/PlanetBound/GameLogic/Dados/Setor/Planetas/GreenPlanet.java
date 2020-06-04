package PlanetBound.GameLogic.Dados.Setor.Planetas;

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
    public List<PlanetBound.GameLogic.Dados.Resources.Resources> addPlanetResources () {
        List <PlanetBound.GameLogic.Dados.Resources.Resources> res = new ArrayList<>();

        res.add(new PlanetBound.GameLogic.Dados.Resources.Resources(Enums.EResources.red.name()));
        res.add(new PlanetBound.GameLogic.Dados.Resources.Resources(Enums.EResources.green.name()));

        return res;
    }

}
