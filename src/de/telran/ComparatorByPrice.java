package de.telran;

import java.util.Comparator;

public class ComparatorByPrice implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
