package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Scanner;

public class EggDroppingProblem_9 {

    static int eggDropping[][];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),k=scanner.nextInt();
        eggDropping=new int[n+1][k+1];



        System.out.println(eggDrop(n,k));

    }

    private static int eggDrop(int n, int k) {

        int res;

        for (int i = 1; i <= n; i++) {
            eggDropping[i][1]=1;
            eggDropping[i][0]=0;
        }

        for (int i = 1; i <= k; i++)
            eggDropping[1][i]=i;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                eggDropping[i][j] = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    res = 1 + Math.max(eggDropping[i-1][l-1],eggDropping[i][j-l]);
                     if(res < eggDropping[i][j])
                         eggDropping[i][j] = res;
                }
            }
        }

        return eggDropping[n][k];
    }
}
