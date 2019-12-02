package com.Hackerrank.Agoda;

import java.text.CollationElementIterator;
import java.util.*;

public class SortTwoElements {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        int arr[]={5,23,23,66,5,23,7,0};
        for (int i = 0; i < arr.length; i++) 
            list.add(arr[i]);
        List<Integer> output=getFirstTwo(list);
        for (Integer out:output)
            System.out.println(out);
    }

    private static List<Integer> getFirstTwo(List<Integer> list) {
        List<Integer> output=new ArrayList<>();
        Map<Integer,Long> map=new HashMap<>();

        for (Integer input:list){
            if(map.containsKey(input))
                map.put(input,map.get(input)+1);
            else
                map.put(input, (long) 1);
        }


        int count=0;
        for (Integer input:list){
              if(map.get(input) == 1){
                  output.add(input);
                  count++;
              }
              if(count==2)
                  break;
        }

        return output;

    }
}
