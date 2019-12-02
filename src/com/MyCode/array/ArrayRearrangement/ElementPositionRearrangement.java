package com.MyCode.array.ArrayRearrangement;

import java.util.Arrays;
import java.util.Collections;

public class ElementPositionRearrangement {

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 4, 5, 6, 8,8};
        int n = arr.length;

        reArrange(arr,n);
    }

    private static void reArrange(int[] arr, int n) {

        int tempArr[]=new int[n];
        for (int i = 0; i < n; i++)
            tempArr[i] = arr[i];
        Arrays.sort(tempArr);


        int evenPos=n/2;
        int oddPos = n - evenPos;

        int position=0;

        for (int i = oddPos-1; i >= 0; i--) {

            int temp=tempArr[i];
            arr[position] = temp;
            position += 2;
        }

        position=1;

        for (int i = oddPos; i < n; i++) {
            int temp = tempArr[i];
            arr[position] = temp;
            position += 2;
        }

        //System.out.println();

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");






    }
}
