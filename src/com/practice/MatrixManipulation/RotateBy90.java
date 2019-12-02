package com.practice.MatrixManipulation;

import java.util.Scanner;

public class RotateBy90 {

    static int matrix[][];
    public static void main(String[] args) {

         matrix= new int[][]{{12, 8, 4, 5}, {13, 9, 20, 21},
                 {2, 4, 6, 8}, {1, 3, 5, 7}};

         printMatrix();

        rotateby90Degree();
        System.out.println("After Rotating 90 degree :- ");
        printMatrix();

        rotateby180Degree();
        System.out.println("After Rotating 180 degree :- ");
        printMatrix();

    }

    private static void printMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] +"\t");
            System.out.println();
        }
    }

    private static void rotateby180Degree() {

        int totalNoofLevels=matrix.length/2;
        int level=0,last=matrix.length-1;
        while (level<totalNoofLevels){
            for (int i = level; i < last; i++) {
               swap(level,i,last,last-i+level);
               swap(i,last,last-i+level,level);
            }
            level++;
            last--;
        }
    }

    private static void rotateby90Degree() {

        int totalNoofLevels=matrix.length/2;
        int level=0,last=matrix.length-1;
        while (level<totalNoofLevels){
            for (int i = level; i < last; i++) {
                swap(level,i,i,last);
                swap(level,i,last,last-i+level);
                swap(level,i,last-i+level,level);
            }
            level++;
            last--;
        }
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        int temp=matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]= temp;
    }
}
