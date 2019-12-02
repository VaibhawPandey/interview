package com.AtCoder.Contest139;

import java.util.Scanner;

public class PowerSocket {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int A=scanner.nextInt();
        int B=scanner.nextInt();

        int noOfPortsOpen = 1,noOfSockets=0;
        while (noOfPortsOpen<B){
            noOfSockets++;
            noOfPortsOpen = A*noOfSockets - (noOfSockets-1);
        }

        System.out.println(noOfSockets);
    }
}
