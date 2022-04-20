package com.edgarfrancisco.generics_and_functional_programming;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class basicMethods {
    //Some common methods that use functional interfaces
    //removeIf() ----- works with List and Set
    public static List<String> removeIfMethod(List<String> list) {
        Predicate<String> predicate = x -> x.charAt(0) != 'e';
        list.removeIf(predicate);
        return list;
    }

    //sort() ----- you can sort list objects
    public static List<String> sortMethod(List<String> list) {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        list.sort(comparator);
        return list;
    }

    //forEach() ------- this method takes a Consumer and does something with the caller
    public static void forEachMethod(List<String> list) {
        Consumer<String> consumer = x -> {
            String xConcat = x + x + x;
            System.out.println(xConcat);
        };

        list.forEach(consumer);
    }

    //forEach() and Map -------- you can use forEach() with maps but it works a little different
    public static void forEachMethodWithMap(Map<Integer, String> map) {
        // Using keySEt() and values() --- these return sets
        map.keySet().forEach(x -> System.out.println(x));
        map.values().forEach(x -> System.out.println(x));

        // or you can use a BiConsumer interface to pass in two parameters
        BiConsumer<Integer, String> biConsumer = (x, y) -> System.out.println(x + " " + y);
        map.forEach(biConsumer);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("car");
        list.add("time");
        list.add("house");
        list.add("edgar");
        list.add("Edgar2");

        forEachMethod(list);

        sortMethod(list);
        System.out.println(list);

        removeIfMethod(list);
        System.out.println(list);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        forEachMethodWithMap(map);
    }
}
