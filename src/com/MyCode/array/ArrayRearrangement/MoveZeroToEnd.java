package com.MyCode.array.ArrayRearrangement;

public class MoveZeroToEnd {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 9, 8, 4, 0, 0, 2,
                7, 0, 6, 0, 9 };

        int count=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] +" ");


    }
}
