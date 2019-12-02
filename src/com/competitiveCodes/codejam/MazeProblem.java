package com.competitiveCodes.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MazeProblem {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }

    public static void main(String[] args) {

        FastReader fastReader=new FastReader();
        int t=fastReader.nextInt();

        List<int[][]> setList=new ArrayList<>();
        String path[]=new String[t];

        for (int i=0;i<t;i++){
            int n = fastReader.nextInt();
            int arr[][]=new int[n][n];
            setList.add(arr);
            path[i]=fastReader.next();
        }

        for (int i = 0; i < t; i++) {
           travelMaze(setList.get(i),path[i],i);
        }

    }

    private static void travelMaze(int[][] arr, String path, int loopCount) {

        int x=0,y=0;
        arr[x][y]=-1;
        for (int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == 'E'){
                y++;
                arr[x][y]=-1;
            }else if(path.charAt(i) == 'S'){
                x++;
                arr[x][y]=-1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }

    }
}
