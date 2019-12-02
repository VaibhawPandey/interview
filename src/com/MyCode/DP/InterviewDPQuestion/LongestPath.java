package com.MyCode.DP.InterviewDPQuestion;

import java.util.Arrays;

public class LongestPath {

    public static void main(String[] args) {
        int n=3;
        int mat[][] = { { 1, 2, 9 },
            { 5, 3, 8 },
            { 4, 6, 7 } };

        int dp[][]=new int[n+1][n+1];

        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i],-1);

        int result=0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                 if(dp[i][j] == -1)
                     dp[i][j]=findLongestFromACell(mat,dp,i,j,n);

                 result = Math.max(result,dp[i][j]);
            }
        }

        System.out.println(result);


    }

    private static int findLongestFromACell(int[][] mat, int[][] dp, int i, int j,int n) {

        if(i<0 || i>=n || j<0 || j>=n)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int x=Integer.MIN_VALUE,y=Integer.MIN_VALUE,z=Integer.MIN_VALUE,w=Integer.MIN_VALUE;

        if(i < n-1 && (mat[i][j] + 1) == mat[i+1][j])
            x = 1 + findLongestFromACell(mat,dp,i+1,j,n);

        if(j < n-1 && (mat[i][j] + 1) == mat[i][j+1])
            y = 1 + findLongestFromACell(mat,dp,i,j+1,n);

        if(i > 0 && (mat[i][j] + 1) == mat[i-1][j])
            z = 1 + findLongestFromACell(mat,dp,i-1,j,n);

        if(j > 0 && (mat[i][j] + 1) == mat[i][j-1])
            w = 1 + findLongestFromACell(mat,dp,i,j-1,n);

        int result=Math.max(x,Math.max(y,Math.max(z,w)));

        if(result == Integer.MIN_VALUE)
            return 0;
        else
            return result;
    }
}
