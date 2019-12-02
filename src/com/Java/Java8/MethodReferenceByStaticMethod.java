package com.Java.Java8;

public class MethodReferenceByStaticMethod {

    interface A{
        void getA();
    }

    public static void getMethod(){
        System.out.println("Method reference");
    }

    public static void main(String[] args) {

        A a=MethodReferenceByStaticMethod::getMethod;
        a.getA();

    }
}
