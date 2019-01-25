package Savanna;

import Animal.Animal;

public class Field {

    private boolean empty;
    private Animal animal;
    private int grass;
    private int xCoordinate;
    private int yCoordinate;

    public Field(boolean empty, int grass, int xCoordinate, int yCoordinate) {
        this.empty = empty;
        this.grass = grass;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
