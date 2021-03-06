package Animal;

import Savanna.Field;

import static Util.MyRandom.randomNumberBeetwen;

public class Predator extends Animal {

    private static int nameID;

    public Predator() {
        super.name = "Predator " + nameID++;
        super.age = 0;
        super.maxAge = randomNumberBeetwen(10, 20);
        super.starving = 0;
        super.sex = randomNumberBeetwen(1, 2);
        super.mature = false;
        super.alive = true;
    }

    public void feedPredator(int number){
            this.starving -= number;
    }
}
