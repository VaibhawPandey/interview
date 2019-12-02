package com.MyCode.Graph.BFSANDDFS.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class PathinRectangleCircle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt(),n= scanner.nextInt(),k= scanner.nextInt(),r=scanner.nextInt();

        int graph[][]=new int[m][n];
        int X[]=new int[k];
        int Y[]=new int[k];

        for (int i = 0; i < k; i++) {
            X[i] = scanner.nextInt() - 1;
            Y[i] = scanner.nextInt() - 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    if(Math.sqrt(Math.pow(X[l]-i,2)+Math.pow(Y[l]-j,2)) <= r)
                        graph[i][j]=-1;
                }
            }
        }


        if(isPossible(m,n,graph))
            System.out.println("Is possible");
        else
            System.out.println("Not possible");


    }

    private static boolean isPossible(int m, int n, int[][] graph) {
        return true;
    }
}
