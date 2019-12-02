package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

/*
  *
  * @Question :- https://www.geeksforgeeks.org/friends-pairing-problem/
  *
 */

public class FriendsPairingProblem_4 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int noofMembers=scanner.nextInt();

        System.out.println(countFriendsPairing(noofMembers));


    }

    private static int countFriendsPairing(int noofMembers) {

        int dp[]=new int[noofMembers+1];

        for (int i = 0; i <= noofMembers; i++) {
            if(i<=2)
                dp[i] = i;
            else
                dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }

        return dp[noofMembers];
    }
}
