package PlanetBound.Util;

public class Dice {

    public int rollD3 () {
        return Util.probability(3);
    }

    public int rollD6 () {
        return Util.probability(6);
    }


    // @param value of dice (3 or 6)

}
