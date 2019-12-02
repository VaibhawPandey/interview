package com.AtCoder.Contest136;

import java.util.Scanner;

public class Transfer {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt(),b=scanner.nextInt(),c=scanner.nextInt();

        int diff=a-b;
        if(diff<=c)
            System.out.println(c-diff);
        else
            System.out.println(0);

    }
}
