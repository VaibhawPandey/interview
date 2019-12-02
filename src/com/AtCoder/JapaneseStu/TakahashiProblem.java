package com.AtCoder.JapaneseStu;

import java.util.Scanner;

public class TakahashiProblem {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int d=scanner.nextInt();

        int count=0;

        for (int i = 22; i <= d; i++) {
            if(i%10 >= 2) {
                int mult = (i % 10) * (i / 10);
                if (mult <= m)
                    count++;
            }
        }

        System.out.println(count);
    }
}
