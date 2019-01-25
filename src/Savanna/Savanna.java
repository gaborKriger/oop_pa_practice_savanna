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
                savanna[i][j] = new Field(true, randomNumberBeetwen(0, 5), j, i);
            }
        }
    }

    public void addAnimal(Animal animal) {
        while (true) {
            int row = randomNumberBeetwen(0, (savanna.length - 1));
            int col = randomNumberBeetwen(0, (savanna[0].length - 1));
            if (savanna[row][col].isEmpty()) {
                savanna[row][col].setAnimal(animal);
                animal.setCoordinate(col, row);
                savanna[row][col].setEmpty(false);
                break;
            }
        }
    }

    public void life() {
        this.day++;
        System.out.println("\nDays: " + day + "\n");
        increaseStarving();
        growGrass();
        feedHerbivorous();
        increaseAge();
        multiply();

        printAnimals();

    }

    private void multiply() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                Field actualField = savanna[i][j];
                Animal actualAnimal = actualField.getAnimal();
                if (!(actualField).isEmpty() && actualAnimal.isMature()) {
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            boolean inSavanna = i + k >= 0 && i + k < savanna.length &&
                                    j + l >= 0 && j + l < savanna[i].length;
                            if (inSavanna) {
                                Field neighboreField = savanna[i + k][j + l];
                                Animal neighboreAnimal = neighboreField.getAnimal();
                                if (!neighboreField.isEmpty() &&
                                        actualAnimal.getSex() != neighboreAnimal.getSex()) {
                                    if (neighboreAnimal.isMature() &&
                                            actualAnimal instanceof Herbivorous &&
                                            neighboreAnimal instanceof Herbivorous) {

                                        Field newBornField = isEmptyFieldAround(actualField);
                                        if (newBornField != null) {
                                            newBornField.setAnimal(new Herbivorous());

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void increaseAge() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                if (!savanna[i][j].isEmpty()) {
                    savanna[i][j].getAnimal().setAge();
                }
            }
        }
    }

    private void feedHerbivorous() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                if (savanna[i][j].getAnimal() instanceof Herbivorous) {
                    if (savanna[i][j].getGrass() < 1) {
                        boolean stepIsPossible = false;
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {
                                if (i + k >= 0 && i + k < savanna.length &&
                                        j + l >= 0 && j + l < savanna[i].length) {
                                    if (savanna[i + k][j + l].isEmpty()) {
                                        stepIsPossible = true;
                                    }
                                }
                            }
                        }
                        if (stepIsPossible) {
                            moveOneField(i, j);
                        }
                    } else {
                        ((Herbivorous) savanna[i][j].getAnimal()).eat(savanna[i][j]);
                    }
                }
            }
        }
    }

    private void moveOneField(int i, int j) {
        while (true) {
            int rowToMove = randomNumberBeetwen(-1, 1);
            int colToMove = randomNumberBeetwen(-1, 1);
            if (i + rowToMove >= 0 && i + rowToMove < savanna.length &&
                    j + colToMove >= 0 && j + colToMove < savanna[i].length) {
                Field toField = savanna[i + rowToMove][j + colToMove];
                Field fromField = savanna[i][j];
                if (toField.isEmpty()) {
                    (fromField).setEmpty(true);
                    (fromField).getAnimal().setCoordinate(j + colToMove, i + rowToMove);
                    toField.setEmpty(false);
                    toField.setAnimal(fromField.getAnimal());
                    fromField.setAnimal(null);
                    if (toField.getGrass() >= 1) {
                        ((Herbivorous) toField.getAnimal()).eat(toField);
                    }
                    break;
                }
            }
        }
    }

    private void growGrass() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                savanna[i][j].changeGrass(0.5);
            }
        }
    }

    private void increaseStarving() {
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

    public Field isEmptyFieldAround(Field field) {
        int i = field.getyCoordinate();
        int j = field.getxCoordinate();
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                boolean inSavanna = i + k >= 0 && i + k < savanna.length &&
                        j + l >= 0 && j + l < savanna[j].length;
                if (inSavanna) {
                    Field checkedField = savanna[i + k][j + l];
                    if (checkedField.isEmpty()) {
                        return checkedField;
                    }
                }
            }
        }
        return null;
    }

    public void printAnimals() {
        for (int i = 0; i < savanna.length; i++) {
            for (int j = 0; j < savanna[i].length; j++) {
                Field actualField = savanna[i][j];
                if (!actualField.isEmpty()) {
                    System.out.print(i + " " + j + ": ");
                    System.out.print(actualField.getAnimal().getName());
                    System.out.println(" starving: " + actualField.getAnimal().getStarving());
                    System.out.println("grass: " + actualField.getGrass());
                }
            }
        }
    }
}
