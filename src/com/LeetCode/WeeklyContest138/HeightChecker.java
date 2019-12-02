package com.LeetCode.WeeklyContest138;

import java.util.*;

public class HeightChecker {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int[] heights=new int[8];

        for (int i = 0; i < 8; i++)
            heights[i] = scanner.nextInt();

        int[] mainHeights=new int[heights.length];
        for (int i = 0; i < mainHeights.length; i++)
            mainHeights[i] = heights[i];

        Arrays.sort(heights);

        int count=0;

        for (int i = 0; i < mainHeights.length; i++) {
            if(mainHeights[i] != 0 && heights[i] != mainHeights[i])
                count++;
        }

        System.out.println(count);




    }
}
