import Animal.Herbivorous;
import Animal.Predator;
import Savanna.Savanna;

class App {

    public static void main(String[] args) {

        int sizeOfSavanna = 40;
        int years = 2;

        Savanna savanna = new Savanna();
        savanna.addField(sizeOfSavanna, sizeOfSavanna);

        for (int i = 0; i < 20; i++) {
            savanna.addAnimal(new Predator());
            savanna.addAnimal(new Herbivorous());
        }

        for (int i = 0; i < years * 365; i++) {
            savanna.life();
        }

    }
}