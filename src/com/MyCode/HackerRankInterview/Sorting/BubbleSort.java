package com.MyCode.HackerRankInterview.Sorting;


public class BubbleSort {
    public static void main(String[] args) {

        int a[]={6,4,1};
        countSwaps(a);
    }

    static void countSwaps(int[] a) {

        int swapCount=0,n=a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i]>a[j]){
                    a=swap(a,i,j);
                    swapCount++;
                }
            }
        }

        System.out.println("Array is sorted in " +swapCount +" swaps.");
        System.out.println("First Element: " +a[0]);
        System.out.println("Last Element: " +a[n-1]);
    }

    private static int[] swap(int[] a, int p1, int p2) {
         a[p1] = a[p1] + a[p2];
         a[p2] = a[p1] - a[p2];
         a[p1] = a[p1] - a[p2];
         return a;
    }
}
