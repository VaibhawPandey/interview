package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 */

public class MoneyChange {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int m[]=new int[t];
        int n[]=new int[t];
        List<int[]> arrList=new ArrayList<>();

        for (int i = 0; i < t; i++) {

            m[i]=scanner.nextInt();
            int arr[]=new int[m[i]];

            for (int j = 0; j < m[i]; j++)
                arr[j]=scanner.nextInt();

            arrList.add(arr);
            n[i]=scanner.nextInt();

        }

        for (int i = 0; i < t; i++)
        System.out.println(noOfWays(arrList.get(i),m[i],n[i]));


    }

    //Using DP
    private static int noOfWays(int[] arr, int m, int n) {

          int table[][]=new int[n+1][m];

        for (int i = 0; i < m; i++)
            table[0][i] = 1;

        for (int i=1;i<n+1;i++){
            for (int j = 0; j < m; j++) {

                int x = (i-arr[j]) >= 0 ? table[i-arr[j]][j] : 0;
                int y = (j > 0) ? table[i][j-1]:0;

                table[i][j] = (x+y)%1000000007;
            }
        }

        return table[n][m-1]%1000000007;
    }




}
