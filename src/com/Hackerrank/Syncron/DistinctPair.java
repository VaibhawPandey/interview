package com.Hackerrank.Syncron;

import com.competitiveCodes.misc.AddingTwoSetOfIntervals;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistinctPair {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        List<Integer> arr=new ArrayList<>();
        for (int i = 0; i < t; i++)
            arr.add(scanner.nextInt());
        long k=scanner.nextInt();

        System.out.println(countPairs(arr,k));

    }
    public static int countPairs(List<Integer> arr, long k) {
        // Write your code here
        int n=arr.size();
        List<Pair<Integer,Integer>> pairList=new ArrayList<>();
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((arr.get(i)+arr.get(j)) == k){
                    Pair<Integer,Integer> pair=new Pair<>(arr.get(i),arr.get(j));
                    Pair<Integer,Integer> reversePair=new Pair<>(arr.get(j),arr.get(i));
                    if(!pairList.contains(pair) && !pairList.contains(reversePair)){
                        pairList.add(pair);
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
