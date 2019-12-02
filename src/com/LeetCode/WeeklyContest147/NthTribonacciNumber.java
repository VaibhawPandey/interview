package com.LeetCode.WeeklyContest147;

import java.util.Scanner;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {

        int T[]=new int[n+1];

        if(n==0)
            T[0]=0;
        else if(n == 1){
            T[0]=0;
            T[1]=1;
        }
        else{
            T[0]=0;
            T[1]=1;
            T[2]=1;
        }

        for (int i = 0; i <= n-3; i++)
            T[i+3] = T[i]+T[i+1]+T[i+2];

        return T[n];
    }
}
