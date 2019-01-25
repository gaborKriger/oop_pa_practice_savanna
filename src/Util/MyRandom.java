package Util;

import java.util.Random;

public class MyRandom {

    private static final Random RANDOM = new Random();

    public static boolean eventWithChance(int chance) {
        return RANDOM.nextInt(100) < chance;
    }

    public static int randomNumberBeetwen(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }

}
