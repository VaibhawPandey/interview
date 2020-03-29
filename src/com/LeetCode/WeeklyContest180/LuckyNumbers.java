package com.LeetCode.WeeklyContest180;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        int matrix[][] = {{3,7,8},{9,11,13},{15,16,17}};
        List<Integer> lN=luckyNumbers(matrix);
        lN.forEach(it -> System.out.println(it));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> output= new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(m +" " +n);

        return output;
    }
}
