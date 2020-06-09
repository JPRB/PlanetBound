package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Utils.Enums;

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
    public List<PlanetBound.GameLogic.Dados.Resources.Resources> addPlanetResources () {
        List <PlanetBound.GameLogic.Dados.Resources.Resources> res;

        // create null or instanceof
        res = Stream.of(Enums.EResources.values())
                .map(val -> new PlanetBound.GameLogic.Dados.Resources.Resources(val.toString()))
                .collect(Collectors.toList());

        return res;
    }

    @Override
    public Enums.PlanetType getPlanetType () {
        return Enums.PlanetType.BLUEPLANET;
    }
}
