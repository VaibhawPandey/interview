package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class ExchangeCoins {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int dp[]=new int[n+1];
        dp[0]=0;
        for (int i = 1; i <=n; i++)
            dp[i]=Math.max(i,dp[i/2]+dp[i/3]+dp[i/4]);


        System.out.println(dp[n]);
    }
}
