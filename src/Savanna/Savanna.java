package Savanna;

import Animal.Animal;

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
        this.day += 1;
    }

    public void printPredator() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                if (!savanna[i][j].isEmpty()) {
                    System.out.print(i + " " + j + ": ");
                    System.out.println(savanna[i][j].getAnimal().getName());
                }
            }
        }
    }
}
