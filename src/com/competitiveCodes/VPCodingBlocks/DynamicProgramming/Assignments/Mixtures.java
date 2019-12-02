package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;


public class Mixtures {

    static int arr[];
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        arr=new int[n];

        for (int i = 0; i < n; i++)
            arr[i]=scanner.nextInt();

        long arrMatrix[][]=new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               arrMatrix[i][j]=-1;
            }
        }

        System.out.println(printMinValue(arrMatrix,0,n-1));
    }

    private static long printMinValue(long[][] arrMatrix,int st,int en) {

        if(st>=en)
            return 0;

        if(arrMatrix[st][en] != -1)
            return arrMatrix[st][en];

        arrMatrix[st][en]=Integer.MAX_VALUE;

        for (int k=st;k<=en;k++){
            arrMatrix[st][en]=Math.min(arrMatrix[st][en],printMinValue(arrMatrix,st,k) + printMinValue(arrMatrix,k+1,en) + sumRange(st,k)*sumRange(k+1,en));
        }
        return arrMatrix[st][en];

    }

    private static long sumRange(int st, int en) {
        long ans=0;

        for (int i = st; i <= en; i++)
            ans += arr[i];
        ans %= 100;

        return ans;
    }
}
