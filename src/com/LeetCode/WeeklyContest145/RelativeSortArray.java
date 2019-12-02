package com.LeetCode.WeeklyContest145;

import java.util.*;

public class RelativeSortArray {

    public static void main(String[] args) {

        int arr1[] = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2[] = {2,1,4,3,9,6};
        int arr3[]=relativeSortArray(arr1,arr2);

        for (int i = 0; i < arr3.length; i++)
            System.out.print(arr3[i] +" ");

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer,Integer> countMap=new HashMap<>();
        List<Integer> temp=new ArrayList<>();
        int output[]=new int[arr1.length];

        for (int i = 0; i < arr1.length; i++){
            temp.add(arr1[i]);
            if(countMap.containsKey(arr1[i]))
                countMap.put(arr1[i],countMap.get(arr1[i])+1);
            else
                countMap.put(arr1[i],1);
        }
        int count=0;

        for (int i = 0; i < arr2.length; i++) {
            if(countMap.containsKey(arr2[i])){
                for (int j = 0; j < countMap.get(arr2[i]); j++) {
                    output[count]=arr2[i];
                    count++;
                }
                temp.removeAll(Collections.singleton(arr2[i]));
            }
        }

        Collections.sort(temp);

        for (int i = 0; i < temp.size(); i++) {
            output[count]=temp.get(i);
            count++;
        }

        return output;
    }
}
