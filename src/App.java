import Animal.Herbivorous;
import Animal.Predator;
import Savanna.Savanna;

class App {

    public static void main(String[] args) {

        Savanna savanna = new Savanna();
        savanna.addField(10,10);

        for (int i = 0; i < 10; i++) {
//            savanna.addAnimal(new Predator());
            savanna.addAnimal(new Herbivorous());
        }

        int years = 10;

        for (int i = 0; i < years * 365; i++) {
            savanna.life();
        }

    }
}