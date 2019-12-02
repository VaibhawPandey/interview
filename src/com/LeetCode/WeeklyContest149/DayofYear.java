package com.LeetCode.WeeklyContest149;

import java.util.Scanner;

public class DayofYear {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String date=scanner.next();
        System.out.println(dayOfYear(date));
    }

    public static int dayOfYear(String date) {
        String dateString[]=date.split("-");
        int year = Integer.parseInt(dateString[0]);
        int month=Integer.parseInt(dateString[1]);
        int days = Integer.parseInt(dateString[2]);
        boolean isLeapYear=checkYear(year);

        int noofDays=0;
        for (int i = 0; i < month-1; i++) {
           noofDays += noofDays(i+1,isLeapYear);
        }

        noofDays += days;


        return noofDays;
    }

    private static boolean checkYear(int year)
    {

        if (year % 400 == 0)
            return true;


        if (year % 100 == 0)
            return false;


        if (year % 4 == 0)
            return true;
        return false;
    }

    public static int noofDays(int month,boolean isLeapYear){
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if(month == 4 || month == 6 || month == 9 || month == 11)
             return 30;
        else {
            if(isLeapYear)
                return 29;
            else return 28;
        }
    }
}
