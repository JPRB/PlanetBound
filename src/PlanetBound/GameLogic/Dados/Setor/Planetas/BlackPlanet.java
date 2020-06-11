package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Utils.Enums;

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
    public List<PlanetBound.GameLogic.Dados.Resources.Resources> addPlanetResources () {
        List <PlanetBound.GameLogic.Dados.Resources.Resources> res = new ArrayList<>();

        res.add(new PlanetBound.GameLogic.Dados.Resources.Resources(Enums.EResources.black.name()));
        res.add(new PlanetBound.GameLogic.Dados.Resources.Resources(Enums.EResources.blue.name()));

        return res;
    }

    @Override
    public Enums.PlanetType getPlanetType () {
        return Enums.PlanetType.BLACK_PLANET;
    }
}
