package PlanetBound.Util;

import java.util.Random;

public final class Util {

    public enum PlanetSectorType {
        RedSector,
        WhiteSector
    };

    public static String PlanetSector () {

        int val = probability(10);

        if (val <= 3){
            return PlanetSectorType.RedSector.toString();
        }
        else
            return PlanetSectorType.WhiteSector.toString();
    }

    public static int probability(int val) {
        Random random = new Random();

        return Math.abs(random.nextInt() % val) + 1;
    }

}
