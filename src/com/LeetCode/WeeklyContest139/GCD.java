package com.LeetCode.WeeklyContest139;

import java.util.Scanner;

public class GCD {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.next();
        String str2=scanner.next();

        System.out.println(gcdOfStrings(str1,str2));

    }

    public static String gcdOfStrings(String str1, String str2) {

        int n=str1.length();
        int m=str2.length();

        int val[][]=new int[n+1][m+1];
        //int colRow=0;
        int result=0;
        int end=-1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 || j==0)
                    val[i][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    val[i][j] = val[i-1][j-1] + 1;
                    if(val[i][j]>result){
                        result=val[i][j];
                        end = i-1;
                    }
                }else
                    val[i][j] = 0;
            }
        }

        if(result==0)
            return "";
        else
            return str1.substring(end-result+1,end+1);
    }
}
