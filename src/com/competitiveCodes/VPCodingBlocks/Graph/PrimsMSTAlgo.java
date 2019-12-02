package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;

public class PrimsMSTAlgo {

    int V=5;
    private void primAlgo(int[][] graph) {

        boolean mstSet[]=new boolean[V];
        int key[]=new int[V];
        int parent[]=new int[V];

        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(mstSet,false);

        key[0]=0;
        parent[0] = -1;

        for (int count=0;count< V-1;count++){

            int u=minKey(key,mstSet);
            mstSet[u] = true;

            for (int v=0;v<V;v++){
                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int i = 1; i < V; i++)
            System.out.println(parent[i] +"--" +i +"--" +graph[i][parent[i]]);






    }

    private int minKey(int[] key, boolean[] mstSet) {

       int min_position=-1,min_value=Integer.MAX_VALUE;

        for (int v = 0; v < V; v++) {

            if(mstSet[v]==false && key[v] < min_value){
                min_value=key[v];
                min_position=v;
            }

        }

        return min_position;
    }



    public static void main(String[] args) {

        PrimsMSTAlgo primsMSTAlgo=new PrimsMSTAlgo();

        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        primsMSTAlgo.primAlgo(graph);

    }

}
