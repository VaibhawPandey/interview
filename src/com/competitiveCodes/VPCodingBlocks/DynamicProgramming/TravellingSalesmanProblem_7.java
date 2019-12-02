package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

public class TravellingSalesmanProblem_7 {

    static long dp[][];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int arr[][]=new int[n][n];
        dp=new long[(1<<n)][n];
        for (int i = 0; i < (1<<n); i++) {
            for (int j = 0; j < n; j++) {
               if(i<n)
               arr[i][j]=scanner.nextInt();

               dp[i][j] = -1;
            }
        }





        int VISITED_ALL = (1<<n) - 1;

        System.out.println(getMinValue(arr,VISITED_ALL,1,0));
    }



    private static long getMinValue(int[][] arr,int VISITED_ALL, int mask, int pos) {

        long ans=Integer.MAX_VALUE;

        if(mask==VISITED_ALL)
            return arr[pos][0];

        System.out.println(mask +"--" +pos);
        if(dp[mask-1][pos] != -1)
            return dp[mask][pos];

        for (int city = 0; city < arr.length; city++) {
            if((mask&(1<<city))==0){
                long newAns= arr[pos][city] + getMinValue(arr,VISITED_ALL,(mask|(1<<city)),city);
                ans=Math.min(newAns,ans);
            }
        }


        return dp[mask-1][pos] =ans;
    }
}
