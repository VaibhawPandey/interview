package com.MyCode.array.ArrayRotation;


public class SearchISRATemp {

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr.length;
        int key = 3;

        System.out.println(binarySortedArray(arr,key,n));
    }

    private static int binarySortedArray(int[] arr, int key, int n) {

        int pivot = findPivot(arr,0,n-1);

        if(pivot == -1)
            return binarySearch(arr,0,n-1,key);

        if(arr[pivot] == key)
            return pivot;

        if(arr[0]<key)
            return binarySearch(arr,0,pivot-1,key);

        return binarySearch(arr,pivot,n-1,key);
    }

    private static int binarySearch(int arr[],int low,int high,int key){

        if(low>high)
            return -1;

        int mid=(low+high)/2;

        if(arr[mid] == key)
            return mid;

        if(arr[0]<key)
            return binarySearch(arr,0,mid,key);

        return binarySearch(arr,mid+1,high,key);
    }

    private static int findPivot(int[] arr, int low, int high) {

        if(low>high)
            return -1;
        int mid = (low+high)/2;

        if(low<mid && arr[mid]<arr[mid-1])
            return mid-1;

        if(high>mid && arr[mid]>arr[mid+1])
            return mid;

        if(arr[0]>arr[mid])
            return findPivot(arr,low,mid);

        return findPivot(arr,mid+1,high);
    }
}
