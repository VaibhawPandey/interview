package com.MyCode.array.OrderStatistics;

import java.util.Random;
import java.util.Scanner;

/**
 * Using QuickSort
 * Ref:- https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time-2/
 */
public class KthLargestElementInLinearTime {

    public static void main(String[] args) {

        int arr[] = {7, 10, 4, 3, 20, 15};
        int k=3;

        System.out.println(kthLargestElement(arr,0,arr.length-1,k));
    }

    private static int kthLargestElement(int[] arr, int l, int r, int k) {

        if(k>0 && k<= r-l+1) {

            int randamizedPivot = randomizedPivot(arr, l, r);

            if (randamizedPivot-1 == k-1)
              return arr[randamizedPivot];

            if(randamizedPivot-1>k-1)
                return kthLargestElement(arr,l,randamizedPivot-1,k);

            return kthLargestElement(arr,randamizedPivot+1,r,k-randamizedPivot+l-1);
        }

        return Integer.MAX_VALUE;

    }

    private static int randomizedPivot(int[] arr, int l, int r) {

        int n=r-l;
        int pivot=new Random().nextInt(1);
        arr = swap(arr,l+pivot,r);
        return partition(arr,l,r);
    }

    private static int partition(int[] arr, int l, int r) {

        int x=arr[l],i=r;

        for (int j = l; j < r-1; j++) {
            if(arr[j]>=x){
                swap(arr,i,j);
                i--;
            }
        }

        swap(arr,i,r);

        return i;
    }

    private static int[] swap(int[] arr, int l, int r) {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;

        return arr;
    }
}
