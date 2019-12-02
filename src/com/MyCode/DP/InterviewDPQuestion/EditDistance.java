package com.MyCode.DP.InterviewDPQuestion;

import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String str1=scanner.next();
        String str2=scanner.next();

        System.out.println(editDistance(str1,str2,str1.length(),str2.length()));
    }

    private static int editDistance(String str1, String str2, int m, int n) {

        int dp[][]=new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                       dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }

        return dp[m][n];
    }
}
