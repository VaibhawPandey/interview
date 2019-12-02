package com.MyCode.array.ArrayRearrangement;

import java.util.*;
import java.util.stream.Collectors;

public class SortElementsByFreq {

    static HashMap<Integer,Integer> hashHashMap;
    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};

        hashHashMap=new HashMap<>();
        createBST(arr);


    }

    private static void createBST(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if(hashHashMap.containsKey(arr[i]))
                hashHashMap.put(arr[i], hashHashMap.get(arr[i]) + 1);
            else
                hashHashMap.put(arr[i],1);
        }

        hashHashMap = hashHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2) ->e1,LinkedHashMap::new));

        for (Map.Entry<Integer,Integer> mapElement:hashHashMap.entrySet()){
            for (int i = 0; i < mapElement.getValue(); i++) {
                System.out.print(mapElement.getKey() +" ");
            }
        }



    }
}
