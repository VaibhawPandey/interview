package com.Hackerrank.Agoda;

class Excp1 extends Exception{};

class Excp2 extends Excp1{};


public class ExceptionTest {

    public static void main(String[] args) {
        try {
            throw new Excp2();
        }catch (Excp1 e){
            System.out.println("IN 1");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("In 2");
            e.printStackTrace();
        }
    }
}
