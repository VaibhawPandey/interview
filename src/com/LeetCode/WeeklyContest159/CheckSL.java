package com.LeetCode.WeeklyContest159;

import java.util.Scanner;

public class CheckSL {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int arr[][]={{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
        System.out.println(checkStraightLine(arr));
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        int xAxis=coordinates[0][0],yAxis=coordinates[0][1];

        if(coordinates.length==2)
            return true;

        for (int i = 1; i < coordinates.length-1; i++) {
            //if(Math.abs((float)(coordinates[i][0]-xAxis)/(float)(coordinates[i][1]-yAxis))!=1)
            if(((coordinates[i][1]-yAxis)*(coordinates[i+1][0]-xAxis))!=((coordinates[i+1][1]-yAxis)*(coordinates[i][0]-xAxis)))
                return false;
        }

        return true;
    }
}
