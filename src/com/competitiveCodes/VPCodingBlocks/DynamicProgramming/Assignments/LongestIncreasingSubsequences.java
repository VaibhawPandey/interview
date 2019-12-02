package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class LongestIncreasingSubsequences {

    static int dp[];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int arr[]=new int[n];
        dp=new int[n];

        for (int i = 0; i < n; i++)
            arr[i]=scanner.nextInt();

        for (int i = 0; i < n; i++)
            dp[i]=1;

        System.out.println(getLongestIncreasingSubsequence(arr));


    }

    private static int getLongestIncreasingSubsequence(int[] arr) {

        int best=-1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] <= arr[i]) {
                    int value = 1 + dp[j];
                    dp[i] = Math.max(value, dp[i]);
                }
            }
            best=Math.max(dp[i],best);
        }

        return best;
    }
}
