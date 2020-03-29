package com.LeetCode.WeeklyContest179;


import java.util.Arrays;
import java.util.Scanner;

public class OddRepStringGenerate {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(generateTheString(n));
    }
    public static String generateTheString(int n) {

        char rec[]=new char[n];
        Arrays.fill(rec,'a');
        if(n%2 == 0) rec[0]= 'b';
        return String.valueOf(rec);
    }
}
