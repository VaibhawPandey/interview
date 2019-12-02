package com.MyCode.DP.LeetCode.Easy;

import java.util.Scanner;

public class BuyAndSellStock {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minProfit)
                minProfit = prices[i];
            else
                if(prices[i]-minProfit>maxProfit)
                    maxProfit = prices[i]-minProfit;
        }

        return maxProfit;
    }
}
