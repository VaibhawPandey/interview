package com.AtCoder.Contest139;

import java.util.Scanner;

public class ModSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();

        long output=0;

        for (int i = 0; i < n; i++)
            output += i;

        System.out.println(output);
    }
}
