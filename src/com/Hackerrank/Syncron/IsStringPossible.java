package com.Hackerrank.Syncron;

import java.util.Scanner;

public class IsStringPossible {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x1=scanner.nextInt();
        int y1=scanner.nextInt();
        int x2=scanner.nextInt();
        int y2=scanner.nextInt();


        System.out.println(isPossible(x1,y1,x2,y2));
    }

    public static String isPossible(int a, int b, int c, int d) {
        // Write your code here
        if(a==c && b==d)
            return "YES";

        if(a>c || b>d)
            return "NO";

         if(isPossible(a+b,b,c,d).equalsIgnoreCase("YES"))
             return "YES";
         if(isPossible(a,b+a,c,d).equalsIgnoreCase("YES"))
             return "YES";

         return "NO";
    }
}
