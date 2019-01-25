package Savanna;

import Animal.Animal;
import Animal.Herbivorous;
import Animal.Predator;

import static Util.MyRandom.randomNumberBeetwen;

public class Savanna {

    private int day;
    private Field[][] savanna;

    public int getDay() {
        return day;
    }

    public void addField(int row, int column) {
        savanna = new Field[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                savanna[i][j] = new Field(true,1,column, row);
            }
        }
    }

    public void addAnimal(Animal animal) {
        while (true) {
            int row = randomNumberBeetwen(0,(savanna.length-1));
            int col = randomNumberBeetwen(0,(savanna[0].length-1));
            if (savanna[row][col].isEmpty()) {
                savanna[row][col].setAnimal(animal);
                animal.setCoordinate(col,row);
                savanna[row][col].setEmpty(false);
                break;
            }
        }
    }

    public void life() {
        this.day ++;
        System.out.println("\nDays: " + day + "\n");
        incraseStarving();
        growGrass();
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                if (savanna[i][j].getAnimal() instanceof Herbivorous) {
                    ((Herbivorous) savanna[i][j].getAnimal()).eat(savanna[i][j]);
                }
            }
        }
        printAnimals();

    }

    private void growGrass() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                savanna[i][j].changeGrass(0.5);
            }
        }
    }

    private void incraseStarving() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                if (!savanna[i][j].isEmpty()) {
                    Animal animal = savanna[i][j].getAnimal();
                    animal.increaseStarving();
                    // kill animal
                    if (animal.getStarving() == 10) {
                        animal.setAlive(false);
                        savanna[i][j].setAnimal(null);
                        savanna[i][j].setEmpty(true);
                    }
                }
            }
        }
    }

    public void printAnimals() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                if (!savanna[i][j].isEmpty()) {
                    System.out.print(i + " " + j + ": ");
                    System.out.print(savanna[i][j].getAnimal().getName());
                    System.out.println(" starving: " + savanna[i][j].getAnimal().getStarving());
                }
            }
        }
    }
}
