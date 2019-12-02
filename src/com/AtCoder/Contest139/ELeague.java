package com.AtCoder.Contest139;

import java.util.Scanner;

public class ELeague {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int A[][]=new int[n+1][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }


        System.out.println(getResult(A,n));


    }

    private static int getResult(int[][] a, int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                int k=a[i][j];
                if(a[k][j] != i)
                    return -1;
            }
        }

        return n;
    }
}
