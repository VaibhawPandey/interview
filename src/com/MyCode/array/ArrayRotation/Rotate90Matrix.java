package com.MyCode.array.ArrayRotation;

/*
  **
  * Ref :- https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
 */

public class Rotate90Matrix {

    static int arr[][];

    public static void main(String[] args) {
        arr = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotate90Clockwise();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(arr[i][j] +" ");
            System.out.println();
        }

    }

    private static void rotate90Clockwise() {

        int N = arr.length;

        for (int i = 0; i < N/2; i++) {
            for (int j = i; j < N-1-i; j++) {
                int temp=arr[i][j];
                arr[i][j] = arr[N-1-j][i];
                arr[N-1-j][i] = arr[N-1-i][N-1-j];
                arr[N-1-i][N-1-j] = arr[j][N-1-i];
                arr[j][N-1-i] = temp;
            }
        }
    }
}
