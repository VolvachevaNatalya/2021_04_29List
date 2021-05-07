package de.telran;

import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String... args) {
//        OurList<Integer> list = new OurArrayList();
        OurList<String> list = new OurArrayList();
//        list.add(22);
//        list.add(33);
//        list.add(44);
//        list.add(55);
//        list.add(66);
//        list.set(0,null);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
//        System.out.println(list.size());
//        System.out.println(list);
//
//        list.add(55555); // add
//        System.out.println(list.size()); // size
//        System.out.println("CONTAINS " + list.contains(22)); // contains
//        list.set(0,3333); // set
//        System.out.println(list);
//        System.out.println(list.get(3)); // get
//        System.out.println("REMOVE ");
//        list.remove(0);
//        System.out.println(list);
//        System.out.println(list.remove(list.get(0)));
//        System.out.println("CONTAINS " + list.contains(-1));
//        System.out.println(list);

//this is possible since the list is an object implementing Iterable
        for (String line : list) {
            System.out.println(line);
        }

        //another way to iterate over our list is

        Iterator<String> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            String currentElt = listIterator.next();
            System.out.println(currentElt);
        }


        // how to use comparators
        OurList<Integer> numbers = new OurArrayList<>();
        numbers.add(-16);
        numbers.add(-25);
        numbers.add(7);
        numbers.add(0);

        for(int num : numbers) {
            System.out.print(num + " ");
        }
        Comparator<Integer> intComparator = new IntegerNaturalComparator();
        numbers.sort(intComparator);
        System.out.println();
        // after the previous line we should see the numbers from our list in a sorted order while iterating
        for(int num : numbers) {
            System.out.print(num + " ");
        }


    }
}
