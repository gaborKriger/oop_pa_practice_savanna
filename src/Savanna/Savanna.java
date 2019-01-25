package Savanna;

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
                savanna[i][j] = new Field(true,1, row, column);
            }
        }
    }

    public void addPredator() {
        Predator predator = new Predator();
        while (true) {
            int row = randomNumberBeetwen(0,savanna.length);
            int col = randomNumberBeetwen(0,savanna[0].length);
            if (savanna[row][col].isEmpty()) {
                savanna[row][col].setAnimal(predator);
                break;
            }
        }

    }

    public void life() {
        this.day += 1;
    }

}
