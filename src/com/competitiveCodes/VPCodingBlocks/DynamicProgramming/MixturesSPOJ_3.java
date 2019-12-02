package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

public class MixturesSPOJ_3 {

    static long dp[][];
    static int arr[];

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        dp= new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1L;
            }

        }


        System.out.println(solveMixtures(0,n-1));

    }

    private static long solveMixtures(int st, int en) {

        if(st>=en)
            return 0;

        if(dp[st][en] != -1)
            return dp[st][en];

        dp[st][en] = Long.MAX_VALUE;

        for (int k=st;k<=en;k++){
            dp[st][en] = Math.min(dp[st][en],solveMixtures(st,k) + solveMixtures(k+1,en) + (sum(st,k)*sum(k+1,en)));
        }

        return dp[st][en];
    }

     static long sum(int st,int en){

         int sum=0;
         for (int i = st; i <= en; i++) {
             sum += arr[i];
             sum %= 100;
         }

         return sum;
    }
}
