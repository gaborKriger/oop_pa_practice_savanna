package Savanna;

import Animal.Animal;

public class Field extends Savanna {

    private boolean empty;
    private Animal animal;
    private double grass;
    private int xCoordinate;
    private int yCoordinate;

    public Field(boolean empty, int grass, int xCoordinate, int yCoordinate) {
        this.empty = empty;
        this.grass = grass;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void changeGrass(double amount) {
        this.grass += amount;
    }

    public double getGrass() {
        return grass;
    }
}
