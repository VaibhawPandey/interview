package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

/*
  *
  * Maximum 'k' items are allowed to reverse
  * Question:-https://www.hackerearth.com/problem/algorithm/mancunian-and-k-ordered-lcs-e6a4b8c6/
  *
 */
public class AdvancedDPLCS_1 {

    public static String firstString,secondString;
    public static void main(String args[]){

        Scanner scanner=new Scanner(System.in);
        firstString = scanner.next();
        secondString = scanner.next();
        int k=scanner.nextInt();
        int dp[][][]=new int[firstString.length()][secondString.length()][k];

        System.out.println(LCS(0,0,k,dp));
    }

    private static int LCS(int i, int j, int k, int[][][] dp) {

        int m=firstString.length(),n=secondString.length();
        if(i==m||j==n)
            return 0;

        int res=0;
        if(dp[i][j][k] != -1)
            return dp[i][j][k];

        if(firstString.charAt(i) == secondString.charAt(j)){
            res = 1+ LCS(i+1,j+1,k,dp);
        }else {
            //In case replacement is done so k becomes k-1
            if(k>0){
                res = 1 + LCS(i+1,j+1,k-1,dp);
            }

            //Moving of J character
            res = Math.max(res,LCS(i,j+1,k,dp));
            res = Math.max(res,LCS(i+1,j,k,dp));

        }

        return dp[i][j][k] = res;
    }
}
