package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class test {



    public static boolean isPalindrome(String word) {
        // Please write your code here.
        String reveredWord="";
        for(int i=word.length()-1;i>=0;i--){
            reveredWord += word.charAt(i);
        }

        if(word.equalsIgnoreCase(reveredWord))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String word = reader.nextLine();
        System.out.println(isPalindrome(word));
    }
}
