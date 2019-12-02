package com.practice;

import java.util.Arrays;

public class PrimsAlgo {

    static int V;
    public static void main(String[] args) {

        PrimsAlgo primsMSTAlgo=new PrimsAlgo();

        V = 5;
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        primsMSTAlgo.primAlgo(graph);
    }

    private void primAlgo(int[][] graph) {

        boolean mstSet[] = new boolean[V];
        int key[]=new int[V];
        int parent[]=new int[V];

        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(mstSet,false);

        key[0]=0;
        parent[0] = -1;

        for (int count = 0; count < V-1; count++) {

            int u = minKey(mstSet,key);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    key[v] = graph[u][v];
                    parent[v]=u;
                }
            }
        }

        for (int i = 1; i < V; i++)
            System.out.println(parent[i] +"--" +graph[i][parent[i]]);

    }

    private int minKey(boolean[] mstSet, int[] key) {
        int min_Value = Integer.MAX_VALUE, min_position = -1;

        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min_Value) {
                min_Value = key[v];
                min_position = v;
            }
        }

        return min_position;
    }
}
