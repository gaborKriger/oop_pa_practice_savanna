import Animal.Herbivorous;
import Animal.Predator;
import Savanna.Savanna;

class App {

    public static void main(String[] args) {

        int sizeOfSavanna = 10;
        int years = 100;

        Savanna savanna = new Savanna();
        savanna.addField(sizeOfSavanna, sizeOfSavanna);

        for (int i = 0; i < 10; i++) {
            savanna.addAnimal(new Predator());
            savanna.addAnimal(new Herbivorous());
        }

        for (int i = 0; i < years * 365; i++) {
            savanna.life();
        }

    }
}