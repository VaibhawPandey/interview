package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesAndLadder {

    static int output[];

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        output = new int[t];

        for (int i = 0; i < t; i++) {

            int moves[]=new int[101];
            Arrays.fill(moves,-1);

            int noOfLadders=scanner.nextInt();
            for (int j = 0; j < noOfLadders; j++) {
                int src=scanner.nextInt(),dest=scanner.nextInt();
                moves[src]=dest;
            }

            int noOfSnakes = scanner.nextInt();
            for (int j = 0; j < noOfSnakes; j++) {
                int src=scanner.nextInt(),dest=scanner.nextInt();
                moves[src] = dest;
            }

            boolean visited[]=new boolean[101];

            Queue<Integer> queue=new LinkedList<>();
            queue.add(0);

            output[i]=SnakesAndLadderAlgo(queue,visited,moves);
        }

        for (int i = 0; i < t; i++)
            System.out.println(output[i]);


    }

    private static int SnakesAndLadderAlgo(Queue<Integer> queue, boolean[] visited, int[] moves) {

        int count[]=new int[101];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0]=0;

        while (!queue.isEmpty()){

            int u=queue.poll();

            if (u==100)
                break;

            for (int i = u+1; i <=(u+6) & i < 101; i++) {

                if(!visited[i]) {
                    visited[i] = true;
                    if(moves[i] == -1) {
                        count[i] = count[u] + 1;
                        queue.add(i);
                    }
                    else {
                        count[moves[i]] = Math.min(count[u] + 1,count[moves[i]]);
                        queue.add(moves[i]);
                    }
                }

            }

        }

        return count[100]==Integer.MAX_VALUE? -1:count[100];
    }
}
