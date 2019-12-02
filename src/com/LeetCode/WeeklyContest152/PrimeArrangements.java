package com.LeetCode.WeeklyContest152;

import java.util.Scanner;

public class PrimeArrangements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(numPrimeArrangements(n));
    }
    public static int numPrimeArrangements(int n) {

        int count=0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i))
                count++;
        }

        long answer=1;

        for (int i = count; i > 0; i--)
            answer = (answer*i)%1000000007;

        count = n - count;
        for (int i = count; i > 0; i--)
            answer = (answer*i)%1000000007;

        return (int) (answer%1000000007);

    }

    private static boolean isPrime(int n) {

        for (int i = 2; i < n; i++) {
            if(n%i == 0)
                return false;
        }

        return true;

    }
}
