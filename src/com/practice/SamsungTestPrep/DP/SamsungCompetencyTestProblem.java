package com.practice.SamsungTestPrep.DP;

import java.util.Scanner;

public class SamsungCompetencyTestProblem {

    static int xa,xb,ya,yb;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //int t=scanner.nextInt();

        int m=scanner.nextInt(),n=scanner.nextInt();
        int k=scanner.nextInt();
        int A[][]=new int[m][n];

        for (int i = 0; i < k; i++) {
            int x=scanner.nextInt()-1;
            int y=scanner.nextInt()-1;
            A[x][y] = 1;
        }

        int dp[][]=new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + A[i-1][j-1];
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(dp[i][j] +" ");
            System.out.println();
        }


        //Print DP
        int l=1,r=Math.min(m,n);
        while (l<r){

            int mid=(l+r)/2;
            int val=getMaxResult(dp,m,n,mid);

            if(val> 1)
                r = mid;
            else
                l = mid+1;
        }

        System.out.println(xa +"," +ya +"--" +xb +"," +yb);


        }

    private static int getMaxResult(int[][] dp, int m, int n, int mid) {

        int minSum=Integer.MAX_VALUE;

        for (int i = 0; i <= m-mid; i++) {
            for (int j = 0; j <= n-mid; j++) {
                int sum = dp[i+mid][j+mid] - dp[i+mid][j] - dp[i][j+mid] + dp[i][j];

                if(sum<minSum){
                    minSum = sum;
                    if(minSum <= 1){
                        xa = i+1;
                        ya = j+1;
                        xb = i+mid;
                        yb = j+mid;
                    }
                }
            }
        }

        return minSum;
    }
}
