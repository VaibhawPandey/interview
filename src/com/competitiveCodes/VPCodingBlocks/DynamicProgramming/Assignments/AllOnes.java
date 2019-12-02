package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class AllOnes {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();

        int M[][]=new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j]=scanner.nextInt();
            }
        }

        printLargestSquare(M,m,n);

    }

    private static void printLargestSquare(int[][] M,int m,int n) {

        int s[][]=new int[m][n];
        int best=0;

        for (int i = 0; i < m; i++)
            s[i][0]=M[i][0];

        for (int i = 0; i < n; i++)
            s[0][i]=M[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                 if(M[i][j] == 1)
                     s[i][j] = Math.min(s[i][j-1],Math.min(s[i-1][j],s[i-1][j-1])) + 1;
                 else
                     s[i][j] = 0;

                 best=Math.max(s[i][j],best);
            }
        }

        System.out.println(best);
    }
}
