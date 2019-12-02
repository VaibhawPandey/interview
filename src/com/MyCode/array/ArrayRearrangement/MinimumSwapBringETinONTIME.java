package com.MyCode.array.ArrayRearrangement;

import java.util.Scanner;

public class MinimumSwapBringETinONTIME {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n=scanner.nextInt();
            int arr[]=new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            int k=scanner.nextInt();
            minimumSwap(arr,k);

        }


    }

    private static void minimumSwap(int[] arr, int k) {

        int countofElementLTK=0,countofNotRequiredElements=0;

        for (int i = 0; i < arr.length; i++)
            if(arr[i]<=k) countofElementLTK++;

        for (int i = 0; i < countofElementLTK; i++)
            if(arr[i]>k) countofNotRequiredElements++;

        int ans=countofNotRequiredElements;

        //Sliding window concept used
        // Moving one element from left window and one element added in right window
        for (int i = 0,j=countofElementLTK; j < arr.length; j++,i++) {

            //Last Window Element
            if(arr[i]>k)
                countofNotRequiredElements--;

            //Current Window Element
            if(arr[j]>k)
                countofNotRequiredElements++;

            ans = Math.min(countofNotRequiredElements,ans);
        }

        System.out.println(ans);
    }
}
