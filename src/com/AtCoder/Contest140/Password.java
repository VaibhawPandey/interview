package com.AtCoder.Contest140;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int ans= (int) Math.pow(n,3);
        System.out.println(ans);
    }
}
