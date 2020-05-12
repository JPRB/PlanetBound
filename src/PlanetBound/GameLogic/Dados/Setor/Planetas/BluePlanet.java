package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Util.Enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BluePlanet extends Planet  {


    public BluePlanet () {
        super();
    }

   /* @Override
    public String getPlanetType () {
        return String.format(Enums.PlanetResources.blue.name(), "Planet");
    }
*/
    @Override
    public List<Resources> addPlanetResources () {
        List <Resources> res;

        // create null or instanceof
        res = Stream.of(Enums.PlanetResources.values())
                .map(val -> new Resources(val.toString()))
                .collect(Collectors.toList());

        return res;
    }
}
