package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String args[]){

        Scanner scanner=new Scanner(System.in);
        int arrLength=scanner.nextInt();

        int arr[]=new int[arrLength];

        for (int i=0;i<arrLength;i++)
            arr[i]=scanner.nextInt();

        System.out.println(getLongestSubsequence(arr));
    }

    private static int getLongestSubsequence(int[] arr) {

        int dp[]=new int[arr.length];

        for (int i=0;i<arr.length;i++) dp[i] = 1;

        for (int i=0;i<arr.length;i++){
            int best=-1;
            for (int j=0;j<i;j++){
                if(arr[j] <= arr[i]){
                    int value=1+dp[j];
                    dp[i] = Math.max(value,dp[i]);
                }
            }
            best=Math.max(best,dp[i]);
        }
        return dp[arr.length -1];
    }
}
