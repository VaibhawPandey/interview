package com.LeetCode.WeeklyContest144;

public class CorporateFlightBooking {

    public static void main(String[] args) {

        int bookings[][]={{1,2,10},{2,3,20},{2,5,25}};
        int n=5;
        int output[]=corpFlightBookings(bookings,n);
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.println(output[i]);

    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        int output[]=new int[n+1];

        for (int i = 0; i < bookings.length; i++) {
            int src=bookings[i][0]-1;
            int dest=bookings[i][1]-1;

            output[src] += bookings[i][2];
            output[dest+1] -= bookings[i][2];
        }

        for (int i = 1; i < output.length; i++) {
            output[i]=output[i]+output[i-1];
        }

        return output;
    }
}
