package com.MyCode.array.ArrayRotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxContinuous1 {

    public static void main(String[] args) {
        String s = "10011110011";
        int k = 1;

        System.out.println(maxContinuosOnes(s,k));
    }

    private static int maxContinuosOnes(String s, int k) {

        int i,j,count;
        List<Integer> countList=new ArrayList<>();


        for (i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                count = 0;
                j = i;
                while ( j<s.length() && s.charAt(j) == '1'){
                    count++;
                    j++;
                }
                countList.add(count);
                i=j-1;
            }
        }

        if(countList.size() == 0)
            return 0;

        Collections.sort(countList);

        for (int l = 0; l < k; l++) {
            int a=countList.get(countList.size()-1);
            int b=countList.get(countList.size()-2);

            countList.remove(countList.size()-1);
            countList.remove(countList.size()-2);

            countList.add(a+b);
        }

        return countList.get(countList.size()-1);


    }
}
