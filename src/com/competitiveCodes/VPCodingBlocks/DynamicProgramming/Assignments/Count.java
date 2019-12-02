package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class Count {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();

        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }

        countLongestSubarray(arr,n,m);

    }

    private static void countLongestSubarray(int[] arr,int n,int m) {

        int LI=0,RI=0,bestL=0,bestWindow=0,zeroCount=0;

        while (RI < n){

           if(zeroCount<=m){
               if(arr[RI] == 0)
                   zeroCount++;

               RI++;
           }

           if(zeroCount>m){
               if(arr[LI] == 0)
                   zeroCount--;

               LI++;
           }

           if((RI-LI)>bestWindow && zeroCount<=m){
               bestWindow=RI-LI;
               bestL=LI;
           }

        }

        System.out.println(bestWindow);
        for (int i = bestL; i < bestL+bestWindow; i++) {
            if(arr[i] == 0)
                arr[i]=1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" ");
        }

    }
}
