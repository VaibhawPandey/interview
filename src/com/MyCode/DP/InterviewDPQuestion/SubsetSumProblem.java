package com.MyCode.DP.InterviewDPQuestion;

public class SubsetSumProblem {
    public static void main(String[] args) {

        int set[]={3, 34, 4, 12, 5, 2};
        int sum=9;
        int len = set.length;

        boolean dp[][]=new boolean[len+1][sum+1];

        for (int i = 0; i <=len; i++)
            dp[i][0]=true;

        for (int i = 1; i <= sum ; i++)
            dp[0][i] = false;

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];

                if(set[i-1]<=j)
                    dp[i][j] |= dp[i-1][j-set[i-1]];
            }
        }

       /*for (int i = 0; i <= len ; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }*/

        System.out.println(dp[len][sum]);


    }
}
