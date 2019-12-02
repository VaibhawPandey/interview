package com.LeetCode.WeeklyContest144;

import java.util.Scanner;

public class DefangingIPAdd {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        s = s.replaceAll("\\.","[.]");

        System.out.println(s);
    }
}
