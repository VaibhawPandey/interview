package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;


import java.util.Scanner;

/*
   *Date 30/03/2019
   * @author Vaibhaw Pandey
   * Rod cutting problem to maximize profit
 */
public class RodCuttingProblem {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int priceofEachLen[]=new int[n];
        for (int i=0;i<n;i++)
            priceofEachLen[i]=scanner.nextInt();

        System.out.println(maxProfitDP(priceofEachLen,n));




    }

    /*TimeComplexity :- O(4^n)*/
    private static int maxProfit(int[] priceofEachLen, int n) {

        int best=0;
        for (int i=0;i<n;i++){
            int netProfit = priceofEachLen[i] + maxProfit(priceofEachLen,n - i - 1);
            best = Math.max(best,netProfit);
        }

        return best;
    }

    /*
    *  Max profit using Memoziation
    *  TimeComplexity :- O(n^2)
    */
    private static int maxProfitMem(int priceofEachLen[],int maxLen){
       int memo[]=new int[maxLen];

       for (int i=0;i<maxLen;i++)
           memo[i] = -1;

       if(memo[maxLen-1] != -1)
           return memo[maxLen];


       int best = 0;
       for (int i=0;i<maxLen;i++){
           int netProfit=priceofEachLen[i] + maxProfit(priceofEachLen,maxLen-i-1);
           best = Math.max(best,netProfit);
       }
       memo[maxLen-1] = best;

        return best;
    }

    /*
    *  Max profit using DP
    *  TimeComplexity :- O(n^2)
    */
    private static int maxProfitDP(int priceofEachLen[],int maxLen){
        int dp[] = new int[maxLen+1];

        for (int len=1;len<=maxLen;len++){
            int best=0;
            for (int cut=1;cut<= len;cut++){
                int netProfit=priceofEachLen[cut-1] + dp[len-cut];
                best = Math.max(netProfit,best);
            }
            dp[len]=best;
        }

        return dp[maxLen];

    }
}
