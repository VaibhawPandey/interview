package com.LeetCode.WeeklyContest149;

import java.util.Scanner;

public class NumberodDiceRolls {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int d=scanner.nextInt();
        int f=scanner.nextInt();
        int target=scanner.nextInt();

        System.out.println(numRollsToTarget(d,f,target));

    }

    public static int numRollsToTarget(int d, int f, int target) {
        long table[][]=new long[d+1][target+1];

        for (int i = 1; i<=f && i <= target; i++)
            table[1][i] = 1;

        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k<j && k <= f; k++)
                    table[i][j] += table[i-1][j-k]%1000000007;
            }
        }



        return (int) (table[d][target]%1000000007);
    }
}
