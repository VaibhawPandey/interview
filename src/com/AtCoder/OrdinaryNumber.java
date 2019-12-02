package com.AtCoder;

import java.util.Scanner;

public class OrdinaryNumber {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int arr[]=new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int mainCount=0;

        for (int i = 1; i < n-1; i++) {

            if(arr[i]>arr[i-1] && arr[i]<arr[i+1])
                mainCount++;
            else if(arr[i]<arr[i-1] && arr[i]>arr[i+1])
                mainCount++;
        }

        System.out.println(mainCount);

    }
}
