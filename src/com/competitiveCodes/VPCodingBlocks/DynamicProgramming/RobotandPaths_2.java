package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

/*
  * codechef
  * @author: Vaibhaw Pandey
  * @Question :- https://www.codechef.com/problems/CD1IT4
 */
public class RobotandPaths_2 {

     static int dp[][]=new int[1001][1001];
     public static void main(String args[]){

         Scanner scanner=new Scanner(System.in);
         int M=scanner.nextInt();
         int N=scanner.nextInt();
         int P=scanner.nextInt();

         for (int i = 0; i < P; i++) {
             int X=scanner.nextInt(),Y=scanner.nextInt();
             dp[X-1][Y-1]=-1;
         }

         System.out.println(numWays(M,N));
     }

    private static int numWays(int row, int col) {

        //Base Case
        if (dp[0][0] == -1)
            return 0;

        //Compute the no of ways of row
        for (int i = 0; i < row; i++) {
            if (dp[i][0] == -1)
                continue;

            dp[i][0] = 1;
        }

        //Compute the no of ways of col
        for (int i = 0; i < col; i++) {
            if (dp[0][i] == -1)
                continue;

            dp[0][i] = 1;
        }

        //Bottom up approach
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {

                if(dp[i][j] == -1)
                    continue;

                dp[i][j]=0;
                if(dp[i][j-1] != -1)
                    dp[i][j] = dp[i][j-1];

                if(dp[i-1][j] != -1)
                    dp[i][j] = dp[i][j] + dp[i-1][j];

            }
        }

        if(dp[row-1][col-1] == -1)
            return 0;

        return dp[row-1][col-1];

    }
}
