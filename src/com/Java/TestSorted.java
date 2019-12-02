package com.Java;

public class TestSorted {

    public static void main(String[] args) {
        int arr[]={1,3,5,5,8,9,10};
        int n=5;

        System.out.println(getLargestNumberLesser(arr,n));
        System.out.println(getSmallestNumberGreater(arr,n));



    }

    public static int getLargestNumberLesser(int[] arr,int n){

        int lastNumber=-1;

        for (int i=0;i<arr.length;i++){
            if(arr[i]==n)
                break;
            lastNumber=arr[i];
        }

        return lastNumber;
    }

    public static int getSmallestNumberGreater(int[] arr,int n){

        int greaterNumber=-1;
        /*for (int i=0;i<arr.length;i++){
            greaterNumber = arr[i+1];
            if(arr[i]==n && arr[i+1]!=n)
                break;

        }*/

        for (int i = arr.length-1; i > 0; i--) {
            if(arr[i] == n)
                break;
            greaterNumber = arr[i];
        }

        return greaterNumber;

    }
}
