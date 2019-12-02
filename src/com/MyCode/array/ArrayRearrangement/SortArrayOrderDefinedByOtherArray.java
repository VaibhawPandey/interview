package com.MyCode.array.ArrayRearrangement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Ref :- https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
 */
public class SortArrayOrderDefinedByOtherArray {

    public static void main(String[] args) {
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int m = A1.length;
        int n = A2.length;

        for (int i = 0; i < m; i++) {
            if (hashMap.containsKey(A1[i]))
                hashMap.put(A1[i], hashMap.get(A1[i]) + 1);
            else
                hashMap.put(A1[i], 1);
        }

//        boolean visited[] = new boolean[hashMap.size()];
//        Arrays.fill(visited, false);
        int temp[] = new int[m];

        int j=0;

        for (int i = 0; i < n; i++) {
           if(hashMap.containsKey(A2[i])){
               for (int k = 0; k < hashMap.get(A2[i]); k++) {
                   temp[j]=A2[i];
                   j++;
               }
               hashMap.put(A2[i],-1);
           }
        }

        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if(entry.getValue() != -1){
                temp[j] = entry.getKey(); j++;
            }}

        for (int i = 0; i < temp.length; i++)
            System.out.print(temp[i] +" ");

    }
}
