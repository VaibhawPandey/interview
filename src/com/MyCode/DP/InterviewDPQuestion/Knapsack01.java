package com.MyCode.DP.InterviewDPQuestion;

import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader();
        int n= fastReader.nextInt();

        int val[]=new int[n];
        int w[]=new int[n];

        for (int i = 0; i < n; i++)
            val[i] = fastReader.nextInt();

        for (int i = 0; i < n; i++)
            w[i] = fastReader.nextInt();

        int W=fastReader.nextInt();
        int dp[][] = new int[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int we = 0; we <= W; we++) {
                if(i == 0 || we == 0)
                    dp[i][we] = 0;
                else
                 if(w[i-1]<= we)
                    dp[i][we] = Math.max(val[i-1] + dp[i-1][we-w[i-1]],dp[i-1][we]);
                else
                    dp[i][we] = dp[i-1][we];
            }
        }

        System.out.println(dp[n][W]);

    }


}
