package com.LeetCode.WeeklyContest181;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestPrefix {

    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPrefix(s));
    }
    public static String longestPrefix(String s) {

//        List<String> prefixList = new ArrayList<>();
//        List<String> suffixList = new ArrayList<>();

        if(s.length() == 1)
            return "";

        String output="";

        int n = s.length();
        for (int i = n-1; i >= 1; i--) {
            if( s.substring(0,i).equals(s.substring(n-i,n))) {
                output = s.substring(0, i);
                break;
            }
        }

            return output;

    }
}
