package com.competitiveCodes.spoj.Greedy;

import javafx.util.Pair;

import java.util.*;

public class Busyman {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        Pair<Integer,Integer> timingMap;

        for (int i = 0; i < t; i++) {

            int n=sc.nextInt();
            //for (int j = 0; j < n; j++)
                //timingMap.put(sc.nextInt(),sc.nextInt());
        }


    }

    class BMComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}
