package com.Java.Java8;

public class MethodReferenceByNonStaticMethod {

    interface A{
        void AInj();
    }

    public void printMsg(){
        System.out.println("Printed Message");
    }

    public static void main(String[] args) {
         A a=new MethodReferenceByNonStaticMethod()::printMsg;
         a.AInj();
    }
}
