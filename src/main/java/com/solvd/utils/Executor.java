package com.solvd.utils;

import java.util.*;

public class Executor {
    public static void main (String[] args) {
        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(13);
        myArrayList.add(100);
        myArrayList.add(50);
        myArrayList.add(100);
        myArrayList.add(2);


        Iterator iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Integer i : myArrayList) {
            System.out.println(i);
        }

        Set<Integer> mySet = new LinkedHashSet<>(myArrayList);
        System.out.println(mySet);

        Map<Integer, String> newMap = new TreeMap<>();
        newMap.put(1, "value1");
        newMap.put(50, "value50");
        newMap.put(2, "value2");
        newMap.put(3, "value3");

        System.out.println(newMap);

        for (Integer i : newMap.keySet()) {
            System.out.println(newMap.get(i));
        }
    }
}
