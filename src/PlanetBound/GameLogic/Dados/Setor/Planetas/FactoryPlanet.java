package PlanetBound.GameLogic.Dados.Setor.Planetas;


import PlanetBound.GameLogic.Util.Util;

public class FactoryPlanet {

    public static Planet criaPlaneta () {

        switch (Util.probability(4)){
            case 1: return new BlackPlanet();
            case 2: return new BluePlanet();
            case 3: return new RedPlanet();
            case 4: return new GreenPlanet();
            default: return null;
        }
    }
}
