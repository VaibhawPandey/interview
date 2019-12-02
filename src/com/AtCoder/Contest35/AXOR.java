package com.AtCoder.Contest35;

import java.util.Scanner;

public class AXOR {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int arr[]=new int[n];
        for (int i = 0; i < n; i++)
            arr[i]=scanner.nextInt();

        boolean isAdjacentEqual=adjacentXOR(n,arr);

        if(isAdjacentEqual)
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    private static boolean adjacentXOR(int n, int[] arr) {

        boolean isAdjacentEqual = true;
        for (int i = 0; i < n; i++) {
            int adj1,adj2;
            if(i==0)
                adj1=arr[n-1];
            else
                adj1=arr[i-1];

            if(i==n-1)
                adj2=arr[0];
            else
                adj2=arr[i+1];

            int temp=adj1^adj2;
            if(temp != arr[i]) {
                isAdjacentEqual = false;
                break;
            }
        }

        return isAdjacentEqual;
    }
}
