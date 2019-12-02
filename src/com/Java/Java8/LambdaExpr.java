package com.Java.Java8;

import java.util.Scanner;

public class LambdaExpr {


    interface A {
        public void say(int a);
    }

    public static void main(String[] args) {
        int b =5;
        //Scanner scanner=new Scanner(System.in);
        A aInt = (a)->{
            //b=6;
            System.out.println(a);
        } ;

        aInt.say(b);


    }
}
