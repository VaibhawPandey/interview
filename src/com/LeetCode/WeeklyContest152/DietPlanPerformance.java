package com.LeetCode.WeeklyContest152;

public class DietPlanPerformance {


    public static void main(String[] args) {
        int calories[]={6,13,8,7,10,1,12,11};
        System.out.println(dietPlanPerformance(calories,6,5,37));
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int output=0;
        for (int i = 0; i < calories.length && (i+k)<=calories.length; i++) {
            int sum=0;
            for (int j = 0; j < k; j++)
                sum += calories[i+j];

            if(sum<lower)
                output--;
            if(sum>upper)
                output++;
        }

        return output;
    }
}
