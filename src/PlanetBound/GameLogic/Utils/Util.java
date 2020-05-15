package PlanetBound.GameLogic.Utils;

import java.util.Random;


public final class Util {

    public static String PlanetSector () {

        int val = probability(10);

        if (val <= 3){
            return Enums.PlanetSectorType.RedSector.name();
        }
        else
            return Enums.PlanetSectorType.WhiteSector.name();
    }

    public static int probability(int val) {
        Random random = new Random();

        return Math.abs(random.nextInt() % val) + 1;
    }

    public static void pError(String error) {
        System.out.println("Ocorreu um erro" + error);
    }
}
