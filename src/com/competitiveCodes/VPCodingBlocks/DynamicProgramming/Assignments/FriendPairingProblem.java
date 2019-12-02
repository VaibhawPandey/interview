package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class FriendPairingProblem {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        int arr[]=new int[t];
        for (int i=0;i<t;i++)
            arr[i]=scanner.nextInt();

        for (int i=0;i<t;i++)
            System.out.println(noOfWaysofPairing(arr[i]));
    }

    private static int noOfWaysofPairing(int n) {

        if(n<=2)
            return n;

        int dp[]=new int[n+1];


        for (int i=0;i<=n;i++) {
            if(i <= 2)
                dp[i]=i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }


        return dp[n];
    }
}
