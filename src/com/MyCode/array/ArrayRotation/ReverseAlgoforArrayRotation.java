package com.MyCode.array.ArrayRotation;


/*
  **
  * Reference :- https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
 */
public class ReverseAlgoforArrayRotation {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;

        d=d%n;
        arr=leftRotate(arr,d,n);
        printArr(arr);
    }

    private static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] +" ");
    }


    private static int[] leftRotate(int[] arr, int d,int n) {

        arr=reverseArray(arr,0,d-1);
        arr=reverseArray(arr,d,n-1);
        arr=reverseArray(arr,0,n-1);

        return arr;
    }

    private static int[] reverseArray(int[] arr, int start, int end) {
         int temp;

         while (start<end){

             temp = arr[start];
             arr[start]=arr[end];
             arr[end]=temp;
             start++;end--;
         }

         return arr;
    }
}
