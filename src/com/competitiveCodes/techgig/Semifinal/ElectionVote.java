package com.competitiveCodes.techgig.Semifinal;

import java.util.Arrays;
import java.util.Scanner;

public class ElectionVote {

    static String output[];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        output = new String[t];

        for (int i = 0; i < t; i++) {


            int r=scanner.nextInt(),c=scanner.nextInt();
            int arrayR[] = new int[r];
            int arrayC[] = new int[c];

            for (int j = 0; j < r; j++)
                arrayR[j] = scanner.nextInt();

            for (int j = 0; j < c; j++)
                arrayC[j] = scanner.nextInt();

            String result=getResult(r,c,arrayR,arrayC);

            output[i] = result;
        }

        for (int i = 0; i < t; i++)
            System.out.println(output[i]);

    }

    private static String getResult(int r, int c, int[] arrayR, int[] arrayC) {

        String result = "YES";

        int matrix[][]=new int[r][c];

        for (int i = 0; i < r; i++)
            Arrays.fill(matrix[i],-1);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if(arrayR[i]>0 && arrayC[j]>0){
                    matrix[i][j] = 1;
                    arrayC[j]--;
                    arrayR[i]--;
                }
            }
        }

        for (int i = 0; i < r; i++)
            if(arrayR[i]>0) {
                result = "NO";
                break;
            }

        for (int i = 0; i < c; i++)
            if(arrayC[i]>0){
                result = "NO";
                break;
            }

        return result;
    }
}
