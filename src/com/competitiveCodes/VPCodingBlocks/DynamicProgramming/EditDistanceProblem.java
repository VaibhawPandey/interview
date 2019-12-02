package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

/*
* Reference :- https://www.youtube.com/watch?v=UKxWcCRPZmQ
* */
public class EditDistanceProblem {

    public static void main(String args[]){

        String input="cast",output="cats";

        int inpLength=input.length();
        int outLength=output.length();
        int dp[][]=new int[inpLength+1][outLength+1];

        for (int i=1;i<=inpLength;i++) dp[i][0] = dp[i-1][0] + 1;
        for (int j=1;j<=outLength;j++) dp[0][j] = dp[0][j-1] + 1;

        dp[0][0]= 0;
        for (int i=1;i<=inpLength;i++){
            for (int j=1;j<=outLength;j++){

                int q1= dp[i-1][j-1]; // Reflection
                int q2= dp[i-1][j]; // Deletion
                int q3 = dp[i][j-1];  // Insertion /* Logic in note book*/

                dp[i][j] = Math.min(q1,Math.min(q2,q3)) + (input.charAt(i-1) != output.charAt(j-1) ? 1:0);
            }
        }

        System.out.println(dp[inpLength][outLength]);

    }
}
