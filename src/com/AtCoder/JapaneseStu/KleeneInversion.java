package com.AtCoder.JapaneseStu;

import java.util.Scanner;

public class KleeneInversion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();

        int a[]=new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        long output=0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i]>a[j])
                    output++;
            }
        }

        long ot=0;
        //for (int i = 1; i <=k; i++)
            ot = (((long)k*(long)(k+1))/(long)2);

        System.out.println(ot);


        output = (output*ot)%1000000007;

        System.out.println(output);

    }
}
