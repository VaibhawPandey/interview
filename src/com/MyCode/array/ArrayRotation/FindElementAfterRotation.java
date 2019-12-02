package com.MyCode.array.ArrayRotation;

public class FindElementAfterRotation {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        // No. of rotations
        int rotations = 2;

        // Ranges according to 0-based indexing
        int[][] ranges = { { 0, 2 }, { 0, 3 } };

        int index = 1;
        System.out.println(findRotation(arr,ranges,rotations,index));
    }

    private static int findRotation(int[] arr, int[][] ranges, int rotations, int index) {

        for (int i = 0;i<ranges.length;i++) {

            int left = ranges[i][0];
            int right=ranges[i][1];

            if(left<=index && right>= index){
                if(index==left)
                    index = right;
                else
                    index--;
            }
        }

        return index;
    }
}
