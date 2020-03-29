package com.LeetCode.WeeklyContest181;

import java.util.LinkedList;
import java.util.Scanner;

public class Targetcreation {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int nums[] = {0,1,2,3,4};
        int index[] = {0,1,2,2,1};
        int output[] = createTargetArray(nums, index);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
    public static int[] createTargetArray(int[] nums, int[] index) {

        int n =  nums.length;
        int  output[] = new int[n];
        LinkedList<Integer> list =  new LinkedList<>();

        for (int i = 0; i < n; i++)
            list.add(index[i],nums[i]);

        for (int i = 0; i < n; i++) {
            output[i] = list.get(i);
        }

        return output;
    }
}
