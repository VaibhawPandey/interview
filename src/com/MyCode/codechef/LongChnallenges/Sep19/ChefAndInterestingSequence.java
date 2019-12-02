package com.MyCode.codechef.LongChnallenges.Sep19;

import java.util.Scanner;

public class ChefAndInterestingSequence {

    static int minCount,sum=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t= scanner.nextInt();
        int output[]= new int[t];

        for (int i = 0; i < t; i++) {
            minCount = 0;
            int n=scanner.nextInt(),k=scanner.nextInt();

            int arr[]=new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            int local_Sum=0;
            interestingSequence(arr,0,k,0,local_Sum);
            output[i] = minCount;
        }

        for (int i = 0; i < t; i++)
            System.out.println(output[i]);


    }

    private static void interestingSequence(int[] arr, int index, int k, int position,int local_Sum) {

        if(index == k) {
            if (sum == local_Sum)
                minCount++;
            else
            if(sum>local_Sum){
                sum = local_Sum;
                minCount = 1;
            }
            System.out.println("Sum:-" +sum);
            return;
        }

        if(position>=arr.length)
            return;

        local_Sum += arr[position];
        interestingSequence(arr,index+1,k,position+1,local_Sum);

        local_Sum -= arr[position];
        interestingSequence(arr,index,k,position+1,local_Sum);


    }
}
