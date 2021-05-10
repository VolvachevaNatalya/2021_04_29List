package de.telran;

import java.util.Arrays;

public class MainCars {
    public static void main(String[] args) {
        Auto a1 = new Auto("Audi", "black", 120);
        Auto a2 = new Auto("BMW", "white", 80);
        Auto a3 = new Auto("Toyota", "blue", 210);
        Auto a4 = new Auto("Opel", "black", 60);
        Auto a5 = new Auto("Honda", "grey", 100);

        Auto[] autos = {a1,a2,a3,a4,a5};
        printAr(autos);
        System.out.println();
        Arrays.sort(autos, new ComparatorByPrice());
        printAr(autos);

    }

    private static void printAr(Auto[] autos) {
        for (Auto a : autos) {
            System.out.println(a);
        }
    }
}
