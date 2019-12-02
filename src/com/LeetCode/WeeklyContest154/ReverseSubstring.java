package com.LeetCode.WeeklyContest154;

import java.util.Scanner;
import java.util.Stack;

public class ReverseSubstring {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        System.out.println(reverseParentheses(s));
    }
    public static String reverseParentheses(String s) {

        String outputString="",tempString="";
        Stack<Character> stack=new Stack<>();
        int bracCount=0;
        for (int i = 0; i < s.length(); i++) {

             if(s.charAt(i) == '(')
                 bracCount++;
             if(bracCount>0) {
                 if (s.charAt(i) == ')') {
                     bracCount--;
                     char ch = stack.pop();
                     tempString = "";
                     while (ch != '(') {
                         tempString += ch;
                         ch = stack.pop();
                     }
                     for (int j = 0; j < tempString.length(); j++)
                         stack.push(tempString.charAt(j));

                     if(bracCount == 0)
                     outputString += tempString;
                 } else
                     stack.push(s.charAt(i));
             }else
                outputString += s.charAt(i);
        }

        if(outputString.equalsIgnoreCase(""))
            outputString = tempString;



        return outputString;
    }
}
