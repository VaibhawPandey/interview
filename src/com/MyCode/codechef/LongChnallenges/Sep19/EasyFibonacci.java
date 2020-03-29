package com.MyCode.codechef.LongChnallenges.Sep19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasyFibonacci {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t= scanner.nextInt();
        long arr[]=new long[t];

        for (int i = 0; i < t; i++)
            arr[i] = scanner.nextLong();

        List<Integer> d=new ArrayList<>();
        d.add(0);d.add(1);
        for (int j = 2; j < 60; j++)
            d.add((d.get(j-1)+d.get(j-2))%10);

        for (int i = 0; i < t; i++) {

            long n=arr[i];
            long q=0;

            String nBinary = Long.toBinaryString(n);
            q = (long) Math.pow(2,nBinary.length()-1);

            System.out.println(d.get((int) ((q-1)%60)));

        }
    }
}
