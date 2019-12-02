package com.LeetCode.WeeklyContest156;

import java.util.*;

public class UniqueNumofOccurence {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        System.out.println(uniqueOccurrences(arr));

    }

    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer,Integer> numberCount=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(numberCount.containsKey(arr[i]))
                numberCount.put(arr[i],numberCount.get(arr[i])+1);
            else
                numberCount.put(arr[i],1);

        }

        List<Integer> countList=new ArrayList<>();
        for (Integer key:numberCount.keySet()) {
            if(countList.contains(numberCount.get(key)))
                return false;
            countList.add(numberCount.get(key));
        }

        return true;
    }
}
