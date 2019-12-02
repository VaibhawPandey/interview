package com.AtCoder.Contest140;

import java.util.Scanner;

public class Buffet {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n-1];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = scanner.nextInt();

        for (int i = 0; i < n-1; i++)
            c[i] = scanner.nextInt();

        int satisfaction=0;
        for (int i = 0; i < n; i++) {
            satisfaction += b[a[i]-1];

            if(i>0 && a[i]-a[i-1]==1)
                satisfaction += c[a[i-1]-1];
        }

        System.out.println(satisfaction);
    }
}
