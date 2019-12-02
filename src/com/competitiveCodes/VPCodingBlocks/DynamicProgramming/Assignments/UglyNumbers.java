package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class UglyNumbers {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        int arr[]=new int[t];

        for (int i = 0; i < t; i++)
            arr[i]=scanner.nextInt();

        for (int i = 0; i < t; i++)
            System.out.println(nextUglyNumber(arr[i]));
    }

    private static int nextUglyNumber(int n) {

        int uglyNumber[]=new int[n];
        int i1=0,i2=0,i3=0;

        uglyNumber[0]=1;
        int next_multiple_of_2=uglyNumber[i1]*2,
                next_multiple_of_3=uglyNumber[i1]*3,
                next_multiple_of_5=uglyNumber[i1]*5;

        for (int i = 1; i < n; i++) {

            uglyNumber[i]=Math.min(next_multiple_of_2,Math.min(next_multiple_of_3,next_multiple_of_5));

            if(uglyNumber[i] == next_multiple_of_2){
                i1++;
                next_multiple_of_2 = uglyNumber[i1]*2;
            }
            if(uglyNumber[i] == next_multiple_of_3){
                i2++;
                next_multiple_of_3 = uglyNumber[i2]*3;
            }
            if(uglyNumber[i] == next_multiple_of_5){
                i3++;
                next_multiple_of_5 = uglyNumber[i3]*5;
            }
        }

       return uglyNumber[n-1];
    }
}
