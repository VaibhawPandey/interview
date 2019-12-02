package com.Techgig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WarProblem {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int R[]=new int[t];
        int P[]=new int[t];

        for (int i = 0; i < t; i++) {
           R[i]=scanner.nextInt();
           P[i]=scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int r=R[i],p=P[i];
            long dp[][]=new long[r+1][r+1];
            for (int j = 0; j <= r; j++)
                Arrays.fill(dp[j],-1);

            long count =longRecur(p,r,p,0,dp);
            System.out.println(count%1000000007);

        }
    }

    private static long longRecur(int p, int r,int noofA,int noofB, long[][] dp) {



        if(noofA < noofB*p)
            return 0;

        if(noofA+noofB == r)
            return 1;

        if(dp[noofA][noofB]!=-1)
            return dp[noofA][noofB];

        dp[noofA][noofB] = (longRecur(p,r,noofA+1,noofB,dp)+longRecur(p,r,noofA,noofB+1,dp))%1000000007;

        return dp[noofA][noofB];
    }

    private static long longRecur(final int p, final int r, int noOfA, int noOfS,long count) {


        if(noOfA < noOfS*p)
            return count;

          if(r == noOfA+noOfS) {
              count++;
              return count;
          }

         return (longRecur(p,r,noOfA+1,noOfS,count)+longRecur(p,r,noOfA,noOfS+1,count))%1000000007;
    }
}
