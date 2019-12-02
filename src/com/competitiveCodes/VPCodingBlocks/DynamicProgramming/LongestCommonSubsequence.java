package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String args[]){

        String firstString="GXTXTAB",secondString="AGGTAB";
        System.out.println(getLongestSubsequence(firstString,secondString));
    }

    private static int getLongestSubsequence(String firstString, String secondString) {
        int firstStringLen=firstString.length(),secondStringLen=secondString.length();
        int dp[][]=new int[firstStringLen+1][secondStringLen+1];

        for (int i=0;i<firstStringLen;i++) dp[i][0] = 0;

        for (int j=0;j<secondStringLen;j++) dp[0][j] = 0;

        for (int i=1;i<=firstStringLen;i++){
            for (int j=1;j<=secondStringLen;j++){
                if(firstString.charAt(i-1) == secondString.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[firstStringLen][secondStringLen];
    }
}
