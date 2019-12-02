package com.MyCode.DP.LeetCode.Easy;

import java.util.Scanner;

public class IsSubsequence {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s= scanner.next(),t=scanner.next();
        int j=0;
        for (int i = 0; i < t.length(); i++) {
            if(s.charAt(j) == t.charAt(i))
                j++;
        }

        if(j==s.length())
            return;
    }
}
