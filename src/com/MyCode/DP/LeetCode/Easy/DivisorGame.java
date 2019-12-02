package com.MyCode.DP.LeetCode.Easy;

import java.util.Scanner;

public class DivisorGame {

    public static boolean divisorGame(int n) {

       return (n%2 ==0);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(divisorGame(n));
    }
}
