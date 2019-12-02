package com.practice.BrillioTechContest;

import java.util.Arrays;
import java.util.Scanner;

public class ProxyClassroom {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        boolean arr[]=new boolean[n+1];

        for (int i = 1; i <=n; i++)
            arr[scanner.nextInt()] = true;

        String output="";
        for (int i = 1; i <=n; i++)
            if(!arr[i]) {
                if(output.equalsIgnoreCase(""))
                    output = "" +i;
                else
                   output +=" " +i;
            }

        System.out.print(output);
    }
}
