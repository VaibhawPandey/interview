package com.LeetCode.WeeklyContest181;

public class FourDivisors {

    public static void main(String[] args) {
       int nums[] = {21,4,7};
        System.out.println(sumFourDivisors(nums));
    }

    public static int sumFourDivisors(int[] nums) {
        int output = 0, last_num = 0;
        for (int num: nums){
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num%i == 0){
                    if(last_num == 0)
                        last_num = i;
                    else {
                        last_num = 0;
                        break;
                    }
                }
            }
            if(last_num > 0 && last_num != num/last_num){
                output += 1 + num + last_num + (num/last_num);
            }
        }
        return output;
    }
}
