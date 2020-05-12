package PlanetBound.GameLogic.Util;

import PlanetBound.GameLogic.Dados.Resources.Resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;




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
