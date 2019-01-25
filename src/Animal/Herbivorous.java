package Animal;

import static Util.MyRandom.randomNumberBeetwen;

public class Herbivorous extends Animal {

    private static int nameID;

    public Herbivorous() {
        super.name = "Herbivorous " + nameID++;
        super.age = 0;
        super.maxAge = randomNumberBeetwen(10,20);
        super.starving = false;
        super.sex = randomNumberBeetwen(1,2);
        super.mature = false;
    }

}
