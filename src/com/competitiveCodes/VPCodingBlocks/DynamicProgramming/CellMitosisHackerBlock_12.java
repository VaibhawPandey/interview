package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

public class CellMitosisHackerBlock_12 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt(),x=scanner.nextInt(),y=scanner.nextInt(),z=scanner.nextInt();

        int dp[]=new int[n];

        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i < n; i++) {
            if(i%2 == 0)
               dp[i]=Math.min(dp[i/2]+x,dp[i-1]+y);
            else
               dp[i] = Math.min(dp[i-1]+y,dp[(i+1)/2]+x+z);
        }



        System.out.println(dp[n-1]);

    }
}
