package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockSellingMaxProfit {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        int k[]=new int[t];
        int n[] = new int[t];

        List<int[]> arr=new ArrayList<>();

        for (int i = 0; i < t; i++) {
            k[i] = scanner.nextInt();
            n[i]=scanner.nextInt();
            int arrSub[]=new int[n[i]];
            for (int j = 0; j < n[i]; j++)
                arrSub[j]=scanner.nextInt();

            arr.add(arrSub);
        }

        for (int i = 0; i < t; i++) {
            maxStackSellingPrice(k[i],n[i],arr.get(i));
        }

    }

    private static void maxStackSellingPrice(int k, int n, int[] arr) {

        int profit[][]= new int[k+1][n+1];
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        for (int i = 0; i <= n; i++)
            profit[0][i] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {

                int max_Value=Integer.MIN_VALUE;
                for (int m=0;m<j;m++)
                    max_Value=Math.max(max_Value,arr[j]-arr[m]+profit[i-1][m]);

                profit[i][j] = Math.max(profit[i][j-1],max_Value);
            }
        }

        System.out.println(profit[k][n-1]);


    }
}
