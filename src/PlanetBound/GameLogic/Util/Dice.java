package PlanetBound.GameLogic.Util;

public final class Dice {

    public static int rollD3 () {
        return Util.probability(3);
    }

    public static int rollD6 () {
        return Util.probability(6);
    }


    // @param value of dice (3 or 6)

}
