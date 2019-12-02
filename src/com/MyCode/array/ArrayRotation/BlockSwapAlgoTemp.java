package com.MyCode.array.ArrayRotation;

public class BlockSwapAlgoTemp {

    static int arr[];
    public static void main(String[] args) {
        arr= new int[]{1, 2, 3, 4, 5, 6, 7};
        int d=2;
        leftRotate(arr,d,7);

        for (int i = 0; i < 7; i++) {
            System.out.print(arr[i] +" ");
        }
    }

    private static void leftRotate(int[] arr, int d, int n) {
        int i=d,j=n-d;

        while (i != j){

           /* if(i<j){
                swap(arr,i-d,d+j-i,i);
                j -= i;
            }else {
                swap(arr,)
            }*/
        }
    }
}
