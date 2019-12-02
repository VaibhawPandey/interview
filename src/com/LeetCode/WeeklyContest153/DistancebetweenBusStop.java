package com.LeetCode.WeeklyContest153;

public class DistancebetweenBusStop {

    public static void main(String[] args) {
        int distance[] = {8,11,6,7,10,11,2};
        //int distance[] = {3,6,7,2,9,10,7,16,11};
        int start=0,destination=3;
        System.out.println(distanceBetweenBusStops(distance,start,destination));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int n=distance.length;
        int pathDistance=0,reversePathDistance=0;

        int tempStart=start,tempDest = destination;
        while (tempStart != tempDest){
            pathDistance += distance[tempStart];
            tempStart++;
            if(tempStart == n)
                tempStart = 0;
        }

        tempStart = start;tempDest=destination;



        if(tempStart==0)
            tempStart = n - 1;

        while (tempStart >= tempDest){

            reversePathDistance += distance[tempStart];
            if(tempDest == tempStart)
                break;
            tempStart--;
        }



        return Math.min(pathDistance,reversePathDistance);
    }
}
