package Savanna;

import Animal.Herbivorous;
import Animal.Predator;
import Savanna.Field;

public class PrintSavanna {

    static void printTable(Field[][] table) {

        // print out the header of the game (column numbers)
        System.out.print("      ");
        for (int c = 0; c < table.length; c++) {
            if (c < 10) {
                System.out.print("0");
            }
            System.out.print(c + " ");
        }
        System.out.println("");

        // print out the separator below the column number
        System.out.print("      ");
        for (int c = 0; c < table.length; c++) {
            System.out.print("___");
        }
        System.out.println("");

        // print each row
        for (int i = 0; i < table.length; i++) {
            // print each row number
            if (i < 10) {
                System.out.print("0");
            }
            System.out.print(i + " ");

            // print separator next to row number
            System.out.print(" | ");

            // print the actual numbers
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].isEmpty()) {
                    if (table[i][j].getAnimal() instanceof Predator) {
                        System.out.print("\033[41m" + " # " + "\033[0m");
                    }
                    if (table[i][j].getAnimal() instanceof Herbivorous) {
                        System.out.print("\033[46m" + " # " + "\033[37m");
                    }
                } else {
                    System.out.print("\033[90m" + " # " + "\033[37m");
                }
            }
            System.out.print(" | \n");

        }
    }
}

