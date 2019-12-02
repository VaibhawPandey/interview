package com.MyCode.array.ArrayRotation;

public class GenerateAllRotationofaNumber {

    public static void main(String[] args) {
        int num = 1445;
        cal(num);
    }

    private static void cal(int num) {

        int n=String.valueOf(num).length();
        int powTen = (int) Math.pow(10,n);

        for (int i=0;i<n;i++){
            int firstDigit = (num*10)/powTen;
            int left = (num*10 + firstDigit)-(firstDigit*powTen);
            System.out.print(left +" ");
            num = left;
        }

    }
}
