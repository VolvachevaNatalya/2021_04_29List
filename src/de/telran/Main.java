package de.telran;

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
        list.add("hello");
        list.add("world");
        list.add("tt");
        list.add("rr");
        list.add("ee");
        System.out.println(list.size());
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


        for (String line : list) {
            System.out.println(line);
        }



    }
}
