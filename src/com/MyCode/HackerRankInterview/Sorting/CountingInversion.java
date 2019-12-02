package com.MyCode.HackerRankInterview.Sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class CountingInversion {

    static int loop_count = 0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n=scanner.nextInt();
            int arr[]=new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            mergeSort(arr,0,n-1);
            System.out.println(loop_count);
        }

    }

    private static void mergeSort(int[] arr, int l, int r) {

        if (l<r){
            int mid=(l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            arr = merge(arr,l,mid,r);
        }

        System.out.print(l +"--" +r +"-->");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] +" ");

        System.out.println();
    }


    private static int[] merge(int[] arr, int l, int mid, int r) {
        int i=l,j=mid+1,k=l;
        int tempArr[] = new int[r+1];
        HashSet<Integer> hashSet=new HashSet<>();
        while (i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                if(hashSet.contains(i))
                hashSet.remove(i);

                tempArr[k] = arr[i];
                k++; i++;
            }else {
                tempArr[k] = arr[j];
                j++; k++;
                hashSet.add(i);
                loop_count++;
            }
        }

        while (i<=mid){
            tempArr[k] = arr[i];
            if(!hashSet.contains(i))
                loop_count++;
            k++; i++;

        }

        while (j<=r){
            tempArr[k] = arr[j];
            j++; k++;
        }

        for (int m = l; m < tempArr.length; m++)
            arr[m] = tempArr[m];

        return arr;
    }


}
