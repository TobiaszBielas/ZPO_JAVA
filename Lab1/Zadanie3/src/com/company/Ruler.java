package com.company;

public class Ruler {
    public static void printRuler(int length, int depth) {
        for (int i = 0; i < length; ++i) {
            printLine(length*depth, length*depth, i);
            printLevel(length*depth - 2, length*depth);
        }
        printLine(length*depth, length*depth, length);
    }

    private static void printLevel(int length, int maxLength) {
        if(length > 0) {
            printLevel(length - 2, maxLength);
            printLine(length, maxLength, 0);
            printLevel(length - 2, maxLength);
        }
    }

    private static void printLine(int length, int maxLength, int number) {
        for(int i = 0; i < maxLength/2-length/2; ++i) {
            System.out.print(" ");
        }
        for(int i = 0; i < length; ++i) {
            System.out.print("-");
        }
        if(length == maxLength) {
            System.out.print(" " + number);
        }
        System.out.println();
    }
}
